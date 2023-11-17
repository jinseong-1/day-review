package extends5_polymorphism.base;

public class Student extends Person {

	String classRoom;		// 교실
	String studentNum;		// 학번
	String grade;			// 학년
	
	
	public Student(String name, int age, int weight, int heihgt, 
				String classRoom, String studentNum, String grade) {
		super(name, age, weight, heihgt);
		this.classRoom = classRoom;
		this.studentNum = studentNum;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return super.toString() + " Student [classRoom=" + classRoom + ", studentNum=" + studentNum + ", grade=" + grade + "]";
	}
	
}
