package selftest.java.page106;

public abstract class Ship {
	private String shipName;
	private int fuelTank;

	public Ship() {
	}

	public Ship(String shipName, int fuelTank) {
		super();
		this.shipName = shipName;
		this.fuelTank = fuelTank;
	}

	abstract void sail(int dist);

	abstract void refuel(int fuel);

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public int getFuelTank() {
		return fuelTank;
	}

	public void setFuelTank(int fuelTank) {
		this.fuelTank = fuelTank;
	}

}
