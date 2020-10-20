
public class Clock 
{
	private int hour;
	private int minute;
	
	public Clock(int h, int m) {
		
		hour = h;
		minute = m;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int h) {
		hour = h;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int m) {
		minute = m;
	}

	public void display() {
		System.out.println("Clock [hour=" + hour + ", minute=" + minute + "]");
	}
	
	public void increaseMinutes (int m) 
	{
		int totalMinutes = ((60*hour) + minute + m) % (24*60);

		if (totalMinutes<0)
     		totalMinutes = totalMinutes + (24*60);

		hour = totalMinutes / 60;
		minute = totalMinutes % 60;

	}

}
