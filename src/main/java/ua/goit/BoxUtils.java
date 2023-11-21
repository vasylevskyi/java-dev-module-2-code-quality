package ua.goit;

import java.util.Scanner;
import static ua.goit.CheckWinner.*;

public class BoxUtils {
    public static void drawPlayField(char[] box) {
        String drawPlayField = "\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " " + "\n" +
                "-----------" + "\n" +
                " " + box[3] + " | " + box[4] + " | " + box[5] + " " + "\n" +
                "-----------" + "\n" +
                " " + box[6] + " | " + box[7] + " | " + box[8] + " \n";
        System.out.println(drawPlayField);

    }
    public static void emptyBox(char[] box) {
        for (int i = 0; i < 9; i++)
            box[i] = ' ';
    }

    public static void inputCellNumber (char[] box){
        Scanner scan = new Scanner(System.in);
        byte input;

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
    }
    public static char[] computerMove (char[] box) {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != CROSS && box[rand - 1] != ZERO) {
                box[rand - 1] = ZERO;
                break;
            }
        }
        return box;
    }
    public static boolean ifCellAvailableForComputerMove (char[] box) {
        for (char boxElement: box) {
            if (boxElement != CROSS && boxElement != ZERO) {
                return true;
            }
        }
        return false;
    }
}
