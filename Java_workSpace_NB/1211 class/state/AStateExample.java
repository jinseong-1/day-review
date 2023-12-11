package t03_state;

public class AStateExample extends Thread{
	
	public static void main(String[] args) {
		System.out.println("Main start");
		ATargetThread targetthread = new ATargetThread();
		
		Thread thr = new AStatePrintThread(targetthread);
		thr.start();
		
		System.out.println("Main end");
	}

}
