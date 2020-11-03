package JavaOutputFormatting;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String string=scan.next();
                int integer=scan.nextInt();
                System.out.printf("%-15s%03d\n",string, integer);
                //Complete this line
            }
            System.out.println("================================");

    }
}
