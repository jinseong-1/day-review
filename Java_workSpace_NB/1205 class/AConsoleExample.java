package f05_reader_writer;

import java.io.Console;

public class AConsoleExample {

	public static void main(String[] args) {
		Console console = System.console();
		System.out.println("아이디 : ");
		String id = console.readLine();
		System.out.println("비밀번호 : ");
		// 이클립스에선 이부분이 출력이 안되기에 export를 해서 윈도우 powershell을 이용해야함
		char[] password = console.readPassword();
		System.out.println("-------------");
		String strPassword = new String(password);
		System.out.println("id :" + id);
		System.out.println("password" + strPassword);
	}

}
