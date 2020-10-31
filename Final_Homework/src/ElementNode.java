public class ElementNode {
	private String elementName;
	private ElementNode next;

	public ElementNode(String dataToAdd) {
		this.elementName = dataToAdd;
		this.next = null;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String data) {
		this.elementName = data;
	}

	public ElementNode getNext() {
		return next;
	}

	public void setNext(ElementNode next) {
		this.next = next;
	}

}