package opgave03;

import java.util.Random;
import java.util.Scanner;

public class Pigs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int player1Score = 0;
        int player2Score = 0;
        boolean playGame = true;
        int[] dice = new int[2];
        int[] rolls = new int[2]; // Array to count the numbers rolled each time
        int roundScore = 0;

        while (playGame) {
            // Player 1's turn
            boolean player1Turn = true;
            
            do {
                dice[0] = (int) (Math.random() * 6 + 1);
                rolls[0]++; // Increment the roll count for Player 1
                roundScore += dice[0]; // Update player1Score
                System.out.println("You rolled a: " + dice[0]);
                System.out.println("Your total: " + roundScore);

                if (dice[0] == 1)
                    System.out.println("You lose your points this turn, next player please!");
                      roundScore = 0;
                      player1Turn = false;
                    

                if (player1Score >= 100) {
                    System.out.println("Player 1 wins!");
                    playGame = false;
                    break;
                }

                System.out.print("Continue? (yes/no): ");
                String turn = scanner.next();

                if (turn.equals("no")) {
                    player1Turn = false;
                }
            } while (player1Turn);

            roundScore = 0;

            if (playGame) {
                // Player 2's turn
                boolean player2Turn = true;

                do {
                    dice[1] = (int) (Math.random() * 6 + 1);
                    rolls[1]++; // Increment the roll count for Player 2

                    roundScore += dice[1]; // Update roundscore
                    System.out.println("");
                    System.out.println("You rolled a: " + dice[1]);
                    System.out.println("Your total: " + roundScore);

                    if (dice[1] == 1) {
                        System.out.println("You lose your points this turn, next player please!");
                    roundScore = 0;
                    player2Turn = false;
                }
                    player2Score += roundScore;

                    if (player2Score >= 100) {
                        System.out.println("Player 2 wins!");
                        playGame = false;
                        break;
                    }

                    System.out.print("Continue? (yes/no): ");
                    String turn = scanner.next();

                    if (turn.equals("no")) {
                        player2Turn = false;
                    }
                } while (player2Turn);
            }
        }
        System.out.println("Final scores:");
        System.out.println("Player 1: " + player1Score + " (rolled " + rolls[0] + " times)");
        System.out.println("Player 2: " + player2Score + " (rolled " + rolls[1] + " times)");
    }
}
















