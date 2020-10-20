
public class SportCenter 
{
	private Member[] members;
	private int count;
	
	public SportCenter(int capasity)
	{
		members = new Member[capasity];
		count = 0;
	}
	
	public void addMember(Member m)
	{
		members[count] = m;
		count++;
	}
	
	public String search(String name, String surname)
	{
		String member="";
		for(int i=0;i<count;i++)
		{
			if(members[i].getName().equals(name) && members[i].getSurname().equals(surname))
			{
				member = members[i].display();
				break;
			}
		}
		
		return member;
	}
	
	public void printAllMembers()
	{
		for(int i = 0; i < count; i++)		
			System.out.println(members[i].display());		
	}

}
