package ssafy.java.hw0820;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao extends ProductDB {

	/*
	 * -- -상품 전체 정보 검색 SELECT * FROM product; -- - 상품명 검색 (상품명의 일부를 입력하면 그 문자열을 포함한
	 * 모든 상품정보 를 보여줌) SELECT * FROM product where name like '%~~~%'; -- -
	 * 상품가격검색(상품가격을입력하면그가격이하의모든상품정보를보 여줌) SELECT * FROM product where price <= '가격';
	 * -- - 제품번호로 검색 SELECT * FROM product where no='번호'; -- - 제품번호로 삭제 DELETE FROM
	 * product where no='번호'; -- - 제품번호와 가격으로 같은 번호를 찾아 가격 업데이트 기능 UPDATE proudct
	 * set price='가격' where no='번호';
	 * 
	 */
	private final String addProductSQL = "INSERT INTO product(name, price, amount) VALUES (?,?,?)";
	private final String findAllProductSQL = "SELECT * FROM product";
	private final String findNameProductSQL = "SELECT * FROM product WHERE name like ?";
	private final String findLowPriceProductSQL = "SELECT * FROM product where price <= ?";
	private final String findNoProductSQL = "SELECT * FROM product where no=?";
	private final String deleteProductSQL = "DELETE FROM product where no=?";
	private final String updateProductSQL = "UPDATE proudct set price= ? where no= ?";

	public ProductDao() {
	}

	public void addProduct(ProductDto product) {
		try {
			Connection conn = connectDB();
			PreparedStatement pstm = conn.prepareStatement(addProductSQL);
			pstm.setString(1, product.getName());
			pstm.setInt(2, product.getPrice());
			pstm.setInt(3, product.getAmount());
			int n = pstm.executeUpdate();
			if (n != 0) {
				System.out.println("상품 추가 성공!");
			} else {
				System.out.println("상품 추가 실패");
			}
			closeConnect(conn, pstm, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void findAllProdcut() {
		try {
			Connection conn = connectDB();
			PreparedStatement pstm = conn.prepareStatement(findAllProductSQL);
			ResultSet rs = pstm.executeQuery();
			StringBuilder stb = makeString(rs);
			System.out.println(stb.toString());
			closeConnect(conn, pstm, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void findLowPriceProdcut(int price) {
		try {
			Connection conn = connectDB();
			PreparedStatement pstm = conn.prepareStatement(findLowPriceProductSQL);
			pstm.setInt(1, price);
			ResultSet rs = pstm.executeQuery();
			StringBuilder stb = makeString(rs);
			System.out.println(stb.toString());
			closeConnect(conn, pstm, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void findProduct(String name) {
		Connection conn;
		try {
			conn = connectDB();
			PreparedStatement pstm = conn.prepareStatement(findNameProductSQL);
			pstm.setString(1, "%" + name + "%");
			ResultSet rs = pstm.executeQuery();
			StringBuilder stb = makeString(rs);
			System.out.println(stb.toString());
			closeConnect(conn, pstm, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void findProduct(int no) {
		Connection conn;
		try {
			conn = connectDB();
			PreparedStatement pstm = conn.prepareStatement(findNoProductSQL);
			pstm.setInt(1, no);
			ResultSet rs = pstm.executeQuery();
			StringBuilder stb = makeString(rs);
			System.out.println(stb.toString());
			closeConnect(conn, pstm, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteProduct(int no) {
		try {
			Connection conn = connectDB();
			PreparedStatement pstm = conn.prepareStatement(deleteProductSQL);
			pstm.setInt(1, no);
			int n = pstm.executeUpdate();
			if (n != 0) {
				System.out.println("상품번호 " + no + "을 삭제하였습니다.");
			} else {
				System.out.println("그런 상품이 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateProduct(int no, int price) {
		try {
			Connection conn = connectDB();
			PreparedStatement pstm = conn.prepareStatement(updateProductSQL);
			pstm.setInt(1, price);
			pstm.setInt(2, no);
			int n = pstm.executeUpdate();
			if (n > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	private StringBuilder makeString(ResultSet rs) throws SQLException {
		StringBuilder stb = new StringBuilder();
		while (rs.next()) {
			stb.append("상품 번호: ");
			stb.append(rs.getInt(1));
			stb.append(" 이름: ");
			stb.append(rs.getString(2));
			stb.append(" 가격: ");
			stb.append(rs.getInt(3));
			stb.append(" 수량: ");
			stb.append(rs.getInt(4));
			stb.append("\n");
		}
		if (stb.length() == 0) {
			stb.append("찾고자 하는 상품이 없습니다.");
		}

		return stb;
	}
}
