package ssafy.java.hw0818;

public class ProductTest {
	static ProductMgrImpl mgr = new ProductMgrImpl();

	public static void main(String[] args) {

		// 상품 추가
		mgr.add(new TV(1, "LGTV", 10000, 5, 72, "UHD"));
		mgr.add(new TV(2, "SAMSUNG TV", 50000, 2, 88, "RED UHD"));
		mgr.add(new Refrigerator(3, "LG 냉장고", 120000, 4, 89));
		mgr.add(new Refrigerator(4, "삼성 냉장고", 180000, 2, 66));
		mgr.add(new Refrigerator(5, "엄청큰 냉장고", 3000000, 2, 450));
		mgr.add(new TV(6, "엄청큰 TV", 3000000, 2, 90, "HD"));
		mgr.add(new TV(7, "엄청 작은 TV", 3000000, 2, 23, "HD"));
		// 상품 전체목록 조회
		printProducts();

		// 상품 번호로 검색
		Product[] searchNoProducts = mgr.searchProduct(1);
		System.out.println("상품번호 1번 검색");
		printProducts(searchNoProducts);

		// 상품 이름으로 검색
		Product[] searchNameProducts = mgr.searchProduct("LG 냉장고");
		System.out.println("LG 냉장고 상품 이름 검색");
		printProducts(searchNameProducts);

		// TV 제품만 검색
		Product[] searchTvProducts = mgr.searchTV();
		System.out.println("TV 상품만 검색");
		printProducts(searchTvProducts);

		// 냉장고 제품들만 검색
		Product[] searchRefrigeratorProducts = mgr.searchRefrigerator();
		System.out.println("냉장고 상품만 검색");
		printProducts(searchRefrigeratorProducts);

		// 50 인치 이상 TV 제품만 검색
		Product[] search50TvProducts = mgr.search50InchTv();
		System.out.println("50inch 이상 TV 상품만 검색");
		printProducts(search50TvProducts);
		
		// 냉장고 제품들만 검색
		Product[] search400RefrigeratorProducts = mgr.search400LRefrigeratort();
		System.out.println("400L 이상 냉장고 상품만 검색");
		printProducts(search400RefrigeratorProducts);
		
		// 상품 가격 변경
		System.out.println("3번 상품 50만원으로 변경");
		mgr.changeProductPrice(3, 500000);
		printProducts();
		
		// 상품 번호로 삭제
		mgr.deleteProduct(3);
		System.out.println("3번 상품 삭제");
		printProducts();

		// 상품 재고 총액 확인
		int sum = mgr.getAmountPriceSum();
		System.out.println("상품 재고의 총액은 " + sum);
		
		// 상품 내용들 파일로 저장
		mgr.makeProductdat();
		System.out.println("상품내용들을 파일로 저장하였습니다.");
		
		// 상품 내용들 서버로 전송
		mgr.sendProductToServer();
	}

	private static void printProducts() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("상품 전체 내용 출력");
		for (Product product : mgr.searchAllProduct()) {
			System.out.println(product);
		}
		System.out.println("--------------------------------------------------------------------------");
	}

	private static void printProducts(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i]);
		}
		System.out.println("--------------------------------------------------------------------------");
	}
}
