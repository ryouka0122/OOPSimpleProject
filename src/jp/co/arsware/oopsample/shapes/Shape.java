package jp.co.arsware.oopsample.shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 描画用オブジェクト
 * @author ryouka0122@github
 *
 */
public abstract class Shape {

	protected int posX;
	protected int posY;
	protected int width;
	protected int height;

	protected Color surfaceColor;

	public Shape() {
		posX = 0;
		posY = 0;
		width = 0;
		height = 0;
		surfaceColor = Color.BLACK;
	}

	/**
	 * 場所の設定
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y) {
		posX = x;
		posY = y;
	}

	/**
	 * 大きさの設定
	 * @param w
	 * @param h
	 */
	public void setSize(int w, int h) {
		width = w;
		height = h;
	}

	/**
	 * カラーの設定
	 * @param color
	 */
	public void setColor(Color color) {
		surfaceColor = color;
	}


	/**
	 * 描画
	 * @param g
	 */
	abstract void render(Graphics g);

}
