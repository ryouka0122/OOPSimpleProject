package jp.co.arsware.oopsample.ios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jp.co.arsware.oopsample.shapes.Shape;

public class ShapeWriter extends BufferedWriter {

	ShapeConvertor convertor;
	/**
	 * コンストラクタ
	 * @param writer
	 * @throws IOException
	 */
	public ShapeWriter(File file) throws IOException {
		super(new FileWriter(file));
		this.convertor = new ShapeConvertor();
	}


	public void setShapeConvertor(ShapeConvertor convertor) {
		this.convertor = convertor;
	}

	/**
	 * 出力メソッド
	 * @param shape
	 * @throws IOException
	 */
	public void write(Shape shape) throws IOException {
		append(this.convertor.createData(shape));
		newLine();
	}

}
