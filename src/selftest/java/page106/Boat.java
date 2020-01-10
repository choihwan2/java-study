package selftest.java.page106;

public class Boat extends Ship {

	public Boat() {
	}

	public Boat(String shipName, int fuelTank) {
		super(shipName, fuelTank);
	}

	@Override
	void sail(int dist) {
		super.setFuelTank(super.getFuelTank() - dist * 10);
	}

	@Override
	void refuel(int fuel) {super.setFuelTank(super.getFuelTank() - fuel * 10);
		super.setFuelTank(super.getFuelTank() + fuel * 10);
	}

}
