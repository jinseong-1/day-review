package t05_state_control.notify_wait;

public class AProduceThread extends Thread{
	private ADataBox dataBox;
	
	public AProduceThread(ADataBox dataBox) {
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for(int i =0; i<=3;i++) {
			String data = "Data-"+i;
			dataBox.setAData(data);
		}
	}
	
}
