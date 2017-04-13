package jp.co.arsware.oopsample.factories;

import java.awt.Frame;

import javax.swing.JFileChooser;

import jp.co.arsware.oopsample.shapes.NullShape;
import jp.co.arsware.oopsample.shapes.Shape;
import jp.co.arsware.oopsample.shapes.SimpleImage;

/**
 * 画像インスタンス生成クラス
 * @author ryouka0122@github
 *
 */
public class ImageFactory extends ShapeFactory {

	/** ファイル選択ダイアログ */
	JFileChooser chooser = new JFileChooser();

	/** 親コンポーネント */
	Frame parent;

	/**
	 * コンストラクタ
	 * @param parent
	 */
	public ImageFactory(Frame parent) {
		this.parent = parent;
	}


	@Override
	protected Shape createShape() {

		int result = chooser.showOpenDialog(parent);

		Shape shape;
		if(result ==JFileChooser.APPROVE_OPTION) {
			// ダイアログで選択されたとき
			shape = new SimpleImage(chooser.getSelectedFile());
		}else{
			// キャンセルされたとき
			shape = new NullShape();
		}
		return shape;
	}

}
