package GUIDE.book;

import java.util.Scanner;

public class BookManagement {

	// 문자열 입력
	Scanner scanLine = new Scanner(System.in);
	// 선택번호 입력
	Scanner scanSelectnum = new Scanner(System.in);
	
	// 도서목록
	Book[] books = new Book[100];
	// 프로그램 실행 flag
	boolean isRun = true;
	// 메인 메뉴 선택 번호
	int selectNo = 0;
	// 도서관리 번호
	int count=1;	

	public BookManagement(){
		run();
	}
	
	public void run() {
		while(isRun) {
			System.out.println("================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5. 종료");
			System.out.println("================================================");
			selectNo = getSelectNum("번호를 선택하세요 > ");
			
			switch(selectNo) {
				case 1 :
					registerBook();
					break;
				case 2 :
					selectBook();
					break;
				case 3 :
					updateBook();
					break;
				case 4 : 
					deleteBook();
					break;
				case 5 : 
					terminate();
					break;	
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			
			}
		}
	}
	
	// 프로그램 종료
	public void terminate() {
		System.out.println("프로그램 종료");
		isRun = false;
	}

	// 도서 등록
	public void  registerBook() {
		System.out.println("1. 도서등록");
		System.out.println("등록할 책의 제목을 입력하세요 >");
		String title = scanLine.nextLine();
		System.out.println("등록할 책의 저자를 입력하세요 >");
		String another = scanLine.nextLine();
		
		Book newbook = new Book(count++,title,another);
		
		for(int i = 0; i<books.length;i++) {
			if(books[i]==null) {
				books[i] = newbook;
				System.out.println("등록완료");
				break;
			}
		}
	} // registerBook end
	
	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		for(int i = 0; i<books.length;i++) {
			if(books[i]!=null) {
				String info = books[i].toString();
				System.out.println(info);
				
			}
		}
	} // selectBook end

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		System.out.println("수정할 책의 도서관관리번호를 입력하세요 > ");
		int num = scanLine.nextInt();
			Book book = findBook(num);
			// Book.toString();
			String info = book.toString();
			System.out.println(info);
			System.out.println("================");
			System.out.println("1.제목 수정|2.저자 수정|3.수정완료");
				switch(num) {
					case 1:
						System.out.println("제목 수정");
						System.out.println("제목입력 >");
						String title = scanLine.nextLine();
						book.title = title;
						System.out.println("제목 수정 완료");
						break;
					case 2 :
						System.out.println("저자 수정");
						System.out.println("저자 입력 > ");
						String author = scanLine.nextLine();
						book.author = author;
						break;
					case 3 :
						System.out.println("수정완료");
						break;
					default :
						System.out.println("잘못된 값입니다.");
				} // switch end
				
				
			
	} // updateBook end
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
	}
	
	// 책 정보 출력
	public void printBookInfo(Book b) {
		System.out.println(b.toString());
	}
	
	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
		for(int i=0;i<books.length;i++) {
			if(books[i].num==num) {
				return books[i];
			}
		}
		return null;
	}
	
	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}
	
	// 번호 선택 받기
	int getSelectNum(String message) {
		System.out.println(message);
		return scanSelectnum.nextInt();
	}
		
	public static void main(String[] args) {
		new BookManagement();
	}

}
