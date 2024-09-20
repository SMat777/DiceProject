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

            while (playGame) {
                // Player 1's turn
                boolean player1Turn = true;
                while (player1Turn) {
                    dice[0] = (int) (Math.random() * 6 + 1);
                    dice[1] = 0; // Reset the second dice for Player 2
                    rolls[0]++; // Increment the roll count for Player 1
                    System.out.println("Player 1 rolled a " + dice[0]);

                    if (dice[0] == 1) {
                        System.out.println("Player 1 rolled a 1. Next player's turn.");
                        player1Turn = false;
                    } else {
                        player1Score += dice[0];
                        System.out.println("Player 1's score: " + player1Score);

                        // Check if Player 1 wins
                        if (player1Score >= 100) {
                            System.out.println("Player 1 wins!");
                            playGame = false;
                            break;
                        } else {
                            System.out.print("Continue? (yes/no): ");
                            String turn = scanner.next();

                            if (turn.equals("no")) {
                                player1Turn = false;
                            }
                        }
                    }
                }

                if (playGame) {
                    // Player 2's turn
                    boolean player2Turn = true;
                    while (player2Turn) {
                        dice[0] = 0; // Reset the first dice for Player 1
                        dice[1] = (int) (Math.random() * 6 + 1);
                        rolls[1]++; // Increment the roll count for Player 2
                        System.out.println("Player 2 rolled a " + dice[1]);

                        if (dice[1] == 1) {
                            System.out.println("Player 2 rolled a 1. Next player's turn.");
                            player2Turn = false;
                        } else {
                            player2Score += dice[1];
                            System.out.println("Player 2's score: " + player2Score);

                            // Check if Player 2 wins
                            if (player2Score >= 100) {
                                System.out.println("Player 2 wins!");
                                playGame = false;
                                break;
                            } else {
                                System.out.print("Continue? (yes/no): ");
                                String turn = scanner.next();

                                if (turn.equals("no")) {
                                    player2Turn = false;
                                }
                            }
                        }
                    }
                }
            }

            // Display the final scores and roll counts
            System.out.println("Final scores:");
            System.out.println("Player 1: " + player1Score + " (rolled " + rolls[0] + " times)");
            System.out.println("Player 2: " + player2Score + " (rolled " + rolls[1] + " times)");
        }
    }