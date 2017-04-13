package jp.co.arsware.oopsample;

import java.awt.Canvas;
import java.awt.Graphics;

import jp.co.arsware.oopsample.shapes.Circle;

/**
 * キャンバスクラス
 * @author ryouka0122@github
 *
 */
public class MyCanvas extends Canvas {

	Circle circle;

	public MyCanvas() {
		circle = null;
	}

	void setCircle(Circle c) {
		circle = c;
	}

	public void clear() {
		circle = null;
	}


	@Override
	public void paint(Graphics g) {
		circle.render(g);
	}
}
