public class SingleLinkedList {
	
	private Node head;
	
	public SingleLinkedList(Node head) {
		this.head = head;
	}

	public void insert(Object dataToAdd) {
		if (head == null) {
			Node newnode = new Node(dataToAdd);
			head = newnode;
		} else {
			Node temp = head;
			while (temp.getLink() != null)
				temp = temp.getLink();
			Node newnode = new Node(dataToAdd);
			temp.setLink(newnode);
		}
	}

	public void display() {
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			Node temp = head;//We duplicated it to avoid losing "head".
			while (temp != null) {
				System.out.print(temp.getData());
				temp = temp.getLink();
			}

		}

	}
	
	public void barGraph() {
		for (int i = 65; i < 70; i++) {
			Node temp = head;
			System.out.print((char)i);
			while (temp.getLink() != null) {
				if((char)temp.getData()==(char)i) {
					System.out.print("*");	
				}
				temp = temp.getLink();
			}
			if(temp.getLink() == null) {
				if((char)temp.getData()==(char)i) {
					System.out.print("*");
				}
			}
				
			System.out.println();
			
		}
	
	}
}
