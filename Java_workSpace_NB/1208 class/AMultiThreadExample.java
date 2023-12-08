package t01_create_thread;

public class AMultiThreadExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		// 1. Thread 상속
		Thread t = new ABeepThread();
		t.start();
		
		// 2. Runnable 인터페이스 구현
		Runnable run = new APrintTask();
		Thread t1 = new Thread(run);
		t1.start();
		
		// 3. Runnable 익명 구현객체 사용
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("work Task");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {}
				System.out.println("work Task 종료");
			}
		});
		t2.start();
		
		// 4. lambda 표현식 활용
		Thread t3 = new Thread(()->{
			System.out.println("lambda Task");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			System.out.println("lamda Task 종료");
		});
		t3.start();
		
		System.out.println("Main 종료");
	}

}
