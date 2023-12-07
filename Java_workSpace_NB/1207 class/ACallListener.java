package ex02_netsted_interface;

public class ACallListener implements AButton.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("전화를 겁니다.");
	}
}
