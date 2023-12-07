package ex02_netsted_interface;

public class AButton {
	
	interface OnClickListener{
		void onClick();
	}
	
	private String title;
	
	public AButton(String title) {
		this.title = title;
	}
	
	private OnClickListener Listener;
	
	void setOnClickListener(OnClickListener listener){
		this.Listener = listener;
	}
	
	// 버튼 클릭됬을때
	public void onTouch() {
		this.Listener.onClick();
	}

	@Override
	public String toString() {
		return "AButton [title=" + title + ", Listener=" + Listener + "]";
	}
	
	
	
}
