package opgave01;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class RollTwoDice {

    private static int rollCount = 0;
    private static int sumOfDice = 0;
    private static int sumOfequalDice = 0;
    private static int topSumOfDice = 0;
    private static int[] totalSumOfDice = new int[6];

    public static void main(String[] args) {

        System.out.println("Velkommen til terningespillet med 2 terninger");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Tak for at spille, spillet!");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Der gælder simple regler for dette terningespil");
        System.out.println("Spilleren ruller 2 terninger så længe man lyster.");
        System.out.println("=====================================================");
    }

    private static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] dice = rollDice();
            System.out.println("Du rullede: " + dice[0] + " og " + dice[1]);
            System.out.println();


            updateStatistics(dice);

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] dice = new int[2];

        dice[0] = (int) (Math.random() * 6 + 1);
        dice[1] = (int) (Math.random() * 6 + 1);

        return dice;
    }

    private static void updateStatistics(int[] dice) {
        rollCount++;
        sumOfDice += dice[0] + dice[1];

        if (dice[0] == dice[1]) {
            sumOfequalDice++;
        }
        if (dice[0] + dice[1] > topSumOfDice) {
            topSumOfDice = dice[0] + dice[1];
        }
        totalSumOfDice[dice[0] - 1]++;
        totalSumOfDice[dice[1] - 1]++;


    }

    private static void printStatistics() {
        System.out.println("       \nResultatet af kastene er:");
        System.out.println("------------------------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.println("");
        System.out.println("Den samlede sum af terningekastene er: " + sumOfDice);
        System.out.println("");
        System.out.println("Antallet af 2 ens terninger er: " + sumOfequalDice);
        System.out.println("");
        System.out.println("Den højeste sum 2 terninger opnåede var: " + topSumOfDice);
        System.out.println("");
        System.out.println("Så mange gange har du slået 1: " + totalSumOfDice[0]);
        System.out.println("Så mange gange har du slået 2: " + totalSumOfDice[1]);
        System.out.println("Så mange gange har du slået 3: " + totalSumOfDice[2]);
        System.out.println("Så mange gange har du slået 4: " + totalSumOfDice[3]);
        System.out.println("Så mange gange har du slået 5: " + totalSumOfDice[4]);
        System.out.println("Så mange gange har du slået 6: " + totalSumOfDice[5]);


            //for (int index = 0; index < 6; index++) {
            //if (index == 1);
            //System.out.println("Du slog" + index + 1 + " :" + totalSumOfDice + " gange");
        }
    }