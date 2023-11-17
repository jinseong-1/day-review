package a7_encapsulation;

public class Test {

	public static void main(String[] args) {
		// Test.main(null);
		System.out.println(args);
		for(String s : args) {
			System.out.println(s);
		}
		
		Student park = new Student();
		park.name = "홍길동";
		//park.age = -20;
		park.setAge(-20);
		//park.grade = 16;
		park.setGrade(20);
		
		System.out.println(park.getAge());
		System.out.println(park.getGrade());
		
		
	} //end main
}
