package jp.co.arsware.oopsample.shapes;

/**
 * 図形の種類
 * @author ryouka0122@github
 *
 */
public enum ShapeType {
	CIRCLE("circle")
	,SQUARE("square")
	,TRIANGLE("triangle")
	;
	String type;
	private ShapeType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return getType();
	}
}