package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/develop_jsp",
					"developer",
					"12345"
			);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class를 찾을 수 없음");
		}catch (SQLException e) {
			System.out.println("연결 요청 정보 오류 : " + e.toString());
		}
		return conn;
	}
	
	public static void close(AutoCloseable... closer) {
		for(AutoCloseable c : closer) {
			if(c != null) {
				try {
					c.close();
				} catch (Exception e) {}
			}
		}
	}
	
}
