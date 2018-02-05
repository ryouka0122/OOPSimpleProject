package jp.co.arsware.oopsample.factories;

import java.awt.Color;

import jp.co.arsware.oopsample.shapes.Shape;

/**
 * 図形インスタンス生成クラス
 * @author ryouka0122@github
 *
 */
public abstract class ShapeFactory {


	/**
	 * 生成メソッド
	 * @return
	 */
	public Shape create() {
		Shape shape = createShape();

		// 場所の設定
		int x = getRandomValue(500);
		int y = getRandomValue(500);
		shape.setPosition(x, y);

		// サイズの設定
		int width = getRandomValue(300);
		int height = getRandomValue(300);
		shape.setSize(width, height);

		// カラーの設定
		int r = getRandomValue(256);
		int g = getRandomValue(256);
		int b = getRandomValue(256);
		shape.setColor(new Color(r,g,b));

		return shape;
	}


	/**
	 * 図形生成メソッド
	 * @return
	 */
	abstract protected Shape createShape();



	/**
	 * 0から引数の値までの間をランダムに返すメソッド
	 * @param maxValue
	 * @return
	 */
	private int getRandomValue(int maxValue) {
		return (int)(Math.random()*maxValue);
	}



}
