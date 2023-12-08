package t02_priority_name;

public class ACalcThread extends Thread{
	
	
	public ACalcTread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i<100000000; i++) {
			System.out.println(getName()+":"+getPriority());
			System.out.println(Thread.currentThread());
		}
	}
}
