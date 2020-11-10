package Basics;

public class Circle {
	Point p;
	int r;

	public Circle() {
		r = 0;
		p = new Point();
		System.out.println("Circle default constructor.");
	}

	public Circle(Point p, int r) {
		this.r = r;
		this.p = p;
		System.out.println("Circle constructor with all parametres.");
	}

	public Circle(int x, int y, int r) {
		this.r = r;
		p = new Point(x, y);
		System.out.println("Circle constructor with all parameters.");
	}

	public String Display1() {
		return "[" + p.x + ", " + p.y + "]" + " r: " + r;
	}
	public String Display2() {
		return p.Display()+" r: "+r;
	}
	public double Distance1(Circle c) {
		return Math.sqrt(Math.pow(p.x-c.p.x, 2)+Math.pow(p.y-c.p.y,2));
	}
	public double Distance2(Circle c) {
		return p.Distance(c.p);
	}
}
