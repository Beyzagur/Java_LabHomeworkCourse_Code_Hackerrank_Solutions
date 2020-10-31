import java.util.Random;
import java.util.*;

public class Main {

	static Scanner scn = new Scanner(System.in);
	static Stack humanstack = new Stack(20);
	static Stack computerstack = new Stack(20);
	static Stack tablestack = new Stack(24);
	static Stack temp = new Stack(24);
	static Stack temp1 = new Stack(24);
	static Stack temp2 = new Stack(24);
	static Stack temp3 = new Stack(24);
	static Stack temp4 = new Stack(24);
	static Random rnd = new Random();
	static int humanbook = 0;
	static int computerbook = 0;
	static int turn = 1;

	public static int cardChecker(Stack checkthis, int num) {// The function that allows the calculation of numbers on the card.
		Stack cardstack = new Stack(24);
		int counter = 0;
		int save = checkthis.size();

		for (int i = 0; i < save; i++) {
			cardstack.push(checkthis.pop());

			if ((int) cardstack.peek() == num) {
				counter++;
			}
		}
		for (int i = 0; i < save; i++) {
			checkthis.push(cardstack.pop());
		}
		return counter;
	}

	public static boolean controll(Stack controlthis, int number) {//A function that checks if the number is in a stack.
		Stack controlstack = new Stack(24);
		boolean flag = false;
		int save = controlthis.size();
		for (int i = 0; i < save; i++) {
			if ((int) controlthis.peek() == number) {
				flag = true;
			}
			controlstack.push(controlthis.pop());
		}
		for (int i = 0; i < save; i++) {
			controlthis.push(controlstack.pop());
		}
		return flag;
	}

	public static Stack extraction(Stack extractionthis, int number) {//The function to extract the required number or numbers from the stack.
		Stack extractionstack = new Stack(24);
		Stack temp = new Stack(24);

		int save = extractionthis.size();
		for (int i = 0; i < save; i++) {
			if ((int) extractionthis.peek() == number) {
				temp.push(extractionthis.pop());
			} else {
				extractionstack.push(extractionthis.pop());
			}
		}
		save = extractionstack.size();
		for (int i = 0; i < save; i++) {
			extractionthis.push(extractionstack.pop());
		}
		return temp;//Returns the desired number stack.
	}

	public static void createScreen() {//The function that prints the playing field on the screen.
		System.out.println("*".repeat(80));
		System.out.println("Turn:" + turn);
		int size = humanstack.size();
		System.out.print("Human:   ");
		for (int i = 0; i < size; i++) {
			temp4.push(humanstack.pop());
		}
		for (int i = 0; i < size; i++) {
			humanstack.push(temp4.pop());
			System.out.print(humanstack.peek());
		}
		System.out.print("\t\tBook:" + humanbook);

		size = computerstack.size();
		System.out.print("\nComputer:");
		for (int i = 0; i < size; i++) {
			temp4.push(computerstack.pop());
		}
		for (int i = 0; i < size; i++) {
			computerstack.push(temp4.pop());
			System.out.print(computerstack.peek());
		}
		System.out.print("\t\tBook:" + computerbook);

		size = tablestack.size();
		System.out.print("\t\tTable:");
		for (int i = 0; i < size; i++) {
			temp4.push(tablestack.pop());
		}
		for (int i = 0; i < size; i++) {
			tablestack.push(temp4.pop());
			System.out.print(tablestack.peek());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {//Numbers are assigned to tablestack in sequence.
			tablestack.push(1);
			tablestack.push(2);
			tablestack.push(3);
			tablestack.push(4);
			tablestack.push(5);
			tablestack.push(6);
		}

		for (int i = 0; i < 20; i++) {//Turning 20 times, shuffling the cards takes place.
			for (int j = 0; j < 6; j++) {//The ordered tablestack elements are put into 4 different stacks, respectively.
				temp.push(tablestack.pop());
				temp1.push(tablestack.pop());
				temp2.push(tablestack.pop());
				temp3.push(tablestack.pop());
			}
			
			do {//Here, according to the random number, numbers from other stacks are discarded on tablestack.
				int num = rnd.nextInt(4);
				if (num == 0 && !temp.isEmpty()) {
					tablestack.push(temp.pop());
				} else if (num == 1 && !temp1.isEmpty()) {
					tablestack.push(temp1.pop());
				} else if (num == 2 && !temp2.isEmpty()) {
					tablestack.push(temp2.pop());
				} else {
					if (!temp3.isEmpty()) {
						tablestack.push(temp3.pop());
					}
				}
			} while (!tablestack.isFull());
		}

		for (int i = 0; i < 7; i++) {//humanstack is created.
			humanstack.push(tablestack.pop());
		}

		for (int i = 0; i < 7; i++) {//computerstack is created.
			computerstack.push(tablestack.pop());
		}

		boolean isGame = true;
		boolean isPlayerturn = true;
		//The game starts here.
		while (isGame) {
			createScreen();

			if (isPlayerturn) {// The player's tour.
				int number = 0;

				System.out.print("You ask:");
				try {
					number = scn.nextInt();//number is entered.
				} catch (Exception e) {//If something other than the number is entered, the game ends.
					System.exit(0);
				}
				
				if (controll(humanstack, number)) {//if humanstack also has a number
					if (controll(computerstack, number)) {//if computerstack also has a number
						temp1 = extraction(computerstack, number);//Subtract that number from computerstack and throw it into the stack of temp1.
						int size = temp1.size();//The length of temp1stack is kept in a variable.
						for (int i = 0; i < size; i++) {
							humanstack.push(temp1.pop());//thrown into humanstack from temp1.
						}
						if (cardChecker(humanstack, number) == 4) {//if the number of that number in humanstack is 4
							humanbook++;//The number of humanbook has increased by 1.
							extraction(humanstack, number);//That number has been removed from Humanstack.
							System.out.println(Integer.toString(number).repeat(4));//that number is printed 4 times on the screen.
							if (humanstack.isEmpty()) {//if humanstack is empty
								isGame = false;//the game ends.
							}
						}
					} else {//if that number is not on computerstack
						System.out.println("Computer says 'Go fish'");
						humanstack.push(tablestack.pop());//A new number is assigned to humanstack from tablestack.
						if ((int) humanstack.peek() == number) {//if the number on humanstack is that number
							if (cardChecker(humanstack, number) == 4) {
								humanbook++;
								extraction(humanstack, number);
								System.out.println(Integer.toString(number).repeat(4));
								if (humanstack.isEmpty()) {
									isGame = false;
								}
							}
						} else {//if the last number in humanstack is not that number
							if (cardChecker(humanstack, number) == 4) {
								humanbook++;
								extraction(humanstack, number);
								System.out.println(Integer.toString(number).repeat(4));
								if (humanstack.isEmpty()) {
									isGame = false;
								}
							}
							isPlayerturn = false;//turns to the computer.
						}
					}
				} else {//If there is no number entered in humanstack
					System.out.println("Wrong number!");
					System.out.println("Please try again");
				}

			} else {// computer tour
				boolean computer = true;
				int number = 0;
				while (computer) {//the computer chooses a random number.
					number = rnd.nextInt(6) + 1;
					if (controll(computerstack, number)) {//if computerstack also has a number
						computer = false;
					}
				}
				System.out.println("Computer asks:" + number);
				if (controll(humanstack, number)) {////if humanstack also has a number
					temp1 = extraction(humanstack, number);//Subtract that number from humanstack and throw it into the stack of temp1.
					int size = temp1.size();//The length of temp1stack is kept in a variable.
					for (int i = 0; i < size; i++) {
						computerstack.push(temp1.pop());//thrown into computerstack from temp1.
					}
					if (cardChecker(computerstack, number) == 4) {//if the number of that number in computerstack is 4
						computerbook++;//The number of computerbook has increased by 1.
						extraction(computerstack, number);//That number has been removed from computerstack.
						System.out.println(Integer.toString(number).repeat(4));//that number is printed 4 times on the screen.
						if (computerstack.isEmpty()) {//if computerstack is empty
							isGame = false;//the game ends.
						}
					}
					if (humanstack.isEmpty()) {//if humanstack is empty
						isGame = false;
					}

				} else {//if that number is not on humanstack
					System.out.println("You say 'Go fish'");
					computerstack.push(tablestack.pop());//A new number is assigned to computerstack from tablestack.
					if ((int) computerstack.peek() == number) {//if the number on computerstack is that number
						if (cardChecker(computerstack, number) == 4) {
							computerbook++;
							extraction(computerstack, number);
							System.out.println(Integer.toString(number).repeat(4));
							if (computerstack.isEmpty()) {
								isGame = false;
							}
						}
					} else {//if the number on computerstack is not that number
						if (cardChecker(computerstack, (int) computerstack.peek()) == 4) {//computerstack üzerindeki son sayý computerstack içinde varsa ve 4 tane ise
							computerbook++;
							extraction(computerstack, (int) computerstack.peek());
							System.out.println(Integer.toString(number).repeat(4));
							if (computerstack.isEmpty()) {
								isGame = false;
							}
						}
						isPlayerturn = true;//the turn passes to the player.
					}
				}
			}
			turn++;//the number of turns1 increases.
		}
		System.out.println("Game is over");
		//the part where the winner is determined.
		if (humanbook > computerbook) {
			System.out.println("You win the game !!");
		} else if (computerbook > humanbook) {
			System.out.println("Computer win the game !!");
		} else {
			System.out.println("Game is tie !!");
		}
	}
}
