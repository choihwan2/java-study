package selftest.java.polymorphism;

public class CarTest {

	public static void main(String[] args) {
		Car car[] = new Car[2];
		car[0] = new L3("L3","1500",50,25,0);
		car[1] = new L5("L5","2000",75,35,0);
		
		for (Car car2 : car) {
			System.out.println(car2.toString());
		}
		System.out.println();
		for (int i = 0; i < car.length; i++) {
			car[i].setOil(25);
			System.out.println(car[i].toString());
		}
		System.out.println();
		
		for (int i = 0; i < car.length; i++) {
			Car car2 = car[i];
			car2.go(80);
			System.out.println(car2.toString());
		}
		
	}

}
