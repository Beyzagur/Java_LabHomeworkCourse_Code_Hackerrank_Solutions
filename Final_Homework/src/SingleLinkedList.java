import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SingleLinkedList {

    private Node head;

    public SingleLinkedList() {
        this.head = head;
    }

    //The player and the player's score are added to the list from large to small according to the other players' score.
    public void insert(User player,int dataToAdd) {
        if (head == null) {
            Node newnode = new Node(player.getName()+"=",player.getScore());
            head = newnode;
        } else {
            Node temp= head;
            if(Integer.parseInt(temp.getData2().toString())<dataToAdd){
                Node newnode = new Node(player.getName()+"=",player.getScore());
                newnode.setNext(head);
                head=newnode;
            }
            else if(Integer.parseInt(temp.getData2().toString())>=dataToAdd){
                Node previous=null;
                while (temp!= null && Integer.parseInt(temp.getData2().toString())>=dataToAdd) {
                    previous=temp;
                    temp = temp.getNext();
                }
                if(temp==null){
                    Node newnode = new Node(player.getName()+"=",player.getScore());
                    previous.setNext(newnode);
                }
                else{
                    Node newnode = new Node(player.getName()+"=",player.getScore());
                    newnode.setNext(temp);
                    previous.setNext(newnode);

                }
            }
        }
    }
    //The method of writing to the same file from scratch.
    public void writefile(String fileName) throws IOException {
        FileWriter fw=new FileWriter(new File(fileName),false);
        Node temp = head;
        int count=1;
        while (temp != null && count!=11) {
            fw.write(temp.getData().toString()+"\n");
            temp = temp.getNext();
            count++;
        }
        fw.close();
    }
    // //Displays the list on screen.
    public void display() {
        if (head == null)
            System.out.println("Linked list is empty");
        else {
            int count=1;
            Node temp = head;
            while (temp != null && count!=11) {
                if (count != 10) {
                    System.out.print(temp.getData()+"\n");
                }
                else{
                    System.out.print(temp.getData());
                }
                temp = temp.getNext();
                count++;
            }
        }
    }
}