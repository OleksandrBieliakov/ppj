package ppj.matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

// Gaussian elimination algorithm
public class MainTest {

    // Reads a matrix from text file
    private static double[][] readFile() throws IOException {
        File file = new File("data/ppj/matrix");
        BufferedReader br = new BufferedReader(new FileReader(file));

        int rows = 0;
        int columns = 0;

        while (br.readLine() != null) {
            ++rows;
        }

        if (rows == 0) throw new IOException();

        String stArr[] = new String[rows];
        br = new BufferedReader(new FileReader(file));
        int row = 0;
        String st;
        while ((st = br.readLine()) != null) {
            stArr[row++] = st;
        }

        columns = stArr[0].split(" ").length;
        if (columns < 2) {
            System.out.println("Can`t build an equation matrix with data provided in the file.");
            throw new IOException();
        }
        double[][] arr = new double[rows][columns];

        String[] stBrr;

        for (int q = 0; q < rows; ++q) {
            stBrr = stArr[q].split("\\s+");
            for (int e = 0; e < columns; ++e) {
                arr[q][e] = Double.parseDouble(stBrr[e]);
            }
        }
        System.out.println("\nInitial equation matrix:");
        print(arr);
        return arr;
    }

    // Takes a matrix as an input from console
    private static double[][] input() throws IOException {
        System.out.print("Please enter the number of rows and columns of your matrix.\n" +
                "    rows: ");
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        if (rows == 0) throw new IOException();
        System.out.print("    columns: ");
        int columns = scan.nextInt();
        if (columns < 2) throw new IOException();
        double[][] arr = new double[rows][columns];
        System.out.println("Enter your matrix row by row:");
        for (int p = 0; p < rows; ++p) {
            for (int u = 0; u < columns; ++u) {
                arr[p][u] = scan.nextDouble();
            }
        }
        return arr;
    }

    // Prints a two-dimentional array with formatting
    private static void print(double[][] a) {
        int rows = a.length;
        int columns = a[0].length;
        DecimalFormat df = new DecimalFormat("#.#");
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns - 1; ++j) {
                System.out.printf("%6s", df.format(a[i][j]));
            }
            System.out.printf(" |%6s%n", df.format(a[i][columns - 1]));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("*****GAUSSIAN ELIMINATION ALGORITHM*****\n" +
                "      (implemented by O.Bieliakov)");

        double[][] a = {};

        try {
            a = readFile();
        } catch (IOException e) {
            System.out.println("Create a text file named \"matrix.txt\" in a same folder with the program file, " +
                    "enter a rectangular matrix in it and save it\ne.g. 1 -2 3.5 6\n     -4.1 0 0 1\n     20 3 4 99\n" +
                    "and press ENTER or just press ENTER and continue with console input.");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            try {
                a = readFile();
            } catch (IOException e1) {
                try {
                    a = input();
                } catch (IOException e2) {
                    System.out.print("Can`t build an equation matrix with entered values.");
                    System.exit(0);
                }
            }
        }

        int rows = a.length;
        int columns = a[0].length;

        int row = 0;
        double coef;

        // Forward elimination
        for (int i = 0; i < columns - 1; ++i) {
            // Row swapping
            if (a[row][i] == 0) {
                // Search a non-zero element
                int tmp = row;
                for (int j = row + 1; j < rows; ++j) {
                    if (a[j][i] != 0) {
                        tmp = j;
                        break;
                    }
                }
                // Swapping
                if (tmp != row) {
                    double tmp2;
                    for (int k = i; k < columns; ++k) {
                        tmp2 = a[row][k];
                        a[row][k] = a[tmp][k];
                        a[tmp][k] = tmp2;
                    }
                    System.out.println("Row swapping: r-" + (row + 1) + " and r-" + (tmp + 1));
                    print(a);
                } else continue;
            }
            // Elimination
            for (int n = row + 1; n < rows; ++n) {
                if (a[n][i] != 0) {
                    coef = a[n][i] / a[row][i];
                    for (int m = i; m < columns; ++m) {
                        a[n][m] -= coef * a[row][m];
                    }
                    System.out.println("Forward: r-" + (n + 1) + " c-" + (i + 1));
                    print(a);
                }
            }
            ++row;
        }

        --row;

        // Backward elimination
        for (int h = row; h >= 0; --h) {
            // Search a firs non-zero element in a row
            for (int l = 0; l < columns; ++l) {
                if (a[h][l] != 0) {
                    // Elimination
                    for (int f = h - 1; f >= 0; --f) {
                        if(a[f][l] != 0) {
                            coef = a[f][l] / a[h][l];
                            for (int x = l; x < columns; ++x) {
                                a[f][x] -= coef * a[h][x];
                            }
                            System.out.println("Backward: r-" + (f + 1) + " c-" + (l + 1));
                            print(a);
                        }
                    }
                    break;
                }
            }
        }

        // Scaling the rows to obtain pivots equal 1
        while (row >= 0) {
            // Search a firs non-zero element in a row
            for (int y = 0; y < columns; ++y) {
                if (a[row][y] != 0) {
                    // Scaling
                    if (a[row][y] != 1) {
                        coef = 1 / a[row][y];
                        for (int z = y; z < columns; ++z) {
                            a[row][z] *= coef;
                        }
                        System.out.println("Scaling: r-" + (row + 1));
                        print(a);
                    }
                    break;
                }
            }
            --row;
        }

        System.out.println("^ Reduced Row Echelon form!\n");

    }
}