
public class Main {

	public static void main(String[] args) {
		//1. Question
		/*Define a Point class with:   
		Two attributes: x and y
		One constructor method to construct a point at given coord (x, y) values
		Get/set methods
		Display method
		Quadrant method
		Note: Quadrant method should return a number (1,2,3, or 4) where a point is on the coordinate plane.
		Write a main method that 
		-	creates two point objects (3,2) and (5,4).
		-	finds midpoint of these points.*/

		System.out.println("------ 1. Question ------");
		 Point p1 = new Point(3, 2);
	     Point p2 = new Point(5, 4);
	     
	     p1.display();
	     p2.display();
	     
	     System.out.println(p1.getQuadrant());
	     System.out.println(p2.getQuadrant());
	     
	     Point p3 = new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
	     p3.display();
	     System.out.println(p3.getQuadrant());
	     
	     //2. Question
	     /*Define a Clock class with:  
		   Two attributes: hour and minute                
           One constructor method       
           Get / Set methods
           Display method
           A method (increaseTime) that adds given minutes to a clock-time
           
           Note: Use 24-hour format, i.e., 14:40

           Write a main method that 
           -	creates a clock object 14:40
           -	calls increaseTime(10) method to produce the following output:   14:50
           -	calls increaseTime(25) method to produce the following output:   15:05
           -	calls increaseTime(245) method to produce the following output:   18:45  */
	     
	       System.out.println("\n------ 2. Question ------");
	       Clock c1 = new Clock(14, 40);
	       c1.increaseMinutes(10);
		   c1.display();
			
		   c1.increaseMinutes(25);
		   c1.display();
			
		   c1.increaseMinutes(245);
		   c1.display();
			
		   //3. Question
		   /*
		    * - Write an object oriented program that allows users to manage the members of Fitness Center.
		    * The program should store all members’ information (i.e.  name, surname, height, weight, etc.). 
		    * Create a Member class with:
		    * Several attributes: name, surname, heigth, weight etc. 
		    * One constructor method which receives all parameters 
		    * Get / Set methods
		    * Display method 
		    * BMI method                    (calculates Body Mass Index of the member)
		    * WeightStatus method      (returns the weight status of the member by calling BMI method)
		    * Body Mass Index	Weight Status
		    * Smaller 18.5	Thin
		    * 18.5 – 24.9	Normal
		    * 25 – 29.9	Fat
		    * 30 and up	Obese
		    * 
		    * Create a SportCenter class with:
		    * Several attributes: name of the sport center, Member[] members, count, etc. 
		    * One constructor 
		    * addMember(Member m) method
		    * search(String name, String surname) method
		    * printAllMembers() method
		    * 
		    * Write a main method that 
		    * add yourself as a member
		    * add your two friends as members
		    * call printAllMembers() method
		    * call WeightStatus() method for you to learn your status 

		    */
		   System.out.println("\n------ 3. Question ------");
		   SportCenter SC = new SportCenter(10);
			
			Member a = new Member("Ali", "Tas", 70, 1.70);
			Member b = new Member("Ahmet", "Erdek", 100, 1.80);
			Member c = new Member("Cem", "Yilmaz", 90, 1.90);
			
			SC.addMember(a);
			SC.addMember(b);
			SC.addMember(c);
			
			SC.printAllMembers();
			
			System.out.println("Member a WeightStatus = " + a.getWeightStatus());
			System.out.println("Member b WeightStatus = " + b.getWeightStatus());
			System.out.println("Member c WeightStatus = " + c.getWeightStatus());
	     

	}

}
