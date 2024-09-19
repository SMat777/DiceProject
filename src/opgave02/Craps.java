package opgave02;

import java.util.Scanner;

public class Craps {

    public static int sumOfDice = 0;
    public static int point = 0;

    public static void main(String[] args) {
        playCraps();
        rollForPoint(point);

    }

    public static int[] playCraps() {

        Scanner input = new Scanner(System.in);
        System.out.println("Velkommen til spillet Craps! Kast dine terninger");

        int[] dice = new int[2];

        dice[0] = (int) (Math.random() * 6) + 1;
        dice[1] = (int) (Math.random() * 6) + 1;
        int sumOfDice = dice[0] + dice[1];

        if (sumOfDice == 7 || sumOfDice == 11) {
            System.out.println(sumOfDice + " Winner!");
        } else if (sumOfDice == 2 || sumOfDice == 3 || sumOfDice == 12) {
            System.out.println(sumOfDice + " Loser!");
        } else {
            System.out.println("Terninger viser " + sumOfDice);

            rollForPoint(sumOfDice);

            }
        return dice;
        }


    public static boolean rollForPoint(int point) {
        int[] newRollDice = new int[2];
        int newRoll;
        do {
            newRollDice[0] = (int) (Math.random() * 6) + 1;
            newRollDice[1] = (int) (Math.random() * 6) + 1;
            newRoll = newRollDice[0] + newRollDice[1];
            System.out.println("Du slog " + newRoll);

            if (newRoll == 7) {
                System.out.println("You lose!");
                return false;
            } else if (newRoll == point) {
                System.out.println("Winner");
                return true;
            }
        } while (true);
    }
}

