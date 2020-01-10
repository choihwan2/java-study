package selftest.java.page106;

import java.util.ArrayList;

public class ShipTest {

	public static void main(String[] args) {
		ArrayList<Ship> ships = new ArrayList<Ship>();
		ships.add(new Boat("Boat01", 500));
		ships.add(new Cruise("Cruise01", 1000));
		for (Ship ship : ships) {
			ship.sail(10);
			System.out.println(ship.getFuelTank());
		}
	}

}
