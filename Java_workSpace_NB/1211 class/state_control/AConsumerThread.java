package t05_state_control.notify_wait;

public class AConsumerThread extends Thread{
	
	private ADataBox dataBox;
	
	public AConsumerThread(ADataBox dataBox) {
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for(int i =0; i<=3;i++) {
			String data = dataBox.getAData();
			System.out.println("consumer thread data : " + data);
		}
	}
	
}
