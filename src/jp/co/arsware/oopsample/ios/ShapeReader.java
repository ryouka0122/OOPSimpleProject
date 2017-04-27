package jp.co.arsware.oopsample.ios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import jp.co.arsware.oopsample.shapes.Shape;

public class ShapeReader extends BufferedReader {

	ShapeConvertor convertor;

	public ShapeReader(File file) throws FileNotFoundException {
		super(new FileReader(file));
		this.convertor = new ShapeConvertor();
	}

	public void setShapeConvertor(ShapeConvertor convertor) {
		this.convertor = convertor;
	}

	public Shape readShape() throws IOException {
		String line = readLine();
		if(line==null || line.isEmpty()) {
			return null;
		}
		return convertor.createShape(line);
	}

}
