import java.io.File;
import java.util.Scanner;

public class TransportationSystem {
	public class Person {
		public int Id;
		public String Station;
		public int age;
		public String type;

		public Person(int id, String station, int age, String type) {
			Id = id;
			Station = station;
			this.age = age;
			this.type = type;
		}

		public int getId() {
			return Id;
		}

		public String getStation() {
			return Station;
		}

		public int getAge() {
			return age;
		}

		public String getType() {
			return type;
		}

	}

	public void screen(PriorityQueue pq) {
		PriorityQueue temp = new PriorityQueue(1000);
		int save = pq.size();
		for (int i = save; i > 0; i--) {
			System.out.print(((Person) pq.peek().getData()).getId() + " " + ((Person) pq.peek().getData()).getStation()
					+ " " + ((Person) pq.peek().getData()).getAge() + " " + ((Person) pq.peek().getData()).getType());
			temp.enqueue(pq.dequeue());
			System.out.println();
		}
		for (int i = 0; i < save; i++) {
			pq.enqueue(temp.dequeue());
		}
	}

	public TransportationSystem() {
		// TODO Auto-generated method stub
		PriorityQueue B1 = new PriorityQueue(1000);
		PriorityQueue B2 = new PriorityQueue(1000);
		int count = 0;
		int counter = 0;
		int tour=0;

		File file = new File("C:\\Users\\beyza\\OneDrive\\Masaüstü\\data.txt");
		try {
			Scanner scn = new Scanner(file);
			while (scn.hasNextLine()) {
				String line = scn.nextLine();
				String[] Line = line.split(" ");
				Person person = new Person(Integer.parseInt(Line[0]), Line[1], Integer.parseInt(Line[2]), Line[3]);
				if (Integer.parseInt(Line[2]) >= 70) {
					QueueElement qe = new QueueElement(person, 1);
					if (Line[1].equals("B1")) {
						B1.enqueue(qe);

					}
					if (Line[1].equals("B2")) {
						B2.enqueue(qe);
					}
				} else {
					QueueElement qe = new QueueElement(person, 0);
					if (Line[1].equals("B1")) {
						B1.enqueue(qe);
						if (Integer.parseInt(Line[2]) < 65) {
							if (Line[3].equals("student")) {
								count += 1;
							} else if (Line[3].equals("normal")) {
								count += 2;
							}
						}

					}
					if (Line[1].equals("B2")) {
						B2.enqueue(qe);
						if (Integer.parseInt(Line[2]) < 65) {
							if (Line[3].equals("student")) {
								count += 1;
							} else if (Line[3].equals("normal")) {
								count += 2;
							}
						}
					}
				}

			}

			System.out.println("Priority Queue B1");
			System.out.println("Front");
			screen(B1);
			System.out.println("Rear");
			System.out.println("\nPriority Queue B2");
			System.out.println("Front");
			screen(B2);
			System.out.println("Rear");


			while (!B1.isEmpty() || !B2.isEmpty()) {
				counter = 0;
				tour++;
				while (!B1.isEmpty() && counter < 8) {
					B1.dequeue();
					counter++;
				}
				while (!B2.isEmpty() && counter < 8) {
					B2.dequeue();
					counter++;
				}
				System.out.println("\n** After Tour "+tour+" **");
				System.out.println("Priority Queue B1");
				System.out.println("Front");
				screen(B1);
				System.out.println("Rear");
				System.out.println("\nPriority Queue B2");
				System.out.println("Front");
				screen(B2);
				System.out.println("Rear");
				
			}
			System.out.println("\n***Overall Income: "+count+" TL");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("File not found!");
		}

	}
}
