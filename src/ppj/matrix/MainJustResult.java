package ppj.matrix;

// Gaussian elimination algorithm

import java.util.Scanner;

public class MainJustResult {

    // Takes a matrix as an input from console
    private static double[][] input() {
        Scanner scan = new Scanner(System.in);
        System.out.print("****GAUSSIAN ELIMINATION ALGORITHM****\n" +
                "Please enter the number of rows and columns of your matrix.\n" +
                "    rows: ");
        int rows = scan.nextInt();
        System.out.print("    columns: ");
        int columns = scan.nextInt();
        double[][] arr = new double[rows][columns];
        System.out.println("Enter your matrix row by row:");
        for (int p = 0; p < rows; ++p) {
            for (int u = 0; u < columns; ++u) {
                arr[p][u] = scan.nextDouble();
            }
        }
        return arr;
    }

    // Prints a two-dimentional array
    private static void print(double[][] a) {
        int rows = a.length;
        int columns = a[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns - 1; ++j) {
                System.out.printf("%3.0f", a[i][j]);
            }
            System.out.printf(" |%3.0f%n", a[i][columns - 1]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        double[][] a = input();
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
                } else continue;
            }
            // Elimination
            for (int n = row + 1; n < rows; ++n) {
                if (a[n][i] != 0) {
                    coef = a[n][i] / a[row][i];
                    for (int m = i; m < columns; ++m) {
                        a[n][m] -= coef * a[row][m];
                    }
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
                        coef = a[f][l] / a[h][l];
                        for (int x = l; x < columns; ++x) {
                            a[f][x] -= coef * a[h][x];
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
                    }
                    break;
                }
            }
            --row;
        }

        System.out.println("Reduced Row Echelon form:");
        print(a);

    }
}
