package selftest.java.interfaces.page84;

public class Rectangle extends Shape implements Movable {
	int width;

	public Rectangle() {
	}

	public Rectangle(int width, int x, int y) {
		super(new Point(x, y));
		this.width = width;
	}

	@Override
	public void move(int x, int y) {
		Point point = super.getPoint();
		point.setX(point.getX() + x + 2);
		point.setY(point.getY() + y + 2);
	}

	@Override
	double getArea() {
		return width * width;
	}

	@Override
	double getCircumference() {
		return 4 * width;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + " x: " + super.getPoint().getX() + " y: " + super.getPoint().getY() + "]";
	}

}
