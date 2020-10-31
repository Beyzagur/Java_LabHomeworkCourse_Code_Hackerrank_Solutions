import java.util.Random;
public class Main {
	
	static Random rnd = new Random();
	public static void dna(Queue dna_queue) {//the procedure that allows q1 and q6 to be filled randomly.
		do {
			int num = rnd.nextInt(4) + 1;
			if (num == 1) {
				dna_queue.enqueue('A');
			} else if (num == 2) {
				dna_queue.enqueue('T');
			} else if (num == 3) {
				dna_queue.enqueue('G');
			} else {
				dna_queue.enqueue('C');
			}
		}while(dna_queue.size()!=21);
	}
	
	public static void main(String[] args) {
		Queue q1 = new Queue(1000);//main dna queue
		Queue q2 = new Queue(1000);//complement dna queue
		Queue q3 = new Queue(1000);
		Queue q4 = new Queue(1000);
		Queue q5 = new Queue(1000); 
		Queue q6 = new Queue(1000);//crossover dna queue
		char temp=' ';
		char temp1=' ';
		char temp2=' ';
		dna(q1);
		dna(q6);
		int size = q1.size();//the size of q1 in was assigned to a variable.
		System.out.print("***Complement***\nQueue1: ");
		//in this section, q1 is printed on the screen and complement q2 is also created.
		for (int i = 0; i < size; i++) {
			System.out.print(q1.peek()+" ");
			if ((char)q1.peek()== 'A') {
				q2.enqueue('T');
			} if ((char)q1.peek()== 'T') {
				q2.enqueue('A');
			} if ((char)q1.peek() == 'G') {
				q2.enqueue('C');
			} if ((char)q1.peek() == 'C') {
				q2.enqueue('G');
			}
			q1.enqueue(q1.dequeue());
		}
		//q2 is printed on the screen.
		System.out.print("\nQueue2: ");
		for (int i = 0; i < size; i++) {
			System.out.print(q2.peek() + " ");
			q2.dequeue();
		}
		//tripartite dna groups and their corresponding amino acids.
		q3.enqueue("AAA"); q4.enqueue("Lys"); q3.enqueue("ACA"); q4.enqueue("Thr"); q3.enqueue("ATA"); q4.enqueue("Ile"); q3.enqueue("AGA"); q4.enqueue("Arg");
		q3.enqueue("CAA"); q4.enqueue("Gln"); q3.enqueue("CCA"); q4.enqueue("Pro");	q3.enqueue("CTA"); q4.enqueue("Leu"); q3.enqueue("CGA"); q4.enqueue("Arg");
		q3.enqueue("AAC"); q4.enqueue("Asn"); q3.enqueue("ACC"); q4.enqueue("Thr");	q3.enqueue("ATC"); q4.enqueue("Ile"); q3.enqueue("AGC"); q4.enqueue("Ser");
		q3.enqueue("CAC"); q4.enqueue("His"); q3.enqueue("CCC"); q4.enqueue("Pro");	q3.enqueue("CTC"); q4.enqueue("Leu"); q3.enqueue("CGC"); q4.enqueue("Arg");
		q3.enqueue("AAT"); q4.enqueue("Asn"); q3.enqueue("ACT"); q4.enqueue("Thr");	q3.enqueue("ATT"); q4.enqueue("Ile"); q3.enqueue("AGT"); q4.enqueue("Ser");
		q3.enqueue("CAT"); q4.enqueue("His"); q3.enqueue("CCT"); q4.enqueue("Pro");	q3.enqueue("CTT"); q4.enqueue("Leu"); q3.enqueue("CGT"); q4.enqueue("Arg");
		q3.enqueue("AAG"); q4.enqueue("Lys"); q3.enqueue("ACG"); q4.enqueue("Thr");	q3.enqueue("ATG"); q4.enqueue("Met"); q3.enqueue("AGG"); q4.enqueue("Arg");
		q3.enqueue("CAG"); q4.enqueue("Gln"); q3.enqueue("CCG"); q4.enqueue("Pro");	q3.enqueue("CTG"); q4.enqueue("Leu"); q3.enqueue("CGG"); q4.enqueue("Arg");
		q3.enqueue("TAA"); q4.enqueue("STOP");q3.enqueue("TCA"); q4.enqueue("Ser");	q3.enqueue("TTA"); q4.enqueue("Leu"); q3.enqueue("TGA"); q4.enqueue("STOP");
		q3.enqueue("TAC"); q4.enqueue("Tyr"); q3.enqueue("TAT"); q4.enqueue("Tyr");	q3.enqueue("TAG"); q4.enqueue("STOP");q3.enqueue("TCC"); q4.enqueue("Ser");
		q3.enqueue("TTC"); q4.enqueue("Phe"); q3.enqueue("TGC"); q4.enqueue("Cys");	q3.enqueue("TCT"); q4.enqueue("Ser"); q3.enqueue("TCG"); q4.enqueue("Ser");
		q3.enqueue("TTT"); q4.enqueue("Phe"); q3.enqueue("TTG"); q4.enqueue("Leu");	q3.enqueue("TGT"); q4.enqueue("Cys"); q3.enqueue("TGG"); q4.enqueue("Trp");
		q3.enqueue("GAA"); q4.enqueue("Glu"); q3.enqueue("GAC"); q4.enqueue("Asp");	q3.enqueue("GAT"); q4.enqueue("Asp"); q3.enqueue("GAG"); q4.enqueue("Glu");
		q3.enqueue("GCA"); q4.enqueue("Ala"); q3.enqueue("GCC"); q4.enqueue("Ala");	q3.enqueue("GCT"); q4.enqueue("Ala"); q3.enqueue("GCG"); q4.enqueue("Ala");
		q3.enqueue("GTA"); q4.enqueue("Val"); q3.enqueue("GTC"); q4.enqueue("Val");	q3.enqueue("GTT"); q4.enqueue("Val"); q3.enqueue("GTG"); q4.enqueue("Val");
		q3.enqueue("GGA"); q4.enqueue("Gly"); q3.enqueue("GGC"); q4.enqueue("Gly");	q3.enqueue("GGT"); q4.enqueue("Gly"); q3.enqueue("GGG"); q4.enqueue("Gly");
		
		for (int i = 0; i < 7; i++) {
			temp=(char)q1.dequeue();//the value in q1 is added to temp.
			temp1=(char)q1.dequeue();//the value in q1 is added to temp1.
			temp2=(char)q1.dequeue();//the value in q1 is added to temp2.
			for (int j = 0; j < 64; j++) {
				if(temp==((String) q3.peek()).charAt(0)) {//if the character in temp is the first character of the string in q3
					if(temp1==((String) q3.peek()).charAt(1)) {//if the character in temp is the second character of the string in q3
						if(temp2==((String) q3.peek()).charAt(2)) {//if the character in temp is the third character of the string in q3
							q5.enqueue(q4.peek());//assign the name of the amino acid in q4 to q5.
						}
					}
				}
				q3.enqueue(q3.dequeue());//take it from the front of q3 and add it to the end of q3.
				q4.enqueue(q4.dequeue());//take it from the front of q4 and add it to the end of q4.
			}
			q1.enqueue(temp);//the value in temp is added to q1.
			q1.enqueue(temp1);//the value in temp1 is added to q1.
			q1.enqueue(temp2);//the value in temp2 is added to q1.
		}
		System.out.print("\n\n***Amino Acids***\nQueue1: ");
		for (int i = 0; i < size; i++) {//q1 is printed on the screen.
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());//take it from the front of q1 and add it to the end of q1.
		}
		System.out.println();
		System.out.print("Queue5: ");
		for (int i = 0; i < 7; i++) {//q5 is printed on the screen.
			System.out.print(q5.peek() + " ");
			q5.dequeue();
		}
		
		int num2=rnd.nextInt(21)+1;
		System.out.print("\n\n***Crossover***\nQueue1: ");
		for (int i = 0; i < size; i++) {//q1 is printed on the screen.
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}
		System.out.print("\nQueue6: ");
		for (int i = 0; i < size; i++) {//q6 is printed on the screen.
			System.out.print(q6.peek() + " ");
			q6.enqueue(q6.dequeue());//take it from the front of q6 and add it to the end of q6.
		}
		//this is the part where the "crossover" is performed.
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < num2; j++) {
				q1.enqueue(q1.dequeue());
				q6.enqueue(q6.dequeue());
			}
			for (int j = num2; j <size; j++) {
				q1.enqueue(q6.dequeue());//take it from the front of q6 and add it to the end of q1.
				q6.enqueue(q1.dequeue());//take it from the front of q1 and add it to the end of q6.
			}
		}
		
		System.out.println("\n\nRandomly generated crossover point:"+num2);
		System.out.print("\nAfter Crossover:\nQueue1: ");
		for (int i = 0; i < size; i++) {
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}
		System.out.print("\nQueue6: ");
		for (int i = 0; i < size; i++) {
			System.out.print(q6.peek() + " ");
			q6.enqueue(q6.dequeue());
		}	
	}	
}
