package jp.co.arsware.oopsample;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.arsware.oopsample.ios.ShapeConvertor;
import jp.co.arsware.oopsample.ios.ShapeReader;
import jp.co.arsware.oopsample.ios.ShapeWriter;
import jp.co.arsware.oopsample.shapes.NullShape;
import jp.co.arsware.oopsample.shapes.Shape;

/**
 * キャンバスクラス
 * @author ryouka0122@github
 *
 */
public class MyCanvas extends Canvas {

	/** 図形リスト */
	List<Shape> shapeList;


	/**
	 * コンストラクタ
	 */
	public MyCanvas() {
		shapeList = new ArrayList<Shape>();
	}

	/**
	 * 図形オブジェクトの追加
	 * @param shape
	 */
	void addShape(Shape shape) {
		shapeList.add(shape);
	}

	/**
	 * 図形の全削除
	 */
	public void clear() {
		shapeList.clear();
	}

	/**
	 * 描画
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		// 図形の描画
		for(Shape shape : shapeList) {
			shape.render(g);
		}
	}

	/**
	 * 図形の有無確認
	 * @return
	 */
	public boolean hasShape() {
		return this.shapeList.isEmpty();
	}


	/**
	 * 図形の読み込み
	 * @param file
	 * @throws IOException
	 */
	public void loadFile(File file) throws IOException {
		if(!file.exists()) {
			return;
		}

		// 図形ファイル専用リーダの生成
		try(ShapeReader reader = new ShapeReader(file)) {

			// 図形変換器の生成
			ShapeConvertor convertor = new ShapeConvertor(new NullShape());

			// 変換器の設定
			reader.setShapeConvertor(convertor);

			// 図形リストのリセット
			this.clear();

			// 読み込み
			Shape shape;
			while( (shape=reader.readShape())!=null ) {
				this.shapeList.add(shape);
			}
		}
	}

	/**
	 * 図形の保存
	 * @param file
	 * @throws IOException
	 */
	public void saveFile(File file) throws IOException {
		if(!this.shapeList.isEmpty()) {
			// 図形の出力
			try(ShapeWriter writer = new ShapeWriter(file)) {

				// 図形変換器の生成
				ShapeConvertor convertor = new ShapeConvertor(new NullShape());

				// 変換器の設定
				writer.setShapeConvertor(convertor);

				for(Shape shape : shapeList) {
					if(shape.getType()==null) continue;
					writer.write(shape);
				}
			}
		}
	}
}
