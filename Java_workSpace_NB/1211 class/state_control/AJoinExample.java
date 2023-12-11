package t05_state_control;

public class AJoinExample {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
		
		private int num;
		
		@Override
		public void run() {
			for(int i =1;i<=100;i++) {
				num += i;
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}
					System.out.println(getName()+"num : "+num);
				
			} // end for
			System.out.println("num Thread 종료");
		} // end run
		
		}; // end Thread
		t1.setName("NumThread");
		t1.start();
		
		try {
			t1.join(1000);
		} catch (InterruptedException e) {}
		System.out.println("Main finish");
	}
}
