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

}
