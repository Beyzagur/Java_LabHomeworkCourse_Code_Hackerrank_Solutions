public class DoubleLinkedList {
    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    //It adds to the list sequentially.
    public void add(Object dataToAdd) {
        Node newNode;
        if (head == null && tail == null) {
            newNode = new Node(dataToAdd);
            head = newNode;
            tail = newNode;
        } else {
            if(dataToAdd.toString().compareTo(head.getData().toString())<0){
                newNode = new Node(dataToAdd);
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
            else if(dataToAdd.toString().compareTo(head.getData().toString())>0){
                Node temp=head;
                newNode =new Node(dataToAdd);
                while(temp.getNext()!=null && (temp.getNext().getData()).toString().compareTo(dataToAdd.toString())<0){
                    temp=temp.getNext();
                }
                newNode.setPrev(temp);
                newNode.setNext(temp.getNext());

                if(temp.getNext()!=null){
                    temp.getNext().setPrev(newNode);
                }
                else{
                    tail=newNode;
                }
                temp.setNext(newNode);
            }
        }
    }
    //The method of deleting the entered letter by looking at its position relative to m from the list.
    public void remove(String letter)
    {
        if (head == null)
            System.out.println("linked list is empty");
        else
        {
            if(letter.compareTo("M")<=0) {
                if((head.getData()).toString().equals(letter)) {
                    head = head.getNext();
                    head.setPrev(null);
                }
                else {
                    Node temp = head;
                    while (temp != null) {
                        if (((temp.getData()).toString()).equals(letter)) {
                            if (temp.getNext() == null) {
                                tail = tail.getPrev();
                                tail.setNext(null);
                            } else {
                                temp.getPrev().setNext(temp.getNext());
                                temp.getNext().setPrev(temp.getPrev());
                            }
                        }
                        temp = temp.getNext();
                    }
                }
            }
            else{
                if((tail.getData()).toString().equals(letter)) {
                    tail = tail.getPrev();
                    tail.setNext(null);
                }
                else {
                    Node temp = tail;
                    while (temp != null) {
                        if (((temp.getData()).toString()).equals(letter)) {
                            if (temp.getPrev() == null) {
                                head = head.getNext();
                                head.setPrev(null);
                            } else {
                                temp.getNext().setPrev(temp.getPrev());
                                temp.getPrev().setNext(temp.getNext());
                            }
                        }
                        temp = temp.getPrev();
                    }
                }
            }
        }
    }
    //Checks whether the letter is in the list.
    public boolean dllsearch(String value){
        Node temp = head;

        while(temp != null) {

            if((temp.getData()).toString().compareTo(value)==0) {
               return true;
            }
            temp = temp.getNext();
        }
       return false;
    }
    //Displays the list on screen.
    public void display() {
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
}