package Inheritance;

public class Circle extends Point {
	private int r;

	public Circle() {
		super(0, 0);
		r = 0;
		System.out.println("Circle constructor.");
	}

	public Circle(int r, int x) {
		super(x, 0);
		this.r = r;
		System.out.println("Circle constructor with parameter.");
	}

	public double Calculate(Circle c) {
		return getX() + c.getX() + super.y + c.y;
	}

	public void Display() {
		System.out.println("Circle");
	}
}
