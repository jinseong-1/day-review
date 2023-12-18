package base;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class APreparedStatementExample {

	public static void main(String[] args) {
		
		Connection aconn = null;
		// 동적인 쿼리 객체 - 나중에 값을 추가하는 것
		PreparedStatement apstmt = null;
		ResultSet ars = null;

		try {
			aconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb","사용자명","패스워드");
			System.out.println("DB 연결 완료");
			
			// 등록할 질의
			String sql = "select userID, name, birthYear, addr FROM userTbl WHERE userID = ?";
			apstmt = aconn.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("검색할 회원의 아이디를 작성해주세요.");
			String id = sc.next();
			
			apstmt.setString(1, id);
			
			ars = apstmt.executeQuery();
			
			if(ars.next()) {
				String userId = ars.getString("userId");
				String name = ars.getString(2);
				int birthYear = ars.getInt(3);
				String addr = ars.getString(4);
				System.out.println(userId + ":" + name + ":" + birthYear +":"+addr);
				System.out.println("검색 완료");
			}else {
				System.out.println(id + "값은 존재하지 않습니다");
			}
			
			// 삽입되어 있는 데이터에 추가로 넣기
			System.out.println("회원 정보 검색");
			ars.close();
			apstmt.close();
			
			sql = "UPDATE userTbl SET moblie1 = ? ,"
					+"moblie2=?,"
					+"height=?,"
					+"mDate=?"
					+"WHERE userID = ?";
			System.out.println(sql);
			
			apstmt = aconn.prepareStatement(sql);
			apstmt.setString(1, "010");
			apstmt.setString(2, "23457654");
			apstmt.setInt(3, 190);
			java.sql.Date date = new Date(System.currentTimeMillis());
			apstmt.setDate(4, date);
			apstmt.setString(5, "id");
			
			int result = apstmt.executeUpdate();
			System.out.println(result + "개의 행이 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ars!=null) {
				try {
					ars.close();
				} catch (SQLException e) {}
			}
			if(apstmt != null) {
				try {
					apstmt.close();
				} catch (Exception e) {}
			}
		}
	}

}
