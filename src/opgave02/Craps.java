package opgave02;

import com.sun.tools.javac.Main;

import java.awt.*;
import java.util.Scanner;


public class Craps {


    public static void main(String[] args) {


        playTwoDice();
        playCraps();

    }

    private static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = scanner.nextLine();
    }

    public static int[] playCraps() {
        Scanner scanner = new Scanner(System.in);

        int[] dice = new int[2];
        int SumOfDice;

        dice[0] = (int) (Math.random() * 6 + 1);
        dice[1] = (int) (Math.random() * 6 + 1);

        SumOfDice = dice[0] + dice[1];

        if (SumOfDice == 7 || SumOfDice == 11) {
            System.out.println("Du slog " + SumOfDice +  " og vinder!!");
        } else if (SumOfDice == 2 || SumOfDice == 3 || SumOfDice == 12) {
            System.out.println("Øv!" + " Du har desværre slået " + SumOfDice +  " og taber spillet!");
        } else {
            System.out.println("Du slog " + SumOfDice + " og skal derfor kaste igen");

            System.out.print("Kast igen <--");
            String answer = scanner.nextLine();

            rollForPoint(SumOfDice);

        }

        return dice;
    }

    public static boolean rollForPoint(int diceOne) {

        int[] newRolldice = new int[2];
        int newpoint;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            newRolldice[0] = (int) (Math.random() * 6 + 1);
            newRolldice[1] = (int) (Math.random() * 6 + 1);
            int newPoint = newRolldice[0] + newRolldice[1];

            if (newPoint == 7) {
                System.out.println("Øv!" + " Du har desværre slået " + newPoint + " og taber spillet!");
                return false;
            } else if (newPoint == diceOne) {
                System.out.println("Tillykke, du har slået " + diceOne + " og vinder!!");
                return true;
            } else {
                    System.out.println("Du slog " + newPoint + " og skal derfor kaste igen");
                System.out.print("Kast igen <--");
                String answer = scanner.nextLine();
                }
            }
                }

            }