
public class Member 
{
	private String name;
	private String surname;
	private double weight;
	private double height;
	
	public Member(String n, String s, double w, double h) {
		
		name = n;
		surname = s;
		weight = w;
		height = h;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String s) {
		surname = s;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double w) {
		weight = w;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double h) {
		height = h;
	}

	
	public String display() {
		return "Member [name=" + name + ", surname=" + surname + ", weight=" + weight + ", height=" + height + "]";
	}
	
	private double calculteBMI()
	{
		return weight / (height * height);
	}
	
	public String getWeightStatus()
	{
		double BMI = calculteBMI();
		
		String weightStatus;
		if(BMI < 18.5)
		{
			weightStatus = "Thin";
		}
		else if(BMI >= 18.5 && BMI <= 25.9)
		{
			weightStatus = "normal";
		}
		else if(BMI >= 25 && BMI <= 29.9)
		{
			weightStatus = "Fat";
		}
		else
		{
			weightStatus = "Obese";
		}
		return weightStatus;
		
	}

}




