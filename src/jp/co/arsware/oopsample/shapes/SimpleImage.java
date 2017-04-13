package jp.co.arsware.oopsample.shapes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 画像オブジェクト
 * @author ryouka0122@github
 *
 */
public class SimpleImage extends Shape {

	/** 画像データ */
	Image image;

	public SimpleImage(File file) {
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 描画
	 * @param g
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(surfaceColor);
		// 描画
		g.drawImage(image, posX, posY, width, height, surfaceColor, null);
	}

}
