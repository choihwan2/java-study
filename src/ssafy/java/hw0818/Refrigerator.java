package ssafy.java.hw0818;

public class Refrigerator extends Product {
	private double capacity;

	public Refrigerator(int no, String name, int price, int amount, double capacity) {
		super(no, name, price, amount);
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "냉장고 제품 번호: " + super.getNo() + ", 제품 이름: " + super.getName() + ", 가격: " + super.getPrice() + ", 수량: "
				+ super.getAmount() + ", 용량: " + capacity;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	
	
}
