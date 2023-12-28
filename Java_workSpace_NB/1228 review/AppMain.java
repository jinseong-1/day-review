package application;

public class AppMain {
	
	private String name;
	private int hangle;
	private int math;
	private int english;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHangle() {
		return hangle;
	}

	public void setHangle(int hangle) {
		this.hangle = hangle;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public AppMain() {}
	
	public AppMain(String name, int hangle, int math, int english) {
		this.name = name;
		this.hangle = hangle;
		this.math = math;
		this.english = english;
	}
	
}
