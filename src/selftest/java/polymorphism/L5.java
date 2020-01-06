package selftest.java.polymorphism;

public class L5 extends Car implements Temp {
	public L5() {
	}

	public L5(String name, String engine, int oilTank, int oilSize, int distance) {
		super(name, engine, oilTank, oilSize, distance);
	}

	@Override
	public int getTempGage() {
		return getDistance() / 5;
	}

	@Override
	void go(int distance) {
		super.setDistance(getDistance() + distance);
		setOilSize(getOilSize() - distance / 8);
	}

	@Override
	void setOil(int oilSize) {
		super.setOilSize(getOilSize() + oilSize);;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getEngine() + " " + getOilTank() + " " + getOilSize() + " " + getDistance() + " " + getTempGage();
	}

}
