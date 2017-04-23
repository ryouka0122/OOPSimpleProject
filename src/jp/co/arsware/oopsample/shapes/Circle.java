package jp.co.arsware.oopsample.shapes;

import java.awt.Graphics;

/**
 * 円オブジェクト
 * @author ryouka0122@github
 *
 */
public class Circle extends Shape {

	/**
	 * 描画
	 * @param g
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(surfaceColor);
		g.fillOval(posX, posY, width, height);
	}

	@Override
	public boolean hittest(int canvasPosX, int canvasPosY) {
		double a = width / 2.0;
		double b = height / 2.0;
		// ヒットテスト値（楕円を考慮した計算式）
		double htValue = b*b * (canvasPosX - (posX + a)) * (canvasPosX - (posX + a))
						+ a*a * (canvasPosY - (posY + b)) * (canvasPosY - (posY + b));
		return (htValue <= a*a*b*b);
	}

}
