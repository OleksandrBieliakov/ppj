package ppj.ticktacktoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TickTackToe {

    private static char symbol = 'X';

    private static int winCond (int board) {

        int winner = 2;
        int symb = 0b01;
        if(symbol == '0') {
            symb = 0b10;
            winner = 1;
        }

        int clay1 = symb;
        for(int j = 0; j < 2; ++j) {
            clay1 = (clay1 << 8) | symb;
        }
        if((clay1 & board) == clay1) return winner;

        int clay2 = symb << 4;
        for(int j = 0; j < 2; ++j) {
            clay2 = (clay2 << 4) | symb;
        }
        if((clay2 & board) == clay2) return winner;

        int clay3 = symb;
        for(int j = 0; j < 2; ++j) {
            clay3 = (clay3 << 2) | symb;
        }
        for(int i = 0; i < 3; ++i) {
            if((clay3 & board) == clay3) return winner;
            clay3 <<= 6;
        }

        int clay4 = symb;
        for(int j = 0; j < 2; ++j) {
            clay4 = (clay4 << 6) | symb;
        }
        for(int i = 0; i < 3; ++i) {
            if((clay4 & board) == clay4) return winner;
            clay4 <<= 2;
        }

        return 0;

    }

    private static boolean checkPosition (int board, int position) {
        boolean used = false;
        if((board & (0b10 << (position - 1)*2)) != 0) used = true;
        if((board & (0b11 << (position - 1)*2)) != 0) used = true;
        return used;
    }

    private static int makeTurn(int board) {

        System.out.println(symbol + " turn:");

        Scanner scan = new Scanner(System.in);

        int position;

        try {
            position = scan.nextInt();
            if(position < 1 || position > 9) throw new InputMismatchException();
        } catch (InputMismatchException ex) {
            System.out.println("Please enter a number from 1 to 9.\n");
            return makeTurn(board);
        }

        if(checkPosition(board, position)) {
            System.out.println("This field is already occupied. Please enter another one.\n");
            return makeTurn(board);
        }

        int numSymbol;

        if (symbol == 'X') {
            numSymbol = 0b10;
            symbol = '0';
        } else {
            numSymbol = 0b01;
            symbol = 'X';
        }

        numSymbol <<= (position - 1)*2;

        return board | numSymbol;

    }

    private static void printSolid() {

        for(int i = 0; i < 6; ++i) {
            System.out.print("* ");
        }
        System.out.println("*");

    }

    private static int shiftPrint(int board) {

        if((board & 0b10) == 0b10)
            System.out.print("X");
        else if((board & 0b01) == 0b01)
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

    public static void main(String[] args) {

        System.out.println("Press Ctrl + C to escape." +
                            "\nEnter a number of a field." +
                            "\nFields numbers:\n1 2 3\n4 5 6\n7 8 9\n");
        int board = 0;

        displayBoard(board);
        for(int i = 0; i < 9; ++i) {
            board = makeTurn(board);
            displayBoard(board);
            if(i > 3) {
                if(winCond(board) == 1) {
                    System.out.print("Player X won!");
                    System.exit(0);
                } else if(winCond(board) == 2) {
                    System.out.print("Player 0 won!");
                    System.exit(0);
                }
            }
        }
        System.out.print("Draw!");

    }

}
