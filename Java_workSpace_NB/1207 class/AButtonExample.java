package ex02_netsted_interface;

public class AButtonExample {

	public static void main(String[] args) {
		AButton callButton = new AButton("전화걸기");
		callButton.setOnClickListener(new CallListener());
		callButton.onTouch();
	}

}
