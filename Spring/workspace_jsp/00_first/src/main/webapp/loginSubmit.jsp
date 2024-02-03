<!-- webapp/loginSubmit.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 요청 처리 확인</title>
</head>
<body>
	<h3>로그인 요청 처리</h3>
	<!-- 
		<%%> 여기서부턴 자바로 코드 처리하겠다고 알려주는 것.
		.jsp도 Servlet의 일종.
	 -->
	<%
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		out.println("uid : " + uid);
		out.println("upw : " + upw);	
	%>
</body>
</html>