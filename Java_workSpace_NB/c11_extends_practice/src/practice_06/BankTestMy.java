package practice_06;

public class BankTestMy {
	public static void main(String[] args) {
		Bank b1 = new BadBank();
		Bank b2 = new NormalBank();
		Bank b3 = new GoodBank();
			
		System.out.println("BadBank의 이자율 : " + b1.getInterestRate());
		System.out.println("NormalBank의 이자율 : " + b2.getInterestRate());
		System.out.println("GoodBank의 이자율 : " + b3.getInterestRate());	
		
	}
}
