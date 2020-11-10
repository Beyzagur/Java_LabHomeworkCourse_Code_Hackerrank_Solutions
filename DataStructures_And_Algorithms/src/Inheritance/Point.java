package Inheritance;

public class Point {
	private int x;
	public int y;

	public Point(int a, int b) {
		x = a;
		this.y = y;
		System.out.println("Point constructor with parameter.");
	}

	protected int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void Display() {
		System.out.println("Point");
	}
}
