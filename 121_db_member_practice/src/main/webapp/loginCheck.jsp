<%@page import="vo.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- 로그인 요청 처리 페이지 - loginCheck.jsp -->
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");

	Connection conn = JDBCUtil.getConnection();
	System.out.println(conn);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String resultMsg = "";
	String nextPage = "";
	
	String sql = "SELECT * FROM pri_member WHERE id=? AND pass=?";
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pass);
		rs = pstmt.executeQuery();
		if(rs.next()){
			resultMsg = "로그인 성공";
			nextPage = "index.jsp";
			// 로그인 성공 후 처리 - 회원정보를 가져와서 저장시켜놓아야함
			MemberVO loginMember = new MemberVO(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5),
				rs.getString(6),
				rs.getString(7),
				rs.getInt(8)
			);
			session.setAttribute("login",loginMember);
			
			// 로그인 상태 유지
			String login = request.getParameter("login");
			if(login != null){
				byte[] bytes = id.getBytes();
				byte[] encodedID = java.util.Base64.getEncoder().encode(bytes);
				System.out.println("id : " + id);
				id = new String(encodedID);
				System.out.println("encoded : " + id);
			
			// 자동로그인 항목 선택시
			Cookie cookie = new Cookie("rememberMe",id);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			}
		}else{
			resultMsg = "ID와 PASSWORD를 확인해주세요";
			nextPage = "login.jsp";
		}	
		
	}catch(Exception e){
		resultMsg = "조회 불가능" + e.toString();
		nextPage = "login.jsp";
	}finally{
		JDBCUtil.close(pstmt,conn);
	}
%>
<script>
	alert('<%=resultMsg%>');
	location.replace('<%=nextPage%>');
</script>





