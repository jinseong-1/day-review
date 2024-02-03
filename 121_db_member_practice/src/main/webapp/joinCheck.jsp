<%@page import="java.sql.*"%>
<%@page import="vo.MemberVO"%>
<%@page import="util.JDBCUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- 회원가입 요청 처리 - joinCheck.jsp -->
<%
	String id = request.getParameter("id");
	String resultMsg = "";
	String nextPage = "";
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		String sql = "SELECT id FROM pri_member WHERE id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);		// 추가
		rs = pstmt.executeQuery();
		if(rs.next()){
			resultMsg = "이미 존재하는 아이디 입니다.";
			nextPage = "join.jsp";
		}else{
			JDBCUtil.close(pstmt);
			
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender");
			String strAge = request.getParameter("age");
			int age = Integer.parseInt(strAge);
			
			String sqlr = "INSERT INTO pri_member VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sqlr);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, addr);
			pstmt.setString(5, phone);
			pstmt.setString(6, gender);
			pstmt.setInt(7, age);
			
			if(pstmt.executeUpdate() == 1){
				resultMsg = "회원가입 완료";
				nextPage = "index.jsp";
			}
		}
	}catch(Exception e){
		resultMsg = "회원가입 실패";
		nextPage = "join.jsp";
	}finally{
		JDBCUtil.close(pstmt,conn);
	}
%>
<script>
	alert('<%=resultMsg %>');
	location.replace('<%=nextPage%>');
</script>






