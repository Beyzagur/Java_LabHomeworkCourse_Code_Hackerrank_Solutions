import java.util.Scanner;
public class DLLMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Please enter a number: ");
		try {
			int num=sc.nextInt();
			DoubleLinkedList DLL = new DoubleLinkedList();
			DLL.add(10);
			DLL.add(20);
			DLL.add(30);
			DLL.add(40);
			DLL.add(50);
			DLL.add(60);
			DLL.add(70);
			DLL.add(80);
			DLL.add(90);
			
			DLL.display1();
			DLL.display2();
			System.out.println(DLL.size());
			DLL.swap(num);
			DLL.display1();
			
		} catch (Exception exception) {
			
			System.out.println("Error");
		}
		

	}

}
