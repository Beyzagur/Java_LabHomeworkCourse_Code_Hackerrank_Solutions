public class RowNode {
	private String rowNo;
	private RowNode down;
	private ElementNode right;

	public RowNode(String dataToAdd) {
		this.rowNo = dataToAdd;
		this.down = null;
		this.right = null;
	}

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String data) {
		this.rowNo = data;
	}

	public RowNode getDown() {
		return down;
	}

	public void setDown(RowNode down) {
		this.down = down;
	}

	public ElementNode getRight() {
		return right;
	}

	public void setRight(ElementNode right) {
		this.right = right;
	}

}
