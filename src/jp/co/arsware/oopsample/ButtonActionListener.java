package jp.co.arsware.oopsample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.co.arsware.oopsample.factories.ShapeFactory;
import jp.co.arsware.oopsample.shapes.Shape;

/**
 * 図形生成ボタンアクションリスナ
 * @author ryouka0122@github
 *
 */
public class ButtonActionListener implements ActionListener {

	/** キャンバス */
	MyCanvas canvas;

	/** 図形ファクトリ */
	ShapeFactory factory;

	/**
	 * コンストラクタ
	 * @param canvas
	 * @param factory
	 */
	public ButtonActionListener(MyCanvas canvas, ShapeFactory factory) {
		this.canvas = canvas;
		this.factory = factory;
	}

	/**
	 * ボタン押下イベント
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 円オブジェクトの生成
		Shape shape = factory.create();

		// 図形オブジェクトを設定
		canvas.addShape(shape);

		// キャンバスを再描画
		canvas.repaint();
	}

}
