package c_method;

public class AccountManager {

	public static void main(String[] args) {
		
		// 사용자 잔고 확인
		Account park = new Account();
		String result = park.showInfo();
		System.out.println(result);

		// 입금
		park.deposit(100000000);
		result = park.showInfo();
		System.out.println(result);
		
		// 출금
		park.withdraw(150000);
		result = park.showInfo();
		System.out.println(result);
		
		Account um = new Account();
		um.deposit(1000);
		result = um.showInfo();
		System.out.println(result);
		um.withdraw(1000000);
		um.deposit(-2000);
		
		result = park.showInfo();
		System.out.println("park : "+ result);
		result = um.showInfo();
		System.out.println("um : " + result);
	}

}
