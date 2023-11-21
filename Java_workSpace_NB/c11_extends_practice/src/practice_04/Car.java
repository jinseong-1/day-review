package practice_04;

public class Car {
	public String color;
	public int speed;
	public int changeGear;
	public double speedUp;
	public double speedDown;
	
	Car(){};
	
	Car(int g, double mx, double ux){
		changeGear = g;
		speedUp = mx;
		speedDown = ux;
	}
	
	public Car(String color, int speed, int changeGear) {
		super();
		this.color = color;
		this.speed = speed;
		this.changeGear = changeGear;
	}

	public void changeGear(int i) {
		changeGear = i;
		System.out.println(i);
	}

	public void speedUp() {
		this.speed += 10;
	}

	public void speedDown() {
		this.speed -= 10;
	}

	// alt + s + s + s
	@Override
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", gear=" + changeGear + "]";
	}
	
	
	
	
	
}
