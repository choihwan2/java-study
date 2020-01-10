package selftest.java.page106;

public class Cruise extends Ship {

	public Cruise() {
	}

	public Cruise(String shipName, int fuelTank) {
		super(shipName, fuelTank);
	}

	@Override
	void sail(int dist) {
		super.setFuelTank(super.getFuelTank() - dist * 13);
	}

	@Override
	void refuel(int fuel) {super.setFuelTank(super.getFuelTank() - fuel * 10);
		super.setFuelTank(super.getFuelTank() + fuel * 8);
	}

}
