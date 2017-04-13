package jp.co.arsware.oopsample.shapes;

import java.awt.Graphics;

/**
 * 四角形オブジェクト
 * @author ryouka0122@github
 *
 */
public class Square extends Shape {

	/**
	 * 描画
	 * @param g
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(surfaceColor);
		g.fillRect(posX, posY, width, height);
	}

}
