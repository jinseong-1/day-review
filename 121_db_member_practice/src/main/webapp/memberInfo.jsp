<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- memberInfo.jsp -->
<%@ include file="common/header.jsp" %>
<%@ include file="checkAdmin.jsp" %>
<%
	String strNum = request.getParameter("num");
	
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	MemberVO m = null;
	
	String sql = "SELECT id, name, addr FROM pri_member WHERE num = ?";
	
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(strNum));
		rs = pstmt.executeQuery();
		if(rs.next()){
			m = new MemberVO();
			m.setId(rs.getString("id"));
			m.setName(rs.getString("name"));
			m.setAddr(rs.getString("addr"));
		}else{
			response.sendError(404);
			return;
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		JDBCUtil.close(rs, pstmt, conn);
	}
%>
<section>
<table>
	<tr>
		<th colspan="2">
			<%=strNum %> 번의 회원정보
		</th>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=m.getId() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=m.getName() %></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><%=m.getAddr() %></td>
	</tr>
	<tr>
		<th colspan="2">
			<a href="memberUpdateForm.jsp?num=<%=strNum%>">수정</a> | <a href="javascript:memberDelete();">삭제</a>
		</th>
	</tr>
</table>
</section>
<script>
	function memberDelete(){
		if('<%=m.getId()%>' == 'admin'){
			alert('관리자 계정은 삭제할 수 없습니다.');
			return;
		}
		
		let isChecked = confirm('<%=strNum%>'+"번 회원 정보를 정말로 삭제하시겠습니까?");
		if(isChecked){
			location.href='memberDelete.jsp?num='+'<%=strNum%>';
		}
	}
</script>
<%@ include file="common/footer.jsp" %>











