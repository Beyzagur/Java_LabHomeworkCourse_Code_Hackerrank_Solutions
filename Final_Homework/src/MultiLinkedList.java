public class MultiLinkedList {
    private RowNode head;

    public MultiLinkedList() {
        this.head = null;
    }

    //A method of adding the dimensions of words so that words of the same size coexist in the list.
    public void addRow(String dataToAdd) {
        if (head == null) {
            RowNode newnode = new RowNode(dataToAdd);
            head = newnode;
        } else {
            if(Integer.parseInt(dataToAdd)<Integer.parseInt(head.getRowNo())){
                RowNode newnode = new RowNode(dataToAdd);
                newnode.setDown(head);
                head=newnode;
            }
            else if(Integer.parseInt(dataToAdd)>Integer.parseInt(head.getRowNo())){
                RowNode temp=head;
                RowNode previous=null;
                while(temp!=null && Integer.parseInt(dataToAdd)>Integer.parseInt(temp.getRowNo())){
                    previous=temp;
                    temp=temp.getDown();
                }

                if (temp == null) {
                    RowNode newnode = new RowNode(dataToAdd);
                    previous.setDown(newnode);
                } else {
                    if(Integer.parseInt(dataToAdd)!=Integer.parseInt(temp.getRowNo())) {
                        RowNode newnode = new RowNode(dataToAdd);
                        newnode.setDown(temp);
                        previous.setDown(newnode);
                    }
                }

            }
        }
    }
    //A method of adding words to the list alphabetically.
    public void addElement(String row, String element) {
        if (head == null) {
            System.out.println("Add a row before element");
        } else {
            RowNode temp = head;
            while (temp != null) {
                if (row.equals(temp.getRowNo())) {
                    ElementNode temp2 = temp.getRight();
                    if (temp2 == null) {
                        ElementNode newnode = new ElementNode(element.toUpperCase());
                        temp.setRight(newnode);
                    }
                    else {
                        if (element.toUpperCase().compareTo(temp2.getElementName()) < 0) {
                            ElementNode newnode = new ElementNode(element.toUpperCase());
                            temp.setRight(newnode);
                            newnode.setNext(temp2);
                        }
                        else if (element.toUpperCase().compareTo(temp2.getElementName()) > 0) {
                            ElementNode previous = null;
                            while (temp2 != null && (element.toUpperCase().compareTo(temp2.getElementName()) > 0)) {
                                previous = temp2;
                                temp2 = temp2.getNext();
                            }
                            if (element.toUpperCase().compareTo(previous.getElementName()) > 0) {
                                ElementNode newnode = new ElementNode(element.toUpperCase());
                                previous.setNext(newnode);
                                newnode.setNext(temp2);

                            } else if (temp2 != null && (element.toUpperCase().compareTo(previous.getElementName()) < 0)) {
                                ElementNode newnode = new ElementNode(element.toUpperCase());
                                previous.setNext(newnode);
                            }
                        }
                    }
                }
                temp = temp.getDown();
            }
        }
    }
    //Method of finding the word in that position
    public Object elementX(int index)
    {
        if(head == null)
        {
            return null;
        }

        RowNode temp = head;
        ElementNode temp2=temp.getRight();
        for (int i = 1; i < index; i++) {
            temp2 = temp2.getNext();
            if(temp2==null){
                temp=temp.getDown();
                temp2=temp.getRight();
            }
        }
        return temp2.getElementName();
    }
    //The size of the list.
    public int size() {
        int count = 0;
        if (head == null) {
            System.out.println("Linked list is empty");
        } else {
            RowNode temp = head;
            ElementNode temp2=temp.getRight();
            while (temp != null) {
                count++;
                temp2 = temp2.getNext();
                if(temp2==null ) {
                    temp = temp.getDown();
                    if(temp!=null) {
                        temp2 = temp.getRight();
                    }
                }
            }
        }
        return count;
    }

    public RowNode getHead()
    {
        return this.head;
    }

    /* //Displays the list on screen.
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty");
        } else {
            RowNode temp = head;
            while (temp != null) {
                System.out.print(temp.getRowNo() + " --> ");
                ElementNode temp2 = temp.getRight();
                while (temp2 != null) {
                    System.out.print(temp2.getElementName() + " ");
                    temp2 = temp2.getNext();
                }
                temp = temp.getDown();
                System.out.println();
            }
        }
    }*/
}