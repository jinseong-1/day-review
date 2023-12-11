package n1_address_url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class AInetAddressURLExample {

	public static void main(String[] args) {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address); // name, ipv4
			
			System.out.println(address.getHostAddress()); 	// ipv4
			System.out.println(address.getHostName());		// name
			InetAddress daum = InetAddress.getByName("www.daum.net");
			System.out.println(daum);
			
			InetAddress[] ipv = InetAddress.getAllByName("www.daum.net");
			for(InetAddress remote : ipv) {
				System.out.println("daum ip 주소 : " + remote.getHostAddress());
			}
			
			// import java.net.URL
			URL url = new URL("https://www.daum.net");
			
			InputStream im = url.openStream();
			InputStreamReader iam = new InputStreamReader(im);
			BufferedReader plus = new BufferedReader(iam);
			
			File file = new File("daum.html");
			FileWriter four = new FileWriter(file);
			BufferedWriter plu = new BufferedWriter(four);
			
			String reder = "";
			while((reder = plus.readLine())!=null) {
				plu.write(reder);
				plu.newLine();
			} 
			plu.flush();
			plu.close();
			plus.close();
			System.out.println("endded");
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("기형적인 URL 형식에 어긋난 요청");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
