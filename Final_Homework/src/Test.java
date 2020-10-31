import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.*;

public class Test {
    static Scanner scn = new Scanner(System.in);
    static SingleLinkedList sll = new SingleLinkedList();
    static MultiLinkedList mll = new MultiLinkedList();
    static User player;

    //The files are read line by line. The words read are added to sll or mll. The player's name and score are kept in the player object of the User class.
    public void File(String fileName, String symbol) {
        String retDat = "";
        int i = 0;
        File file = new File(fileName);
        try {
            scn = new Scanner(file);

            while (scn.hasNextLine()) {
                retDat = scn.next();
                if (fileName.equals("C:\\HighScoreTable.txt")) {
                    String[] line = retDat.split(symbol);
                    player = new User(line[0], Integer.parseInt(line[1]));
                    sll.insert(player, Integer.parseInt(line[1]));
                } else if (fileName.equals("C:\\input.txt")) {
                    retDat = retDat.replace("i", "ý");
                    multiLinkedListFiller(retDat, mll);
                }
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    //The word read in the file is added to the mll.
    public void multiLinkedListFiller(String info, MultiLinkedList mll) {
        RowNode temp1 = mll.getHead();
        if (temp1 == null) {
            mll.addRow(Integer.toString(info.length()));
            temp1 = mll.getHead();
            mll.addElement(temp1.getRowNo(), info);
        } else if (!(Integer.toString(info.length()).equals(temp1.getRowNo()))) {
            mll.addRow(Integer.toString(info.length()));
            temp1 = mll.getHead();
            if (temp1.getRowNo().equals(Integer.toString(info.length()))) {
                mll.addElement(temp1.getRowNo(), info);
            } else {
                while (!(temp1.getRowNo().equals(Integer.toString(info.length())))) {
                    temp1 = temp1.getDown();
                }
                mll.addElement(temp1.getRowNo(), info);
            }
        } else if ((Integer.toString(info.length()).equals(temp1.getRowNo()))) {
            mll.addElement(temp1.getRowNo(), info);
        }
    }

    //Points are calculated.
    public int scoreCalculate(String letter, DoubleLinkedList dll, CircularLinkedList csll2) {
        int score = 0;
        if (dll.dllsearch(letter.toUpperCase()) == true && csll2.search(letter.toUpperCase()) == true) {
            if (letter.equals("A") || letter.equals("E") || letter.equals("I") || letter.equals("U") || letter.equals("O")) {
                score += 5;
            } else {
                score += 10;
            }
        }
        return score;
    }

    public Test() throws IOException {
        Random rnd = new Random();
        Scanner scnn = new Scanner(System.in);

        //Necessary objects have been created.
        DoubleLinkedList dll = new DoubleLinkedList();
        DoubleLinkedList copydll= new DoubleLinkedList(); //The user's input was created to be able to gain control of whether something is alphabetical.
        CircularLinkedList csll1 = new CircularLinkedList();
        CircularLinkedList csll2 = new CircularLinkedList();

        int scorePoint = 0;
        int lives = 6;

        System.out.print("Please enter your name: ");
        String name = scnn.next();

        //The files to be read have been sent to be read in the File method.
        File("C:\\input.txt", "\n");
        File("C:\\HighScoreTable.txt", ";");

        System.out.print("Randomly generated number: ");
        int rndnum = rnd.nextInt(mll.size());
        System.out.println(rndnum);

        //The letters in the alphabet were added to the dll and copydll as char.
        for (int i = 65; i < 91; i++) {
            dll.add((char) i);
            copydll.add((char)i);
        }

        //The word inside the MLL, determined by random number, was added to csll1.
        csll1.add(mll.elementX(rndnum));
        //As much as the size of the word "-" is added to CLL2.
        csll2.add("-".repeat(mll.elementX(rndnum).toString().length()));
        csll1.display(); //Mll'den seçilen kelime csll1'in içerisinde
        System.out.println();

        boolean isGame = false;
        //The main game cycle. The game continues until the number of guesses is 0 or the word is complete.
        while (lives != 0 & isGame != true) {
            System.out.print("Word: ");
            csll2.display();
            System.out.print(" ".repeat(10) + "Lives: " + lives + " ".repeat(5) + "Score: " + scorePoint + " ".repeat(10));
            dll.display();
            System.out.print("Guess: ");
            String letter = scnn.next();
            if (letter.equals("i")) {
                letter = letter.replace("i", "ý");
            }
            else if(letter.equals("Ý")){
                letter = letter.replace("Ý", "ý");
            }
            //If the size of the user's input is 1 and it exists in the copydll, the game will be continued. Otherwise, a warning message is given and the user is asked to re-enter.
            if (letter.toUpperCase().length() == 1 & copydll.dllsearch(letter.toUpperCase())==true) {
                //If the user entered the same entry, the warning message is displayed on the screen.
                if (dll.dllsearch(letter.toUpperCase()) == false) {
                    System.out.println("You entered the same letter before.");
                }
                csll2.addletter(letter.toUpperCase(), csll1);
                scorePoint += scoreCalculate(letter.toUpperCase(), dll, csll2);
                //If the word does not have this letter in it, and the DLL has this letter in it, the number of guesses is reduced.
                if (csll2.search(letter.toUpperCase()) == false) {
                    if (dll.dllsearch(letter.toUpperCase()) != false) {
                        lives--;
                    }
                }
                //The letter is deleted from dll.
                dll.remove(letter.toUpperCase());
                if (csll2.search("-") == false) {
                    isGame = true;
                }
            } else {
                System.out.println("Wrong format !!! Please enter only letter.");
            }

        }
        if(lives!=0){
            System.out.print("Word: ");
            csll2.display();
            System.out.print(" ".repeat(10) + "Lives: " + lives + " ".repeat(5) + "Score: " + scorePoint + " ".repeat(10));
            dll.display();
            System.out.println("\nYou win !!");
        }
        else if (lives == 0) {
            System.out.println("\nYou lost !!");
        }
        System.out.println("\n*** High Score Table *** ");
        player = new User(name, scorePoint);
        sll.insert(player, scorePoint);
        sll.display();
        sll.writefile("C:\\HighScoreTable.txt");
    }
}