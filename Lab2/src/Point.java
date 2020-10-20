
public class Point 
{
	private double x;
	private double y;
	
	public Point(double input_x, double input_y)
	{
		x = input_x;
		y = input_y;
	}
	
	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}
	
	public void setX(double input_x)
	{
		x = input_x;
	}
	
	public void setY(double input_y)
	{
		y = input_y;
	}
	
	public void display()
	{
		System.out.println(x + " " + y);
	}
	
	public int getQuadrant()
	{
		int quadrant = 0;
		
		if(x > 0 && y > 0)
		{
			quadrant = 1;
		}
		else if(x < 0 && y> 0)
		{
			quadrant = 2;
		}
		else if(x < 0 && y < 0)
		{
			quadrant = 3;
		}
		else if(x > 0 && y < 0)
		{
			quadrant = 4;
		}
		
		return quadrant;
	}
}






