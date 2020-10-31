public class ElementNode {
	private int elementNumber;
	private ElementNode next;

	public ElementNode(int dataToAdd) {
		this.elementNumber = dataToAdd;
		this.next = null;
	}

	public int getElementNumber() {
		return elementNumber;
	}

	public void setElementNumber(int data) {
		this.elementNumber = data;
	}

	public ElementNode getNext() {
		return next;
	}

	public void setNext(ElementNode next) {
		this.next = next;
	}

}
