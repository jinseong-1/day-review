package t03_state;

public class AStatePrintThread extends Thread{
	
	Thread AtargetThread;
	
	public AStatePrintThread(Thread AtargetThread) {
		this.AtargetThread = AtargetThread;
	}

	@Override
	public void run() {
		while(true) {
			Thread.State state = AtargetThread.getState();
			System.out.println("target state : " + state);
			
			if(state == State.NEW) {
				AtargetThread.start();
			}
			
			if(state == State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
	
	
}
