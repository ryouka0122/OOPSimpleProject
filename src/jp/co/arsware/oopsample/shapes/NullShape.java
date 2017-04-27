package jp.co.arsware.oopsample.shapes;

import java.awt.Graphics;

/**
 * NullObjet
 * @author ryouka0122@github
 *
 */
public class NullShape extends Shape {

	/**
	 * 描画
	 * @param g
	 */
	@Override
	public void render(Graphics g) {

	}

	@Override
	protected Shape cloneShape() {
		return new NullShape();
	}

	@Override
	public String getType() {
		return null;
	}

}
