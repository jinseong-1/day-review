package t03_state;

// 상태확인 스레드
public class ATargetThread extends Thread{

	@Override
	public void run() {
		// runnable
		for(long i = 0; i<1000000000000L;i++) 
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(long i = 0; i<10000000000L;i++);
		
	}
	
}
