package ex02_netsted_interface;

public class Amessagelistener implements AButton.OnClickListener{

	@Override
	public void onClick() {
		System.out.println("메세지를 전달합니다.");
	}
}
