package Basics;

public class Point {
	int x;
	int y;

	public Point() {
		this.x = 0;
		y = 0;
		System.out.println("Point default costructor.");

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Point constructor with parameter.");

	}

	public String Display() {
		return "[" + x + ", " + y + "]";
	}

	public double Distance(Point p) {
		return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
	}
}