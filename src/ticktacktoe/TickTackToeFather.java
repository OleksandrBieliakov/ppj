package ticktacktoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TickTackToeFather {
    private static final int TURN_X = 0b10, TURN_0 = 0b01;

    private static final int[] WIN_X = {
            0b10_10_10, 0b10_10_10_00_00_00, 0b10_10_10_00_00_00_00_00_00,
            0b00_00_10_00_00_10_00_00_10, 0b00_10_00_00_10_00_00_10_00, 0b10_00_00_10_00_00_10_00_00,
            0b10_00_00_00_10_00_00_00_10, 0b00_00_10_00_10_00_10_00_00
    };
    private static final int[] WIN_0 = {
            0b01_01_01, 0b01_01_01_00_00_00, 0b01_01_01_00_00_00_00_00_00,
            0b00_00_01_00_00_01_00_00_01, 0b00_01_00_00_01_00_00_01_00, 0b01_00_00_01_00_00_01_00_00,
            0b01_00_00_00_01_00_00_00_01, 0b00_00_01_00_01_00_01_00_00
    };

    private static int readPosition(int board, Scanner scan) {
        do {
            int position;
            try {
                position = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a number.");
                scan.next(); // discard non-int input
                continue; //try to get a number again
            }
            if (position < 1 || position > 9)
                System.out.println("Please enter a number from 1 to 9.");
            else if (((board >> (position - 1) * 2) & 0b11) != 0)
                System.out.println("Position " + position + " was taken earlier. Please enter another number from 1 to 9.");
            else
                return position;
        } while (true);
    }

    private static int makeTurn(int board, int position, boolean xTurn) {
        int numSymbol = xTurn ? TURN_X : TURN_0;
        numSymbol <<= (position - 1) * 2;
        return board | numSymbol;
    }

    private static void printSolid() {
        for(int i = 0; i < 6; ++i) {
            System.out.print("* ");
        }
        System.out.println("*");
    }

    private static int shiftPrint(int board) {
        if((board & TURN_X) == TURN_X)
            System.out.print("X");
        else if((board & TURN_0) == TURN_0)
            System.out.print("0");
        else
            System.out.print(" ");
        return board >>= 2;
    }

    private static int printLine(int board) {
        System.out.print("*");
        System.out.print(" ");
        board = shiftPrint(board);
        System.out.print(" ");
        System.out.print("*");
        System.out.print(" ");
        board = shiftPrint(board);
        System.out.print(" ");
        System.out.print("*");
        System.out.print(" ");
        board = shiftPrint(board);
        System.out.print(" ");
        System.out.print("*");

        System.out.println();
        return board;
    }

    private static void displayBoard(int board) {
        printSolid();
        board = printLine(board);

        printSolid();
        board = printLine(board);

        printSolid();
        printLine(board);
        printSolid();

        System.out.println();
    }

    private static boolean win(int board, boolean xTurn) {
        for (int win : xTurn ? WIN_X : WIN_0) {
            if ((board & win) == win)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter a number of a field" +
                "\nPress Ctrl + C to escape." +
                "\nFields numbers:\n1 2 3\n4 5 6\n7 8 9");
        //use a single object of Scanner for all inputs. do not create new each time.
        Scanner scan = new Scanner(System.in);
        int board = 0;
        displayBoard(board);
        for (int i = 0; i < 9; ++i) {
            boolean xTurn = i % 2 == 0;
            char turnSign = xTurn ? 'X' : '0';
            System.out.println(turnSign + " turn:");
            int position = readPosition(board, scan);
            board = makeTurn(board, position, xTurn);
            displayBoard(board);
            if (win(board, xTurn)) {
                System.out.println(turnSign + " won");
                return;
            }
        }
        System.out.print("Draw!");
    }

}
