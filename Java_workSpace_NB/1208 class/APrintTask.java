package t01_create_thread;

public class APrintTask implements Runnable {

	@Override
	public void run() {
		for(int i =0; i< 5; i++) {
			System.out.println("PrintTask 띵!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		} // end for
		System.out.println("Print Task 종료");
	}

}
