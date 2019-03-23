package ppj.matrix;

// Gaussian elimination algorithm
public class MainTest {

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

        double[][] a = {{1, 2, 2, 3, 1},
                        {2, 4, 4, 6, 2},
                        {3, 6, 6, 12, 6},
                        {1, 2, 4, 5, 3}};
        int rows = a.length;
        int columns = a[0].length;

        System.out.println("Start:");
        print(a);

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

                    System.out.println("Row swapping: r-" + (row+1) + " and r-" + (tmp+1) );
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
                    System.out.println("Forward: r-" + (n+1) + " c-" + (i+1));
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
                        coef = a[f][l]/a[h][l];
                        for (int x = l; x < columns; ++x) {
                            a[f][x] -= coef * a[h][x];
                        }
                        System.out.println("Backward: r-" + (f+1) + " c-" + (l+1));
                        print(a);
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
                    if(a[row][y] != 1) {
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

    }
}
