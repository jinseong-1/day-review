package t04_sync;

public class AWithDrawTask implements Runnable{

	AccountA account;
	
	public AWithDrawTask(AccountA account) {
		this.account = account;
	}

	@Override
	public void run() {
		
		while(account.getMoneys()>0) {
			// 1000~5000
			int money = (int)(Math.random()*5+1) * 1000;
			boolean isDenied = false;
			synchronized(account) {
				isDenied = account.AwithDraw(money);
			}
			
			if(isDenied) {
				System.out.printf("%s 출금 : %d원 남은금액 :%d %n",
								 Thread.currentThread().getName(),money,account.getMoneys());
			}else{
				System.out.println("출금 금액 부족 - 다시 입력하시오");
			}
		}
	}
	
	
	
	
}
