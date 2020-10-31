public class MultiLinkedList {
	private RowNode head;

	public MultiLinkedList() {
		this.head = null;
	}

	public void addRow(String dataToAdd) {
		if (head == null) {
			RowNode newnode = new RowNode(dataToAdd);
			head = newnode;
		} else {
			RowNode temp = head;
			while (temp.getDown() != null) {
				temp = temp.getDown();
			}
			RowNode newnode = new RowNode(dataToAdd);
			temp.setDown(newnode);
		}
	}

	public void addElement(String row, int element) {
		if (head == null) {
			System.out.println("Add a row before element");
		} else {
			RowNode temp = head;
			while (temp != null) {
				if (row.equals(temp.getRowNo())) {
					ElementNode temp2 = temp.getRigth();
					if (temp2 == null) {
						ElementNode newnode = new ElementNode(element);
						temp.setRigth(newnode);
					} else {
						while (temp2.getNext() != null) {
							temp2 = temp2.getNext();
						}
						ElementNode newnode = new ElementNode(element);
						temp2.setNext(newnode);
					}
				}
				temp = temp.getDown();
			}
		}
	}

	public void display() {
		if (head == null) {
			System.out.println("Linked list is empty");
		} else {
			RowNode temp = head;
			while (temp != null) {
				System.out.print(temp.getRowNo() + " --> ");
				ElementNode temp2 = temp.getRigth();
				while (temp2 != null) {
					System.out.print(temp2.getElementNumber() + " ");
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
				System.out.println();
			}
		}
	}

	public int sizeRow() {
		int count = 0;
		if (head == null) {
			System.out.println("Linked list is empty");
		} else {
			RowNode temp = head;
			while (temp != null) {
				count++;
				temp = temp.getDown();
			}
		}
		return count;
	}
	
	//Checks whether there is a scalar.
	public boolean control() {
		RowNode temp = head;
		int diagonal = temp.getRigth().getElementNumber();
		ElementNode temp2;
		for (int i = 0; i < this.sizeRow(); i++) {
			temp2 = temp.getRigth();
			for (int j = 0; j < this.sizeRow(); j++) {
				if(i==j) {
					if(temp2.getElementNumber()!=diagonal) {
						return false;
					}
				}
				else {
					if(temp2.getElementNumber()!=0) {
						return false;
					}
				}
				temp2 = temp2.getNext();
			}
			temp =temp.getDown();
		}
		return true;		
	}
	
}
