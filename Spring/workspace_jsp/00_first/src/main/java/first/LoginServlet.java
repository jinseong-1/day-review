package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	/**
	 * 기본적으로 들어가있어야 하는 것 "serialVersionUID"
	 * serialVersionUID 이게 같아야 같은걸로 java 와 html가 연결되고 동작시킬수있음
	 */
	private static final long serialVersionUID = -8591970279891007344L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login GET 방식 요청");
		InputStream is = req.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String data = "";
		while((data = reader.readLine())!=null) {
			System.out.println(data);
		}
		
		String str = req.getQueryString();
		System.out.println(str);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login POST 방식 요청");
		/*
		InputStream is = req.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String data = "";
		while((data = reader.readLine())!=null) {
			System.out.println(data);
		}
		*/
		
		// request 사용자 요청으로 전달된 데이터를 읽기
		String uid = req.getParameter("uid");
		String upw = req.getParameter("upw");
		
		System.out.println("uid : " + uid);
		System.out.println("upw : " + upw);
		
		String id = "id001";
		String pw = "pw001";
		
		// Response
		// - 요청을 전달한 client에게 처리된 결과를 출력해주기 위한 정보를 저장하는 객체
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8' />");
		out.println("<title>로그인 요청 처리 결과</title>");
		out.println("</head>");
		out.println("<body>");

		if(id.equals(uid) && pw.equals(upw)) {
			// 일치하는 사용자
			out.println("<h1>로그인이 완료 되었습니다.</h1>");
			out.println("<a href='home.html'>메인으로</a>");
		}else {
			// 일치하지 않는 사용자
			out.println("<script>");
			out.println("alert('로그인 실패! 아이디와 비밀번호를 확인하세요.');");
			out.println("history.back();");	// 잘못 입력했을때 이전페이지로 가는 것
			out.println("</script>");
		}
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
	

}
