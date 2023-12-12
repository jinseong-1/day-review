package t04_sync;

public class AccountA {
	
	// 저장된 금액
	private int moneys = 10000;
	
	public int getMoneys() {
		return this.moneys;
	}
	
	// 출금
	/* 
	   1. synchronized public boolean withDraw(int money) { // 순서 바껴도 상관없음 
		  public synchronized boolean withDraw(int money) {
	   2. runnable에서 직접 synchronized를 지정시켜 대기시킬수 있음
	*/
		public boolean AwithDraw(int money) {
			if(moneys >= money) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				
				moneys -= money;
				return true;
			}
			
			// 출금을 못하는 금액
			return false;
		}
	

}