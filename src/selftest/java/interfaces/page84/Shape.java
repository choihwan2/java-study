package selftest.java.interfaces.page84;

public abstract class Shape {
	Point point;
	public Shape() {
	}
	
	public Shape(Point point) {
		super();
		this.point = point;
	}
	abstract double getArea();
	
	abstract double getCircumference();

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	
	
	
}
