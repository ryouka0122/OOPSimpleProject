package jp.co.arsware.oopsample.factories;

import jp.co.arsware.oopsample.shapes.Circle;
import jp.co.arsware.oopsample.shapes.Shape;

/**
 * 円オブジェクト生成クラス
 * @author ryouka0122@github
 *
 */
public class CircleFactory extends ShapeFactory {

	@Override
	protected Shape createShape() {
		return new Circle();
	}

}
