package selftest.java.polymorphism;

public class L3 extends Car implements Temp {
	public L3() {
	}

	public L3(String name, String engine, int oilTank, int oilSize, int distance) {
		super(name, engine, oilTank, oilSize, distance);
	}

	@Override
	public int getTempGage() {
		return getDistance() / 10;
	}

	@Override
	void go(int distance) {
		super.setDistance(getDistance() + distance);
		setOilSize(getOilSize() - distance / 10);
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
