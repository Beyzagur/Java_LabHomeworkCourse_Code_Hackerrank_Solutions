import java.util.Scanner;

public class Main {
    static LinkedStack ls=new LinkedStack();
    static LinkedQueue lq=new LinkedQueue();
    static LinkedQueue lq1=new LinkedQueue();

    public static void controlParenthesis(String expr){
    	
        for (int i = 0; i <expr.length() ; i++) {
        	
            if((expr.substring(0+i,1+i).equals(")")) &&(!(ls.isEmpty())) &&(ls.peek().equals("("))){
                ls.pop();
            }
            else if((expr.substring(0+i,1+i).equals("(")) || (expr.substring(0+i,1+i).equals(")"))){
                ls.push(expr.substring(0+i,1+i));
            }
        }

        if(ls.isEmpty()){
            System.out.println("Output: True");
        }
        else{
            System.out.println("Output: False");
        }
    }

    public static void median(LinkedQueue lq){
        int size=lq.size();
        int temp1=0;
        
        if(size%2==1) {
        	
            for (int i = 1; i < ((size+1)/2); i++) {
                lq.enqueue(lq.dequeue());

            }
            System.out.println("Odd Size Output : "+(int)lq.peek());
        }
        else{
        	
            for (int i = 0; i <size/2 ; i++) {
                temp1=0;
                temp1=(int)lq.peek();
                lq.enqueue(lq.dequeue());
                temp1=(temp1+(int)lq.peek())/2;
            }
            System.out.println("Even Size Output : "+temp1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ~~ First question ~~");
        System.out.println("Please input a string for parenthesis checking : ");
        String expr = scanner.nextLine();
        controlParenthesis(expr);

        System.out.println("\n ~~ Second question ~~");
        lq.enqueue(10);     lq1.enqueue(10);
        lq.enqueue(20);     lq1.enqueue(20);
        lq.enqueue(30);     lq1.enqueue(30);
        lq.enqueue(40);     lq1.enqueue(40);
        lq.enqueue(50);     lq1.enqueue(50);
        lq.enqueue(60);     lq1.enqueue(60);
        lq.enqueue(70);

        median(lq);
        median(lq1);
    }
}
