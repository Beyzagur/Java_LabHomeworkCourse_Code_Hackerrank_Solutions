public class CircularLinkedList {
    private Node head;


    public void add(String dataToAdd){
        Node temp;
        if(head==null){ //list is empty
            Node newnode=new Node(dataToAdd);
            head=newnode;
            head.setLink(head);
        }
        else{ //add to the beginning list
                temp=head;
                do{
                    temp=temp.getLink();
                }while(temp.getLink()!=head);

                Node newnode=new Node(dataToAdd);
                newnode.setLink(head);
                temp.setLink(newnode);
                head=newnode;

        }

    }

    public void Josephus(int y){
        int count=0;
        Node temp=head;
        while(this.count()!=1){
            count++;
            if(count==y){
                if(temp.getLink()==head){
                    head=temp;
                }
                temp.setLink(temp.getLink().getLink());
                count = 0;
            }
            temp=temp.getLink();

        }
        System.out.println("Remaining element is : " + temp.getData());
    }

    public int count(){
        int count=0;
        if(head==null)
            System.out.println("linked list is empty");
        else{
            Node temp=head;
            do{
                count++;
                temp=temp.getLink();
            }while(temp!=head);
        }
        return count;
    }

    public void display(){
        if(head==null){
            System.out.println("linked list is empty");
        }
        else{
            Node temp=head;
            do{
                System.out.print(temp.getData()+" ");
                temp=temp.getLink();
            }while(temp!=head);
            System.out.println();
        }
    }

}
