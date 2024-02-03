<%@page import="java.util.Base64"%>
<%@page import="java.sql.*"%>
<%@page import="util.JDBCUtil"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// session 에 등록된 인증된 사용자 정보
	MemberVO loginMember = (MemberVO)session.getAttribute("login");
	Cookie[] cookies = request.getCookies();
	if(loginMember == null && cookies != null){
		for(Cookie c : cookies){
			if(c.getName().equals("rememberMe")){
				String id = c.getValue();
				System.out.println("header cookie id : " + id);
				// 디코딩
				byte[] decodedID = Base64.getDecoder().decode(id.getBytes());
				id = new String(decodedID);
				System.out.println("header cookie id : " + id);
				
				Connection conn = JDBCUtil.getConnection();
				String sql = "SELECT * FROM pri_member WHERE id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					loginMember = new MemberVO(
						rs.getInt("num"),
						rs.getString("id"),
						rs.getString("pass"),
						rs.getString("name"),
						rs.getString("addr"),
						rs.getString("phone"),
						rs.getString("gender"),
						rs.getInt("age")
					);
					session.setAttribute("login", loginMember);
				}
				JDBCUtil.close(rs, pstmt, conn);
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<%String path = request.getContextPath(); %>
<link href="<%=path%>/css/header.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/footer.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header>
		<div>
			<ul>
				<li><a href="<%=path%>/index.jsp">home</a></li>
				<li><a href="<%=path%>/board/notice/notice_list.jsp">공지사항</a></li>
				<li><a href="<%=path%>/board/qna/qna_list.jsp">질문과답변</a></li>
			</ul>
		</div>
		<div>
			<ul>
				<%if(loginMember == null){ %>
				<!-- 비 로그인시용자 -->
				<li><a href="<%=path%>/login.jsp">로그인</a></li>
				<li><a href="<%=path%>/join.jsp">회원가입</a></li>
				<%}else{ %>
				<!-- 로그인 된 사용자 -->
				<li>
					<a href="<%=path%>/info.jsp"> <!-- 회원이름 -->
					<%=loginMember.getName() %>
					</a>님 방가방가
				</li>
				<li>
					<a href="<%=path%>/logout.jsp">로그아웃</a></li>
					<!-- 관리자 로그인일 경우 -->
					<% if(loginMember.getId().equals("admin")){ %>
					<li><a href="<%=path%>/memberList.jsp">회원관리</a></li>
					<%}%>
				<%}%>
			</ul>
		</div>
	</header>