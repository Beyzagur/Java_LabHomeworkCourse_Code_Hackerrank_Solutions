public class Node {
    private Object data;
    private Object data2;
    private Node prev;
    private Node next;

    public Node(Object dataToAdd) {
        this.data = dataToAdd;
        this.prev = null;
        this.next = null;
    }
    public Node(Object dataToAdd,Object dataToAdd2) {
        this.data = dataToAdd.toString()+dataToAdd2.toString(); //It was written to keep two data as one data.
        this.data2=dataToAdd2;
        this.prev = null;
        this.next = null;
    }

    public Object getData2() {
        return data2;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}