package opgave02;

import com.sun.tools.javac.Main;

import java.awt.*;
import java.util.Scanner;

// 01) Lav en klasse kaldt Craps
public class Craps {

    public static int SumOfDice = 0;
    public static int point = 0;


    //Main method
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
        // to terninger tilgives et tilfældigt værdig mellem 1 0g 6 og gemmes i et array, derefter lægges sammen
        int[] diceArray = new int[2];

        diceArray[0] = (int) (Math.random() * 6 + 1);
        diceArray[1] = (int) (Math.random() * 6 + 1);

        SumOfDice = diceArray[0] + diceArray[1];

        if (SumOfDice == 7 || SumOfDice == 11) {
            System.out.println("Du slog " + SumOfDice +  " og vandt!");
        } else if (SumOfDice == 2 || SumOfDice == 3 || SumOfDice == 12) {
            System.out.println("Øv!" + " Du har desværre slået " + SumOfDice +  " og taber spillet!");
        } else {
            System.out.println("Du slog " + SumOfDice + " og skal derfor kaste igen");

            System.out.print("Kast igen <--");
            String answer = scanner.nextLine();

            rollForPoint(SumOfDice);

        }

        return diceArray;
    }

    public static boolean rollForPoint(int point) {

        int[] newRollArray = new int[2];

        Scanner scanner = new Scanner(System.in);

        while(true) {
            newRollArray[0] = (int) (Math.random() * 6 + 1);
            newRollArray[1] = (int) (Math.random() * 6 + 1);
            int newPoint = newRollArray[0] + newRollArray[1];

            if (newPoint == 7) {
                System.out.println("Øv!" + " Du har desværre slået " + newPoint + " og taber spillet!");
                return false;
            } else if (newPoint == point) {
                System.out.println("Tillykke, du har slået " + point + " og vinder!!");
                return true;
            } else {
                    System.out.println("Du slog " + newPoint + " og skal derfor kaste igen");
                System.out.print("Kast igen <--");
                String answer = scanner.nextLine();
                }
            }
                }

            }