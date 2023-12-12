package t04_sync;

import java.lang.Thread.State;
import java.util.List;
import java.util.Vector;

public class AVectorExample {

	public static void main(String[] args) {
		System.out.println("Main start");
		
		List<String> array = new Vector<>();
		Thread t1 = new Thread(()->{
			// run method
			for(int i =0; i<10000;i++) {
				array.add("홍길동");
			}
			System.out.println("t1 종료");
		});
		t1.start();
		
		System.out.println("==================");
		
		Thread t2 = new Thread(()->{
			for(int i =0;i<10000;i++) {
				array.add("도둑");
			}
			System.out.println("t2 ended");
		});
		t2.start();
		
		while(true) {
			if(t1.getState() == State.TERMINATED && t2.getState() == State.TERMINATED) {
				System.out.println("t1, t2 작업 완료");
				System.out.println("array size : " + array.size());
				break;
			}
		}
		System.out.println("Main it's over");
	} // end main
	
}
