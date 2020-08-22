package ssafy.java.hw0822;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class EmpDB {
	private String driver = "com.mysql.cj.jdbc.Drvier";
	private String url = "jdbc:mysql://localhost:3306/product?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&useSSL=false";
	private String user = "ssafy";
	private String pass = "zmflqh123!";

	public EmpDB() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection connectSever() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, pass);
		return conn;
	}

	public void closeResource(Connection conn, PreparedStatement psmt, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
}
