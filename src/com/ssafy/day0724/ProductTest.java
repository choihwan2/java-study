package com.ssafy.day0724;

import java.util.Scanner;

public class ProductTest {
	static Scanner sc = new Scanner(System.in);
	static ProductMgr mgr = ProductMgr.getInstance();

	public static void main(String[] args) {
		printMenu();
		while (true) {
			System.out.println("원하시는 메뉴를 입력해주세요.");
			int input = sc.nextInt();
			sc.nextLine();
			if (input == 1) {
				addProduct();
			} else if (input == 2) {
				showProducts();
			} else if (input == 3) {
				searchProductNo();
			} else if (input == 4) {
				deleteProduct();
			} else if (input == 5) {
				searchProductPrice();
			} else if (input == 9) {
				printMenu();
			} else if (input == 0) {
				System.out.println("종료되었습니다. 감사합니다.");
				break;
			}
		}
	}

	private static void searchProductPrice() {
		System.out.println("특정가격을 입력해주시면 그 이하의 상품을 찾아드립니다.");
		int input = sc.nextInt();
		sc.nextLine();
		mgr.priceList(input);
	}

	private static void deleteProduct() {
		System.out.println("삭제하고자 하는 상품 번호를 입력해주세요");
		int input = sc.nextInt();
		sc.nextLine();
		mgr.delete(input);
	}

	private static void searchProductNo() {
		System.out.println("찾고자하는 상품번호를 입력해주세요");
		int input = sc.nextInt();
		sc.nextLine();
		mgr.list(input);
	}

	private static void showProducts() {
		System.out.println("상품 전체 목록입니다.");
		mgr.list();
	}

	public static void printMenu() {
		System.out.println("Abc 디지털 대리점 재고 관리 프로그램입니다.");
		System.out.println("1. 상품 등록");
		System.out.println("2. 상품 목록 보기");
		System.out.println("3. 상품 번호 검색");
		System.out.println("4. 상품 삭제");
		System.out.println("5. 특정 가격이하 검색");
		System.out.println("9. 메뉴보기");
		System.out.println("0. 종료");
	}

	public static void addProduct() {
		System.out.println("상품 등록 페이지입니다.");
		System.out.println("상품번호(숫자)/상품이름/수량/가격 형식으로 입력해주세요.");
		String[] input = sc.nextLine().split("/");
		mgr.add(new Product(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]),
				Integer.parseInt(input[3])));

	}
}
