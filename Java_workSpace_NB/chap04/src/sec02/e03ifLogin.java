package sec02;

import java.util.Scanner;

public class e03ifLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String uid =  "id001";
		String upw = "pw001";
		
		System.out.println("아이디를 입력해 주세요 : ");
		String id = sc.next();
		
		System.out.println("비밀번호를 입력해 주세요 :");
		String pw = sc.next();
		
		System.out.println("입력하신 ID : " + id);
		System.out.println("입력하신 PW : " + pw);
		
		//if(uid == id && upw == pw) { <-- 불러오는 곳이 달라서 값을 비교못해서 잘못된 수식
		if(uid.equals(id) && upw.equals(pw)) {
			System.out.println("정상적으로 로그인 되었습니다.");
		}else {
			System.out.println("ID나 PW가 틀렸으니 다시한번 확인해보십시오.");
		}
	}

}
