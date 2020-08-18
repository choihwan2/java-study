package ssafy.java.hw0818;

public interface IProudctMgr {
	// 상품저장
	public void add(Product p);

	// 상품 정보 전체 검색
	public Product[] searchAllProduct();

	// 상품 번호로 상품 검색
	public Product[] searchProduct(int no);

//	- 상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
	public Product[] searchProduct(String name);

//	- TV정보만 검색
	public Product[] searchTV();

//	- Refrigerator만 검색
	public Product[] searchRefrigerator();

//	- 400L 이상의 Refrigerator 검색
	public Product[] search400LRefrigeratort();

//	- 50inch 이상의 TV검색
	public Product[] search50InchTv();

//	- 상품번호와가격을입력받아상품가격을변경할수있는기능
	public void changeProductPrice(int no, int price);

//	- 상품번호로 상품을 삭제하는 기능
	public void deleteProduct(int no);

//	- 전체재고상품금액을구하는기능
	public int getAmountPriceSum();
	
//	- 파일 product.dat에 상품 내용 저장하기
	public void makeProductdat();
	
//  - 서버로 상품 정보 내보내기
	public void sendProductToServer();
	
}
