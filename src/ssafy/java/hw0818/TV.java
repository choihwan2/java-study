package ssafy.java.hw0818;

public class TV extends Product {
	private double inch;
	private String displayType;

	public TV(int no, String name, int price, int amount, double inch, String displayType) {
		super(no, name, price, amount);
		this.inch = inch;
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return "TV의 제품 번호:" + super.getNo() + ", 제품 이름:" + super.getName() + ", 가격:" + super.getPrice() + ", 수량:"
				+ super.getAmount() + ", 인치:" + inch + ", 디스플레이타입:" + displayType;
	}

	public double getInch() {
		return inch;
	}

	public void setInch(double inch) {
		this.inch = inch;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	
	

}
