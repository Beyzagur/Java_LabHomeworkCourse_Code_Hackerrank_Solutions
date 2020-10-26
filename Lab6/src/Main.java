public class Main {

	public static void screen(CircularQueue q) {
		for (int i = q.size(); i >0; i--) {
			System.out.print(q.peek()+" ");
			q.enqueue(q.dequeue());
		}
	}
	
	public static void main(String[] args) {
		/*- Write a Circular Queue class.
		 * Create two circular queues with size 10.
		 * - Fill the first queue with the following numbers.
		 *  q1.enqueue(14); q1.enqueue(20); q1.enqueue(13); q1.enqueue(7); q1.enqueue(8);
		 *  q1.enqueue(6); q1.enqueue(11); q1.enqueue(9); q1.enqueue(3); q1.enqueue(5);
		 *  - Fill the second queue with the following operators (+, - , *).
		 *  q2.enqueue(“+”); q2.enqueue(“+”); q2.enqueue(“-”); q2.enqueue(“*”); q2.enqueue(“+”);
		 *  q2.enqueue(“-”); q2.enqueue(“*”); q2.enqueue(“+”); q2.enqueue(“+”);
		 *  - At each step, two integers (number1 and number2) are taken from the first queue and one operation is taken from the
		 *  second queue.
		 *  The result of the statement (number1 operation number2) is placed to the first queue.
		 *  */
		
		CircularQueue q1= new CircularQueue(10);
		CircularQueue q2= new CircularQueue(10);
		
		int step=0;
		
		q1.enqueue(14); q1.enqueue(20); q1.enqueue(13); q1.enqueue(7); q1.enqueue(8);
		q1.enqueue(6); q1.enqueue(11); q1.enqueue(9); q1.enqueue(3); q1.enqueue(5);
		
		q2.enqueue("+"); q2.enqueue("+"); q2.enqueue("-"); q2.enqueue("*"); q2.enqueue("+");
		q2.enqueue("-"); q2.enqueue("*"); q2.enqueue("+"); q2.enqueue("+");
		
		System.out.print("Step: "+step+"\nQ1: ");
		screen(q1);
		System.out.print("\n    \\  /");
		System.out.print("\nQ2:  ");
		screen(q2);
		System.out.println("\n");
		
		while(q1.size()!=1) {
			if("+".equals((String)q2.peek())) {
				q1.enqueue((int)q1.dequeue()+(int)q1.dequeue());
			}
			else if("-".equals((String)q2.peek())) {
				q1.enqueue((int)q1.dequeue()-(int)q1.dequeue());
			}
			else if("*".equals((String)q2.peek())) {
				q1.enqueue((int)q1.dequeue()*(int)q1.dequeue());
			}
			q2.dequeue();
			step++;
			System.out.print("Step:"+step+"\nQ1: ");
			screen(q1);
			if(!q2.isEmpty()) {
				if(q2.size()==1) {
					System.out.print("\n    \\  /");
				}
				else
					System.out.print("\n    \\ /");
			}
			System.out.print("\nQ2:  ");
			screen(q2);
			System.out.println("\n");
		}

	}

}
