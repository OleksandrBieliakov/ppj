import java.util.Scanner;

public class TickTackToe {

    public static int makeTurn(int board) {

        Scanner scan = new Scanner(System.in);
        int position = scan.nextInt();
        String symbol = scan.next();
        int numSymbol = 0;

        if(symbol.equals("X"))
            numSymbol = 0b11;
        else
            numSymbol = 0b01;

        numSymbol <<= (position - 1)*2;

        return board | numSymbol;

    }

    public static void displayBoard(int board) {

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

        System.out.println("Enter a number of a field first, then \"X\" or \"0\"(zero)." +
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
