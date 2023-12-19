package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AConnectionExample {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class 존재");			
			
			// 1번 방법
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306?user=사용자명&password=패스워드"
			);
			System.out.println(conn);
			conn.close();
			
			// 2번 방법
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306",
				"사용자명",
				"패스워드"
			);
			System.out.println(conn);
			conn.close();
			
			// 3번 방법
			Properties prop = new Properties();
			prop.setProperty("user", "사용자명");
			prop.setProperty("password","패스워드");
			System.out.println(prop);
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",prop);
			System.out.println(conn);
			conn.close();
			
			// 4번 방법
			File file = new File("src/prop/mysql.properties");
			FileReader reader = new FileReader(file);
			prop = new Properties();
			prop.load(reader);
			
			System.out.println(prop);
			
			String url = prop.getProperty("url");
			System.out.println(url);
			
			conn = DriverManager.getConnection(url,prop);
			System.out.println(conn);
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	
	}

}
