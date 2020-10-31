import java.util.*;
public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll=new CircularLinkedList();
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("Please enter two numbers");
            System.out.print("First number: ");
            int x = scn.nextInt();
            System.out.print("Second number: ");
            int y = scn.nextInt();

            for(int i=x;i>=1;i--){
                cll.add(Integer.toString(i));
            }
            System.out.print("\nCll: ");
            cll.display();

            cll.Josephus(y);

        }
        catch (Exception e){
           System.out.println("Error");
        }

    }
}
