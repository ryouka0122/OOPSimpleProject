package jp.co.arsware.oopsample;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

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
}
