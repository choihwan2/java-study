package ssafy.java.hw0820;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ProductDB {
	// 1. Driver 로딩
	// 2. DB 연결
	// 3. 쿼리 준비
	// 4. 쿼리 날리기
	// 5. 결과
	// 6. close
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/product?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&useSSL=false";
	private String user = "ssafy4";
	private String password = "zmflqh123!";

	public ProductDB() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}

	public Connection connectDB() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public void closeConnect(Connection conn, PreparedStatement pstm, ResultSet rs) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
