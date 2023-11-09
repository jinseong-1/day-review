import java.util.Scanner;

public class MoveReservation {
	
	public static void main(String[] args) {
		
		boolean isRun=true;
		while(isRun) {
		System.out.println("             SCREEN");
		final int size = 10;
		int[] seat = new int[size];
		
		for(int i = 0; i<seat.length;i++) {
			System.out.print("" +"["+(i+1)+"]");
		}System.out.print(" " + "[행]");
		
		// 영화관 자리
		System.out.println();
		int[]seats[] = new int[10][10]; 
		for(int i =0; i<seats.length;i++) {
			for(int j =0; j<seats[i].length;j++) {
				if(seats[i][j] == 0) {
					System.out.print("[□]");
				}else {
					System.out.print("[■]");
				}
			}System.out.println(" [" +(char)(i+65)+"행]");
		} // 상영관 그리기
		
		// 행 번호 받기
		System.out.println("예약하실 좌석의 행 이름을 입력해주세요(A~J)");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(s);
		
		char inputRow = s.charAt(0);
		System.out.println("inputRow");
		
		if(inputRow<65 || inputRow>74) {
			System.out.println("선택 할 수 없는 행입니다.");
			continue;
		}
		System.out.println("선택하신 행 이름은 : " + inputRow);
		
		// 열 번호 받기
		int row = inputRow -65;
		System.out.println("예약하실 열 번호를 입력해주세요.(1~10)");
		int columnNum = sc.nextInt();
		
		if(columnNum <1 || columnNum>10) {
			System.out.println("사용할 수 없는 열 번호입니다.");
			continue;
		}
		System.out.print("선택하신 좌석은 "+inputRow+"행 "+columnNum+"열 입니다.");
		System.out.println("예약을 완료하시겠습니까? y/n");
		String selected = sc.next();
		
		if(selected.equals("Y")||selected.equals("y")) {
			// 자리 중복 확인
			if(seats[row][columnNum-1] !=0) {
				System.out.println("이미 예약이 완료된 좌석 입니다.");
				continue;
			}
			seats[row][columnNum-1]=1;
			System.out.println("예약이 완료되었습니다.");
		}else {
			System.out.println("예약이 취소되었습니다.");
		}
		
		isRun = false;
		} //while end
	} // main

 } //class
