package opgave03;

import java.util.Scanner;

public class Pigs {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Initialize player scores and game state
        int player1Score = 0;
        int player2Score = 0;
        boolean playGame = true;
        int[] dice = new int[2];

        // Main game loop
        while (playGame) {
            // Player 1's turn
            player1Score = player1Turn(input, dice, player1Score);
            if (player1Score >= 30) {
                System.out.println("");
                System.out.println("Player 1 wins! --> " + player1Score + " Points");
                playGame = false;
                break;
            }

            // Player 2's turn
            player2Score = player2Turn(input, dice, player2Score);
            if (player2Score >= 30) {
                System.out.println("");
                System.out.println("Player 2 wins! --> " + player2Score + " Points");
                playGame = false;
                break;
            }
        }

        // Print final scores
        System.out.println("Final scores below");
        System.out.println("------------------");
        System.out.println("Player 1: " + player1Score);
        System.out.println("Player 2: " + player2Score);
    }

    private static int player1Turn(Scanner input, int[] dice, int player1Score) {
        int roundScoreP1 = 0;
        boolean player1Turn = true;

        // Player 1's turn loop
        while (player1Turn) {
            // Roll the dice
            dice[0] = (int) (Math.random() * 6 + 1);
            // Check if player loses points
            if (dice[0] == 1) {
                System.out.println("Player 1, you rolled : " + dice[0]);
                System.out.println("You lose your points this turn, next player please!");
                roundScoreP1 = 0;
                player1Turn = false;
            } else {
                System.out.println("Player 1, you rolled : " + dice[0]);
                roundScoreP1 += dice[0];
                System.out.println("");
                System.out.println("Your total this round is: " + roundScoreP1);
            }
            // Ask player if they want to continue
            System.out.print("Continue? (yes/no): ");
            String turn = input.next();

            if (turn.equals("no")) {
                player1Score += roundScoreP1;
                roundScoreP1 = 0;
                player1Turn = false;
            }
        } return player1Score;
    }

    private static int player2Turn(Scanner input, int[] dice, int player2Score) {
        int roundScoreP2 = 0;
        boolean player2Turn = true;

        // Player 2's turn loop
        while (player2Turn) {
            // Roll the dice
            dice[1] = (int) (Math.random() * 6 + 1);
            // Check if player loses points
            if (dice[1] == 1) {
                System.out.println("Player 2, you rolled : " + dice[1]);
                System.out.println("You lose your points this turn, next player please!");
                roundScoreP2 = 0;
                player2Turn = false;
            } else {
                roundScoreP2 += dice[1];
                System.out.println("Player 2, you rolled : " + dice[1]);
                System.out.println("");
                System.out.println("Your total this round is: " + roundScoreP2);
            }
            // Ask player if they want to continue
            System.out.print("Continue? (yes/no): ");
            String turn = input.next();

            if (turn.equals("no")) {
                player2Score += roundScoreP2;
                roundScoreP2 = 0;
                player2Turn = false;

            }
        } return player2Score;
    }
}















