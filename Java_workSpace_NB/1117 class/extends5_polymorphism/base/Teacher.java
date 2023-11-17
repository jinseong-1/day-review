package extends5_polymorphism.base;

public class Teacher extends Person{

	String tNumber;			// 교번
	String subject;			// 담당 교과목
	String grade;			// 담당 학년
	// alt + s + a
	public Teacher(String name, int age, int weight, int heihgt, String tNumber, String subject, String grade) {
		super(name, age, weight, heihgt);
		this.tNumber = tNumber;
		this.subject = subject;
		this.grade = grade;
	}
	
	public void teach() {
		System.out.println(subject+"교과목을 가르칩니다.");
	}

	
	// alt + s + s + s
	@Override
	public String toString() {
		return "Teacher [tNumber=" + tNumber + ", subject=" + subject + ", grade=" + grade + 
				", name=" + name + ", age="+ age + ", weight=" + weight + ", heihgt=" + heihgt + "]";
	}
	
	
	
	
}
