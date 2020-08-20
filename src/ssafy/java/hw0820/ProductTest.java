package ssafy.java.hw0820;

public class ProductTest {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
//		-상품정보를 저장
		System.out.println("상품추가");
		dao.addProduct(new ProductDto("새로 추가된 상품", 50000, 30));
//		-상품 전체 정보 검색
		System.out.println("--------------------상품 전체 검색--------------------");
		dao.findAllProdcut();
//		- 상품명 검색 (상품명의 일부를 입력하면 그 문자열을 포함한 모든 상품정보 를 보여줌)
		System.out.println("--------------------상품 명 검색--------------------");
		dao.findProduct("티비");
//		- 상품가격검색(상품가격을입력하면그가격이하의모든상품정보를보 여줌)
		System.out.println("--------------------상품 가격 검색--------------------");
		dao.findLowPriceProdcut(2000);
//		- 제품번호로 검색
		System.out.println("--------------------상품 번호 검색--------------------");
		dao.findProduct(3);
//		- 제품번호로 삭제
		System.out.println("--------------------상품 번호 삭제--------------------");
		dao.deleteProduct(4);
//		- 제품번호와 가격으로 같은 번호를 찾아 가격 업데이트 기능
		System.out.println("--------------------상품 번호 업데이트--------------------");
		dao.updateProduct(5, 200000);
		dao.findAllProdcut();
	}
}
