public class DoubleLinkedList {
	private Node head;
	private Node tail;

	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(Object dataToAdd) {
		Node newNode;
		if (head == null && tail == null) {
			newNode = new Node(dataToAdd);
			head = newNode;
			tail = newNode;
		} else { // add to the end
			newNode = new Node(dataToAdd);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public int size() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public void display1() {
		if (head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
			System.out.println();
		}
	}

	public void display2() {
		if (head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = tail;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getPrev();
			}
			System.out.println();
		}
	}

	public void swap(int num) {
		Node temp = head, temp2 = tail;
		if (num == 1 || num == this.size()) {
			Node newnode = new Node(temp.getData());
			Node newnode2 = new Node(temp2.getData());
			newnode2.setNext(temp.getNext());
			temp.getNext().setPrev(newnode2);
			head = newnode2;
			newnode.setPrev(temp2.getPrev());
			temp2.getPrev().setNext(newnode);
			tail = newnode;

		} else {
			for (int i = 0; i < num - 2; i++) {
				temp = temp.getNext();
				temp2 = temp2.getPrev();
			}
			Node newnode = new Node(temp.getNext().getData());
			Node newnode2 = new Node(temp2.getPrev().getData());
			newnode2.setPrev(temp);
			newnode2.setNext(temp.getNext().getNext());
			if (temp.getNext() != null)
				temp.getNext().getNext().setPrev(newnode2);
			else
				tail = newnode;
			temp.setNext(newnode2);

			newnode.setPrev(temp2.getPrev().getPrev());
			newnode.setNext(temp2);
			if (temp2.getPrev() != null)
				temp2.setPrev(newnode);
			else
				head = newnode;
			temp2.getPrev().getPrev().setNext(newnode);

		}

	}

}
