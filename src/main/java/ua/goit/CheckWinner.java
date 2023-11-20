package ua.goit;

public class CheckWinner {
    static final byte WINNER_IS_HUMAN = 1;
    static final byte WINNER_IS_COMPUTER = 2;
    static final byte WINNER_IS_DRAW = 3;
    static final byte WINNER_IS_UNDEFINED = 0;
    static final char CROSS = 'X';
    static final char ZERO = '0';

    static byte checkWinner(char[] box) {
        if ((box[0] == CROSS && box[1] == CROSS && box[2] == CROSS)
                || (box[3] == CROSS && box[4] == CROSS && box[5] == CROSS)
                || (box[6] == CROSS && box[7] == CROSS && box[8] == CROSS)
                || (box[0] == CROSS && box[3] == CROSS && box[6] == CROSS)
                || (box[1] == CROSS && box[4] == CROSS && box[7] == CROSS)
                || (box[2] == CROSS && box[5] == CROSS && box[8] == CROSS)
                || (box[0] == CROSS && box[4] == CROSS && box[8] == CROSS)
                || (box[2] == CROSS && box[4] == CROSS && box[6] == CROSS)) {
            return WINNER_IS_HUMAN;
        }
        if ((box[0] == ZERO && box[1] == ZERO && box[2] == ZERO)
                || (box[3] == ZERO && box[4] == ZERO && box[5] == ZERO)
                || (box[6] == ZERO && box[7] == ZERO && box[8] == ZERO)
                || (box[0] == ZERO && box[3] == ZERO && box[6] == ZERO)
                || (box[1] == ZERO && box[4] == ZERO && box[7] == ZERO)
                || (box[2] == ZERO && box[5] == ZERO && box[8] == ZERO)
                || (box[0] == ZERO && box[4] == ZERO && box[8] == ZERO)
                || (box[2] == ZERO && box[4] == ZERO && box[6] == ZERO)) {
            return WINNER_IS_COMPUTER;
        }
        return WINNER_IS_UNDEFINED;
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
    static boolean isWinnerExist(byte winner) {
        return (winner == WINNER_IS_HUMAN)
                || (winner == WINNER_IS_COMPUTER)
                || (winner == WINNER_IS_DRAW);
    }
}
