package jp.co.arsware.oopsample.ios;

import java.awt.Color;

import jp.co.arsware.oopsample.shapes.Circle;
import jp.co.arsware.oopsample.shapes.NullShape;
import jp.co.arsware.oopsample.shapes.Shape;
import jp.co.arsware.oopsample.shapes.ShapeType;
import jp.co.arsware.oopsample.shapes.Square;
import jp.co.arsware.oopsample.shapes.Triangle;

/**
 * 図形変換器
 * @author ryouka0122@github
 *
 */
public class ShapeConvertor {

	static final int SHAPE_TYPE = 0;
	static final int SHAPE_POS_X = 1;
	static final int SHAPE_POS_Y = 2;
	static final int SHAPE_SIZE_W = 3;
	static final int SHAPE_SIZE_H = 4;
	static final int SHAPE_COLOR_R = 5;
	static final int SHAPE_COLOR_G = 6;
	static final int SHAPE_COLOR_B = 7;

	static final int SHAPE_INFO_SIZE = 8;

	static final String SPLIT_CHARACTER = ",";

	Shape defaultShape;

	/**
	 * デフォルトコンストラクタ
	 */
	public ShapeConvertor() {
		this(new NullShape());
	}

	/**
	 * コンストラクタ（デフォルト図形オブジェクト付き）
	 */
	public ShapeConvertor(Shape defaultShape) {
		this.defaultShape = defaultShape;
	}

	/**
	 * 解析時に失敗したときの図形オブジェクトの設定
	 * @param defaultShape
	 */
	public void setDefaultShape(Shape defaultShape) {
		this.defaultShape = defaultShape;
	}

	/**
	 * 保存データから図形オブジェクトに変換するメソッド
	 * @param line
	 * @return
	 */
	public Shape createShape(String line) {
		// データ項目に変換
		String[] datas = line.split(SPLIT_CHARACTER);

		// 種類・位置，サイズ，色の順番に保存されているので，
		// 各項目ごとに変換処理をしてShapeに設定する
		String type   = datas[SHAPE_TYPE];
		int posX   = str2int(datas[SHAPE_POS_X]);
		int posY   = str2int(datas[SHAPE_POS_Y]);
		int width  = str2int(datas[SHAPE_SIZE_H]);
		int heigth = str2int(datas[SHAPE_SIZE_W]);
		int red    = str2int(datas[SHAPE_COLOR_R]);
		int green  = str2int(datas[SHAPE_COLOR_G]);
		int blue   = str2int(datas[SHAPE_COLOR_B]);

		// 図形の生成
		Shape shape = create(type);

		// 位置の設定
		shape.setPosition(posX, posY);

		// サイズの設定
		shape.setSize(width, heigth);

		// 色の設定
		shape.setColor(new Color(red, green, blue));

		return shape;
	}

	public String createData(Shape shape) {
		String[] data = new String[SHAPE_INFO_SIZE];

		data[SHAPE_TYPE] = shape.getType();
		data[SHAPE_POS_X] = int2str(shape.getX());
		data[SHAPE_POS_Y] = int2str(shape.getY());
		data[SHAPE_SIZE_W] = int2str(shape.getWidth());
		data[SHAPE_SIZE_H] = int2str(shape.getHeight());
		Color c = shape.getColor();
		data[SHAPE_COLOR_R] = int2str(c.getRed());
		data[SHAPE_COLOR_G] = int2str(c.getGreen());
		data[SHAPE_COLOR_B] = int2str(c.getBlue());

		return joinArray(data, SPLIT_CHARACTER);
	}

	/**
	 * 文字列の連結処理
	 * @param data
	 * @param splitCharacter
	 * @return
	 */
	private String joinArray(String[] data, String splitCharacter) {
		StringBuilder sb = new StringBuilder();
		for(String str : data) {
			sb.append(splitCharacter).append(str);
		}
		return sb.substring(splitCharacter.length());
	}

	/**
	 * 文字列から整数に変換するメソッド
	 * @param num
	 * @return
	 */
	private int str2int(String num) {
		try{
			return Integer.parseInt(num);
		}catch(NumberFormatException nfe) {
			return 0;
		}
	}

	/**
	 * 整数から文字列に変換するメソッド
	 * @param num
	 * @return
	 */
	private String int2str(int num) {
		return Integer.toString(num);
	}

	/**
	 * 図形の種類からオブジェクトを生成
	 * @param type
	 * @return
	 */
	private Shape create(String type) {
		ShapeType shapeType = convertType(type);
		if(shapeType==null) {
			return this.defaultShape.duplicate();
		}
		switch(shapeType) {
		case CIRCLE:
			return new Circle();
		case SQUARE:
			return new Square();
		case TRIANGLE:
			return new Triangle();
		default:
			return this.defaultShape.duplicate();
		}
	}

	private ShapeType convertType(String type) {
		ShapeType[] ts = ShapeType.values();
		for(ShapeType t : ts) {
			if(t.getType().equals(type)) {
				return t;
			}
		}
		return null;
	}

}
