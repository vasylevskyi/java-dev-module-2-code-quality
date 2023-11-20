package ua.goit;

import static ua.goit.CheckWinner.*;
import static ua.goit.BoxUtils.*;

public class PlayGame {
    static byte i;
    static boolean isCellAvailable = false;
    static byte winner = 0;
    static char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void runGame () {
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;

        while (true) {
            drawPlayField(box);

            if (!boxEmpty) {
                emptyBox(box);
                boxEmpty = true;
            }

            if (isWinnerExist(winner)) {
                printWinnerGreeting(winner);
                break;
            }

            inputCellNumber(box);

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

            computerMove(box);

            if (winner != WINNER_IS_DRAW) {
                winner = CheckWinner.checkWinner(box);
            }
        }
    }

}
