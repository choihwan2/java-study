package selftest.java.interfaces.page84;

public class Circle extends Shape implements Movable {
	int radius;
	public Circle() {
	}
	
	public Circle(int radius, int x, int y) {
		super(new Point(x,y));
		this.radius = radius;
	}
	@Override
	public void move(int x, int y) {
		Point point = super.getPoint();
		point.setX(point.getX() + x + 1);
		point.setY(point.getY() + y + 1);
	}

	@Override
	double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	double getCircumference() {
		return Math.PI * 2 * radius;
	}
	
	@Override
	public String toString() {
		return "Circle [radius=" + radius + " x: " + super.getPoint().getX() + " y: " + super.getPoint().getY() + "]";
	}

}
