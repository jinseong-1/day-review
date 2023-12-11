package n1_address_url;

import java.net.InetSocketAddress;

public class AInetSocketAddressExample {

	public static void main(String[] args) {
		InetSocketAddress num = new InetSocketAddress("10.100.205.16",2002);
		System.out.println(num.getHostString());
		System.out.println(num.getHostName());
		System.out.println(num.getAddress());
		System.out.println(num.getPort());
	}

}
