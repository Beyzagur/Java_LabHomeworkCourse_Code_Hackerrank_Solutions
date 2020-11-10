package Inheritance;

public class Test {

	public static void main(String[] args) {
		Point p=new Point(0,0);
		Circle c=new Circle(2,4);
		Circle c1=new Circle();
		
		System.out.println();
		p.Display();
		c.Display();
		System.out.println();
		System.out.println(c.Calculate(new Circle(9,5)));
	}

}
