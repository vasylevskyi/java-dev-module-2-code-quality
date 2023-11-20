/**
 * Package contains the game tic-tac-toe
 */

package ua.goit;

import java.util.Scanner;
import static ua.goit.CheckWinner.*;

public class App {
    /**
     * Main class
     * @param args - method signature
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte input;
        byte rand;
        byte i;
        boolean isCellAvailable = false;
        byte winner = 0;
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {

            drawPlayField(box);

            if (!boxEmpty) {
                emptyBox(box);
                boxEmpty = true;
            }

            if ((winner == WINNER_IS_HUMAN)
                    || (winner == WINNER_IS_COMPUTER)
                    || (winner == WINNER_IS_DRAW)) {
                printWinnerGreeting(winner);
                break;
            }

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == CROSS || box[input - 1] == ZERO)
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = CROSS;
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Enter again.");
                }
            }

            isCellAvailable = false;
            for (i = 0; i < 9; i++) {
                if (box[i] != CROSS && box[i] != ZERO) {
                    isCellAvailable = true;
                    break;
                }
            }

            if (!isCellAvailable) {
                winner = WINNER_IS_DRAW;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != CROSS && box[rand - 1] != ZERO) {
                    box[rand - 1] = ZERO;
                    break;
                }
            }

            if (winner != WINNER_IS_DRAW) {
                winner = CheckWinner.checkWinner(box);
            }

        }
    }

    private static void drawPlayField(char[] box) {
        StringBuilder drawPlayField = new StringBuilder();
        drawPlayField.append("\n\n ")
                .append(box[0])
                .append(" | ")
                .append(box[1])
                .append(" | ")
                .append(box[2])
                .append(" ");
        drawPlayField.append("\n")
                .append("-----------")
                .append("\n");
        drawPlayField.append(" ").append(box[3])
                .append(" | ")
                .append(box[4])
                .append(" | ")
                .append(box[5])
                .append(" ");
        drawPlayField.append("\n")
                .append("-----------")
                .append("\n");
        drawPlayField.append(" ")
                .append(box[6])
                .append(" | ")
                .append(box[7])
                .append(" | ")
                .append(box[8])
                .append(" \n");
        System.out.println(drawPlayField);

    }

    public static void printWinnerGreeting(byte winner) {
        if (winner == CheckWinner.WINNER_IS_HUMAN) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == CheckWinner.WINNER_IS_COMPUTER) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == CheckWinner.WINNER_IS_DRAW) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
    public static void emptyBox(char[] box) {
        for (int i = 0; i < 9; i++)
            box[i] = ' ';
    }

}
