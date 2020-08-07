package com.ssafy.day0724;

public class Product {
	// 번호, 상품이름 ,수량, 가격
	private int no;
	private String name;
	private int amount;
	private int price;

	public Product(int no, String name, int amount, int price) {
		super();
		this.no = no;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", amount=" + amount + ", price=" + price + "]";
	}

}
