import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.io.IOException  {
        Main main = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to start a new game og load a previous one \n1: new game \n2: load game");
        int choice = input.nextInt();
        while (true) {
            if (choice == 1) {
                main.newGame();
                break;
            } else if (choice == 2) {
                main.loadGame();
                break;
            } else {
                System.out.println("WRONG INPUT, 1 OR 2?!?!?:");
            }

        }


    }
    private void newGame() throws java.io.IOException{
        Scanner input = new Scanner(System.in);
        File file = new File("MusLog.txt");
        PrintWriter output = new PrintWriter(file);
        output.println("**** Mus Spil ****");

        int randomNumber = (int)(Math.random()*5+5);
        System.out.println("Antallet af pebbernødder er = " + randomNumber);

        int[] pebbernuts = new int[randomNumber];

        Arrays.fill(pebbernuts, 1);

        pebbernuts[(int)(Math.random()*pebbernuts.length)] = 0;

        System.out.println("vælg en pebbernød");
        while (true) {
            int countsOfOne = 0;
            int number = input.nextInt();
            output.println("bruger indtaster " + number);
            if (pebbernuts[number] == 0) {
                System.out.println("MUUUUUS");
                pebbernuts[number] = -1;
                while (true) {
                    for (int i = 0; i < pebbernuts.length; i++)
                        if (pebbernuts[i] == 1) {
                            countsOfOne++;
                        }
                    if (countsOfOne == 0) {
                        break;
                    }

                    int n = (int)(Math.random()*pebbernuts.length);
                    if (pebbernuts[n] == 1) {
                        pebbernuts[n] = 0;
                        break;
                    }
                }
                if (countsOfOne == 0) {
                    System.out.println("Game Over");
                    break;
                }
            }

            else if (pebbernuts[number] == 1) {
                pebbernuts[number] = -1;
                System.out.println("Du trak en pebbernød");
            }

            else if (pebbernuts[number] == -1) {
                System.out.println("Allerede spist");
            }
        }

        output.close();
    }
    private void loadGame() throws java.io.IOException {

    }


}
