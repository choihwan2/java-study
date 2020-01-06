package selftest.java.polymorphism;

abstract class Car {
	private String name;
	private String engine;
	private int oilTank;
	private int oilSize;
	private int distance;
	
	public Car() {
	}

	public Car(String name, String engine, int oilTank, int oilSize, int distance) {
		super();
		this.name = name;
		this.engine = engine;
		this.oilTank = oilTank;
		this.oilSize = oilSize;
		this.distance = distance;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getOilTank() {
		return oilTank;
	}

	public void setOilTank(int oilTank) {
		this.oilTank = oilTank;
	}

	public int getOilSize() {
		return oilSize;
	}

	public void setOilSize(int oilSize) {
		this.oilSize = oilSize;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	abstract void go(int distance);
	
	abstract void setOil(int oilSize);

	
	
}
