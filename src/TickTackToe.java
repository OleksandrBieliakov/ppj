import java.util.Scanner;

public class TickTackToe {

    private static char symbol = 'X';

    private static int makeTurn(int board) {

        System.out.println(symbol + " turn:");

        Scanner scan = new Scanner(System.in);
        int position = scan.nextInt();
        int numSymbol;

        if (symbol == 'X') {
            numSymbol = 0b11;
            symbol = '0';
        } else {
            numSymbol = 0b01;
            symbol = 'X';
        }

        numSymbol <<= (position - 1)*2;

        return board | numSymbol;

    }

    private static void displayBoard(int board) {

        for(int i = 9; i > 0; --i) {
            if((board & 0b11) == 0b11)
                System.out.print("X ");
            else if((board & 0b11) == 0b01)
                System.out.print("0 ");
            else
                System.out.print("_ ");
            if(i == 7 || i == 4)
                System.out.println();
            board >>= 2;
        }
        System.out.println();

    }

    public static void main(String[] args) {

        System.out.println("Enter a number of a field" +
                            "\nPress Ctrl + C to escape." +
                            "\nFields numbers:\n1 2 3\n4 5 6\n7 8 9");
        int board = 0;
        displayBoard(board);
        for(int i = 9; i >= 1; --i) {
            board = makeTurn(board);
            displayBoard(board);
        }

    }

}
