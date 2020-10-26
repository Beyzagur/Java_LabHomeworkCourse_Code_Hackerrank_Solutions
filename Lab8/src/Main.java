import java.util.Random;

public class Main {

	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList(null);

		Random rnd = new Random();
		for (int i = 0; i < 16; i++) {
			int letter = rnd.nextInt(5) + 65;
			sll.insert((char) letter);
		}
		System.out.print("Randomly generated single linked list: ");
		sll.display();
		System.out.println("\n\nBar Graph");
		sll.barGraph();
	}

}
