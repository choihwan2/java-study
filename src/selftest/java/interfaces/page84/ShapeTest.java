package selftest.java.interfaces.page84;

public class ShapeTest {

	public static void main(String[] args) {
		Shape shape[] = new Shape[4];
		shape[0] = new Rectangle(4, 7, 5);
		shape[1] = new Rectangle(5, 4, 6);
		shape[2] = new Circle(6, 6, 7);
		shape[3] = new Circle(7, 8, 3);
		
		for (Shape shape2 : shape) {
			System.out.println(shape2.toString());
		}
		System.out.println();
		for (int i = 0; i < shape.length; i++) {
			Shape shape2 = shape[i];
			if(shape2 instanceof Rectangle) {
				Rectangle temp = (Rectangle) shape2;
				temp.move(10, 10);
			} else if (shape2 instanceof Circle) {
				Circle temp = (Circle) shape2;
				temp.move(10, 10);
			}
			System.out.println(shape2.toString());
		}
	}

}
