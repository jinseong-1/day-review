package t02_priority_name;

public class APriorityNameExample {

	public static void main(String[] args) {
		// priority : 우선순위
		Thread t = Thread.currentThread();
		System.out.println(t);
		
		// 스레드 이름
		System.out.println(t.getName());
		
		// 스레드 우선순위
		System.out.println(t.getPriority());
		
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		
		System.out.println("----------------------");
		for(int i = 0; i<=10; i++) {
			Thread calc = new CalcThread("CaleThread-"+i);
			if(i ==7) {
				calc.setPriority(Thread.MAX_PRIORITY);
			}
			calc.start();
		}
		for(int i = 0;i<5;i++) {
			Thread t2 = new Thread(()-> {
				for(int j = 0; j<21000000;j++) {
					System.out.println(Thread.currentThread());
				}
			});
			t2.start();
		}
		System.out.println("Main endding");
	} // end main

}
