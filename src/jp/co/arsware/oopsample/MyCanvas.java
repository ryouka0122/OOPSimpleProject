package jp.co.arsware.oopsample;

import java.awt.Canvas;
import java.awt.Graphics;

import jp.co.arsware.oopsample.shapes.Circle;
import jp.co.arsware.oopsample.shapes.Square;

/**
 * キャンバスクラス
 * @author ryouka0122@github
 *
 */
public class MyCanvas extends Canvas {

	/** 円 */
	Circle circle;

	/** 四角形 */
	Square square;

	/**
	 * コンストラクタ
	 */
	public MyCanvas() {
		circle = null;
		square = null;
	}

	/**
	 * 円オブジェクトの追加
	 * @param c
	 */
	void setCircle(Circle c) {
		circle = c;
	}

	/**
	 * 四角形オブジェクトの追加
	 * @param c
	 */
	public void setSquare(Square s) {
		square = s;
	}

	public void clear() {
		circle = null;
		square = null;
	}


	@Override
	public void paint(Graphics g) {
		// 円の描画
		if(circle != null) {
			circle.render(g);
		}

		// 四角形の描画
		if(square != null) {
			square.render(g);
		}
	}
}
