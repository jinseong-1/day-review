<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- logout.jsp -->
<%
	// session에 등록된 정보 삭제
	session.removeAttribute("login");

	// 사용자 브라우저에 저장된 cookie는 강제로 삭제할수있는 방법이 없으므로
	// cookie 저장 시간을 0으로 만들어 없애버림
	Cookie cookie = new Cookie("rememberMe","");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>
<script>
	alert('로그아웃 완료');
	location.replace('index.jsp');
</script>