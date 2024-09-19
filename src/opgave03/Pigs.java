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
        int newpoint;

        dice[0] = (int) (Math.random() * 6 + 1);
        dice[1] = (int) (Math.random() * 6 + 1);

        int newPoint = dice[0] + dice[1];

        while (playGame) {
           // Player 1's turn
           System.out.println("Player 1 rolled a " + dice[0]);

            if (dice[0] == 1) {
                        System.out.println("Player 1 rolled a 1. Next player's turn.");
                        break; }

            player1Score += dice[0];
            System.out.println("Player 1's score: " + player1Score);
            // Check if Player 1 wins
            if (player1Score >= 100) {
               System.out.println("Player 1 wins!");
            }
               System.out.print("Continue? (yes/no): ");
               String turn = scanner.next();

                 if (turn.equals("no")) {
                        playGame = false;
                    } else {
                        // Player 2's turn

                        System.out.println("Player 2 rolled a " + dice[1]);

                      if (dice[1] == 1) {
                          System.out.println("Player 2 rolled a 1. Next player's turn.");
                        } else {
                            player2Score += dice[1];
                            System.out.println("Player 2's score: " + player2Score);

                            // Check if Player 2 wins
                            if (player2Score >= 100) {
                                System.out.println("Player 2 wins!");
                                break;
    }                    }
}                }
    }
}