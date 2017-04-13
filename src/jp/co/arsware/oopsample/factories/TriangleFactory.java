package jp.co.arsware.oopsample.factories;

import jp.co.arsware.oopsample.shapes.Shape;
import jp.co.arsware.oopsample.shapes.Triangle;

/**
 * 三角形オブジェクト生成クラス
 * @author ryouka0122@github
 *
 */
public class TriangleFactory extends ShapeFactory {

	@Override
	protected Shape createShape() {
		return new Triangle();
	}

}
