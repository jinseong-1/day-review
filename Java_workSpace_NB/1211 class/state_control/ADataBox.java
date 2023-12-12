package t05_state_control.notify_wait;

public class ADataBox {
	
	private String Adata;
	
	public synchronized String getAData() {
		if(this.Adata == null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		String value = this.Adata;
		this.Adata = null;
		System.out.println("읽은 데이터 : "+value);
		notify();
		return value;
	}

	public synchronized void setAData(String data) {
		if(this.Adata != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		this.Adata = Adata;
		System.out.println("생성한 데이터 : " + Adata);
		notify();
	}
	
}
