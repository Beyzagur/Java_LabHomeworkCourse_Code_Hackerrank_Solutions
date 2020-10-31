public class CircularLinkedList {

    private Node head;

    public CircularLinkedList() {
        this.head = head;
    }

    //The whole word is separated into letters and added to the list.
    public void add(Object dataToAdd)
    {
        for (int i = dataToAdd.toString().length(); i >0; i--) {
            Node newNode = new Node(dataToAdd.toString().toUpperCase().substring(i-1,i));

            if(head == null)
            {
                head = newNode;
                head.setNext(head);
            }
            else
            {
                Node temp = head;

                while(temp.getNext() != head)
                {
                    temp = temp.getNext();
                }

                temp.setNext(newNode);
                newNode.setNext(head);
                head = newNode;
            }
        }
    }
    //Displays the list on screen.
    public void display()
    {
        if(head == null)
        {
            System.out.println("List is empty!");
        }

        Node temp = head;

        do{
            System.out.print(temp.getData() );
            temp = temp.getNext();
        }
        while(temp != head);

    }
    //The letter entered is added to csll according to its position in the word.
    public void addletter(String letter, CircularLinkedList csll1){
        if (head == null){
            System.out.println("Error");
        }else {
            Node csll1current = csll1.head;
            Node csll2temp=head;
            do{
                if ((csll1current.getData()).toString().compareTo(letter)==0){
                    csll2temp.setData(letter);
                }
                csll1current = csll1current.getNext();
                csll2temp=csll2temp.getNext();
            }while (csll1current != csll1.head);
        }
    }
    //Checks whether the letter is in the list.
    public boolean search(String letter){
        Node temp=head;
        do{
            if((temp.getData()).toString().compareTo(letter)==0){
                return true;
            }
            temp=temp.getNext();
        }while(temp!=head);
        return false;
    }
}