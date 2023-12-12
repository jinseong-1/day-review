package t04_sync;

// 값을 대입할때 안전하게 하기 위해 HashTable, Vector을 사용
public class ASyncExample {

	public static void main(String[] args) {
		AccountA account = new AccountA();
		Thread t1 = new Thread(new AWithDrawTask(account));
		Thread t2 = new Thread(new AWithDrawTask(account));
		t1.setName("task-1");
		t2.setName("task-2");
		t1.start();
		t2.start();
	}

}
