package com.ssafy.day0724;

public class ProductMgr {
	private Product[] products = new Product[5];
	private int index = 0;
	private static ProductMgr pmg;

	private ProductMgr() {

	}

	public static ProductMgr getInstance() {
		if (pmg == null)
			pmg = new ProductMgr();
		return pmg;
	}

	public void add(Product p) {
		if (index >= 0 && index <= 99) {
			products[index++] = p;
		}
	}

	public void list() {
		for (int i = 0; i < index; i++) {
			System.out.println(products[i]);
		}
	}

	public void list(int num) {
		for (int i = 0; i < index; i++) {
			if (products[i].getNo() == num)
				System.out.println(products[i]);
		}
	}

	public void delete(int num) {
		for (int i = 0; i < index; i++) {
			if (products[i].getNo() == num) {
				if (i != index - 1)
					System.arraycopy(products, i + 1, products, i, 4 - i);
				products[--index] = null;
				i--;
			}
		}
	}

	public void priceList(int price) {
		for (int i = 0; i < index; i++) {
			if (products[i].getPrice() <= price) {
				System.out.println(products[i]);
			}
		}
	}
}
