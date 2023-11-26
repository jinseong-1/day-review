package j_practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class p6_LocalDate {

	public static void main(String[] args) {
		LocalDateTime targetDateTime = LocalDateTime.now();
		
		targetDateTime = targetDateTime
							.withYear(2023)
							.withMonth(12)
							.withDayOfMonth(31)
							.withHour(23)
							.withMinute(59)
							.withSecond(59);
		
		DateTimeFormatter pattern
			= DateTimeFormatter.ofPattern("지정된 시간은 : yyyy년MM월dd일 E요일 a KK시 mm분ss초 입니다.");
		String time = targetDateTime.format(pattern);
		System.out.println(time);
	}

}
