package t05_state_control.notify_wait;

public class ADataBoxExample {

	public static void main(String[] args) {
		ADataBox dataBox = new ADataBox();
		Thread aThread = new AProduceThread(dataBox);
		Thread bThread = new AConsumerThread(dataBox);
		aThread.start();
		bThread.start();
	}

}
