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

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * カラーの設定
	 * @param color
	 */
	public void setColor(Color color) {
		surfaceColor = color;
	}

	public Color getColor() {
		return surfaceColor;
	}

	/**
	 * 描画
	 * @param g
	 */
	abstract public void render(Graphics g);

	/**
	 * 図形の複製
	 * @return
	 */
	public Shape duplicate() {
		Shape shape = cloneShape();
		shape.posX = this.posX;
		shape.posY = this.posY;
		shape.width = this.width;
		shape.height = this.height;
		shape.surfaceColor = new Color(
				this.surfaceColor.getRed()
				,this.surfaceColor.getGreen()
				,this.surfaceColor.getBlue());
		return shape;
	}

	/**
	 * 図形の生成
	 * @return
	 */
	abstract protected Shape cloneShape();

	/**
	 * 図形の種類の取得
	 * @return
	 */
	abstract public String getType();
}
