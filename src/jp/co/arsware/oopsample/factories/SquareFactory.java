package jp.co.arsware.oopsample.factories;

import jp.co.arsware.oopsample.shapes.Shape;
import jp.co.arsware.oopsample.shapes.Square;

/**
 * 四角形オブジェクト生成クラス
 * @author ryouka0122@github
 *
 */
public class SquareFactory extends ShapeFactory {

	@Override
	protected Shape createShape() {
		return new Square();
	}

}
