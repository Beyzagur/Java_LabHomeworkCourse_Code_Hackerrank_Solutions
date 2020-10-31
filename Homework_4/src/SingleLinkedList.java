public class SingleLinkedList {

	public class Node {
		private Object data;
		private Node link;
		
		public Node(Object dataToAdd) {
			this.data = dataToAdd;
			this.link = null;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public Node getLink() {
			return link;
		}
		public void setLink(Node link) {
			this.link = link;
		}
	}
	
	private Node head;

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

	public int size1() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.getLink();
		}
		return count;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData());
			temp = temp.getLink();
		}

	}

	public Object getElement(int x) {
		Node temp= head;
		int count=1;
		while(temp!=null) {
			if(count==x)
				return temp.getData();
			temp=temp.getLink();
			count++;
		}
		return null;
	}
	
}
