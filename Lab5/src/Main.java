import java.util.Random;

/*
 * In all questions, you must use ONLY queue data structure. 
 * Don’t use other different data structures like stack, string or normal array. 
 * Create a Linear Queue class with: 
 * Constructor 
 * Enqueue
 * Dequeue
 * Peek
 * isFull 
 * isEmpty
 * Size
 */
public class Main {

	public static void main(String[] args) {
		// 1.Question
		/*
		 * Write a main program that - randomly generates 10 numbers (between -8 and 8),
		 * - inserts negative numbers into Q1 and positive numbers into Q2, - prints the
		 * contents of the queues without removing their elements.
		 */

		System.out.println("------ 1. Question ------");
		Queue q1 = new Queue(100);
		Queue q2 = new Queue(100);

		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * 8 + 1);
			int sign = (int) (Math.random() * 2 + 1);

			if (sign == 1) {
				q1.enqueue(num * (-1));
			}
			else {
				q2.enqueue(num);
			}

		}

		System.out.print("Queue1: ");
		for (int i = 0; i < q1.size(); i++) {
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}

		System.out.print("\nQueue2: ");
		for (int i = 0; i < q2.size(); i++) {
			System.out.print(" " + q2.peek() + " "); // I added " " to the beginning to align the numbers in the queue
														// in the output.
			q2.enqueue(q2.dequeue());
		}

		// 2.Question
		/*
		 * Write a main program that inserts the following numbers into a queue 9 18 15
		 * 2 10 3 5 8 and then prints the integers between 1 and 20 that doesn’t exist
		 * in the queue. Output: 1 4 6 7 11 12 13 14 16 17 19 20
		 */
		System.out.println("\n\n------ 2. Question ------");
		Queue queue = new Queue(1000);

		queue.enqueue(9);
		queue.enqueue(18);
		queue.enqueue(15);
		queue.enqueue(2);
		queue.enqueue(10);
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(8);

		for (int i = 1; i < 21; i++) {
			boolean isExist = false;

			for (int j = 0; j < queue.size(); j++) {
				if ((int) queue.peek() == i) {
					isExist = true;
					break;
				} 
				else {
					queue.enqueue(queue.dequeue());
				}
			}

			if (!isExist) {
				System.out.print(i + " ");
			}

		}

		// 3.Question
		/*
		 * Write a program that randomly generates 10 numbers (between 1 and 8), inserts
		 * into queue and then finds how many distinct elements exist in the queue.
		 * Example : Queue: 1 1 4 3 3 6 6 4 6 4 Output: 4
		 */

		System.out.println("\n\n------ 3. Question ------");
		Queue q = new Queue(100);
		Queue tempq = new Queue(100);

		int qNum = 0;
		System.out.print("Queue: ");

		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * 8 + 1);
			System.out.print(num + " ");
			q.enqueue(num);

		}

		while (!q.isEmpty()) {
			qNum = (int) q.dequeue();

			int count = q.size();

			for (int i = 0; i < count; i++) {
				if (qNum == (int) q.peek()) {
					q.dequeue();
				} 
				else {
					q.enqueue(q.dequeue());
				}

			}
			tempq.enqueue(qNum);
		}

		System.out.print("\nNumber of Distinct Elements: " + tempq.size());

		// 4. Question
		/*
		 * Add 8 random numbers between 6 and 20 into the queue. Generate random numbers
		 * between -5 and 3 continuously. - If the number is negative, remove elements
		 * as the number of times. - If the number is positive, add new random elements
		 * as the number of times. When the queue is empty, stop the program.
		 *
		 * Example: front rear Q 12 8 15 9 7 10 14 6
		 *
		 * generated random number: -3
		 *
		 * Q 9 7 10 14 6
		 *
		 * generated random number: 1
		 *
		 * Q 9 7 10 14 6 11
		 *
		 * generated random number: -1
		 *
		 * Q 7 10 14 6 11
		 * 
		 * generated random number: 3
		 * 
		 * Q 7 10 14 6 11 18 17 12
		 * 
		 * generated random number: -5
		 * 
		 * Q 18 17 12
		 * 
		 * generated random number: -4
		 * 
		 * Q is empty
		 */
		System.out.println("\n\n------ 4. Question ------");
		Queue Q = new Queue(100);
		Random rnd = new Random();

		for (int i = 0; i < 8; i++) {
			int num = rnd.nextInt(15)+6;
			System.out.print(num + " ");
			Q.enqueue(num);

		}

		System.out.println();

		while (!Q.isEmpty()) {
			int num = rnd.nextInt(9) - 5;
			System.out.println("Randomly generated number is " + num);

			if (num < 0) {
				for (int i = 0; i < Math.abs(num); i++) {
					Q.dequeue();

				}
			} 
			else if (num > 0) {
				for (int i = 0; i < Math.abs(num); i++) {
					Q.enqueue(rnd.nextInt(15) + 6);

				}
			}
			
			for (int i = 0; i < Q.size(); i++) {
				System.out.print(Q.peek()+" ");
				Q.enqueue(Q.dequeue());
			}
			
			System.out.println();

		}
	}

}
