import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
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


}
