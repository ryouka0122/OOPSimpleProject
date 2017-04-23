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

	@Override
	public boolean hittest(int canvasPosX, int canvasPosY) {
		// 矩形範囲の内外判定
		// 左側と右側のチェック（X座標テスト）
		if(canvasPosX < posX || canvasPosX >= (posX+width)) {
			return false;
		}
		// 上側と下側のチェック（Y座標テスト）
		if(canvasPosY < posY || canvasPosY >= (posY+height)) {
			return false;
		}
		return true;
	}

}
