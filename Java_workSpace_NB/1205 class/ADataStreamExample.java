package f07_data;

import java.io.*;

public class ADataStreamExample {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fos = new FileOutputStream("primitiv.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF("홍길동");
			dos.writeDouble(50.8);
			dos.writeInt(60);
			dos.writeChar('C');
			dos.writeBoolean(false);
			
			dos.writeUTF("도깨비");
			dos.writeDouble(5.8);
			dos.writeInt(2);
			dos.writeChar('Z');
			dos.writeBoolean(true);
			
			dos.flush();
			dos.close();
			
			DataInputStream dis =
				new DataInputStream(new FileInputStream("primitiv.txt"));
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			char grade = dis.readChar();
			boolean checked = dis.readBoolean();
			System.out.println("name : " + name);
			System.out.println("score : " + score);
			System.out.println("order : " + order);
			System.out.println("grade : " + grade);
			System.out.println("checked : " + checked);
			
			System.out.println("--------------------------");
			
			name = dis.readUTF();
			score = dis.readDouble();
			order = dis.readInt();
			grade = dis.readChar();
			checked = dis.readBoolean();
			System.out.println("name : " + name);
			System.out.println("score : " + score);
			System.out.println("order : " + order);
			System.out.println("grade : " + grade);
			System.out.println("checked : " + checked);

			
			dis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
