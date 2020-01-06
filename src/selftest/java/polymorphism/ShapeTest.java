package selftest.java.polymorphism;

public class ShapeTest {

	public static void main(String[] args) {
		Shape shape[] = new Shape[6];

		shape[0] = new Triangle(7, 5, "Blue");
		shape[1] = new Rectangle(4, 6, "Blue");
		shape[2] = new Triangle(6, 7, "Blue");
		shape[3] = new Rectangle(8, 3, "Blue");
		shape[4] = new Triangle(9, 8, "Blue");
		shape[5] = new Rectangle(5, 7, "Blue");
		System.out.println("기본정보");
		for (Shape shape2 : shape) {
			System.out.println(shape2.toString());
		}

		for (int i = 0; i < shape.length; i++) {
			if (shape[i] instanceof Triangle) {
				Triangle temp = (Triangle) shape[i];
				temp.setResize(5);
			} else if (shape[i] instanceof Rectangle) {
				Rectangle temp = (Rectangle) shape[i];
				temp.setResize(5);
			}
		}
		System.out.println("사이즈를 변경 후 정보");
		for (Shape shape2 : shape) {
			System.out.println(shape2.toString());
		}
	}

}
