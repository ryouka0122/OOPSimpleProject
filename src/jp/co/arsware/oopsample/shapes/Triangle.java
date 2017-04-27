package jp.co.arsware.oopsample.shapes;

import java.awt.Graphics;

/**
 * 三角形オブジェクト
 * @author ryouka0122@github
 *
 */
public class Triangle extends Shape {

	/**
	 * 描画
	 * @param g
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(surfaceColor);
		// 描画は▲のイメージ

		int ptX[] = new int[3];
		int ptY[] = new int[3];

		// 頂点座標の設定
		ptX[0] = posX + width / 2;
		ptY[0] = posY;
		ptX[1] = posX + width;
		ptY[1] = posY + height;
		ptX[2] = posX;
		ptY[2] = posY + height;

		// 描画
		g.fillPolygon(ptX, ptY, 3);
	}

	@Override
	protected Shape cloneShape() {
		return new Triangle();
	}

	@Override
	public String getType() {
		return  ShapeType.TRIANGLE.getType();
	}

}
