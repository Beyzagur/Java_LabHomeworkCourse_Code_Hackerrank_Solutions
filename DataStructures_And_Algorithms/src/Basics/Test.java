package Basics;

public class Test {

	public static void main(String[] args) {
		Point p1=new Point();
		Point p2=new Point(3,4);
		
		System.out.println("Point p1: "+p1.Display());
		System.out.println("Point p2: "+p2.Display());
		System.out.println("Distance: "+p1.Distance(p2)+"\n");

		Circle c1=new Circle();
		Circle c2=new Circle(p1, 5);
		Circle c3=new Circle(3, 4, 7);
		
		System.out.println("Circle c1: "+c1.Display1());
		System.out.println("Circle c2: "+c2.Display1());
		System.out.println("Circle c3: "+c3.Display1());
		System.out.println("Distance: "+c2.Distance1(c3)+"\n");
		System.out.println("Circle c1: "+c1.Display2());
		System.out.println("Circle c2: "+c2.Display2());
		System.out.println("Circle c3: "+c3.Display2());
		System.out.println("Distance: "+c2.Distance2(c3)+"\n");
		
		
		
	}

}
