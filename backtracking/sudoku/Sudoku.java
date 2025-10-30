package sudoku;
public class Sudoku {

    // if char board array is there then change is only in the digit
    // dig = (char) (dig + '0') for "1" instead of 1
    // if there is integer board 

    public static boolean sudokuSolver(int sudoku[][], int r, int c) {
        // base case
        if (r == 9 ) {
            return true;
        }
        // logic
        int nextRow = r, nextCol = c + 1;
        if (c + 1 == 9) {
            nextRow = r + 1;
            nextCol = 0;
        }
        if (sudoku[r][c] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for (int dig = 1; dig <= 9; dig++) {
            if (isSafe(sudoku, r, c, dig)) {
                sudoku[r][c] = dig;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[r][c] = 0;
            }
        }
        // for char array
        // for (int dig = 1; dig <= 9; dig++) {
        //     if (isSafe(sudoku, r, c, (char) (dig + '0'))) {
        //         sudoku[r][c] = (char) (dig + '0'); ;
        //         if (sudokuSolver(sudoku, nextRow, nextCol)) {
        //             return true;
        //         }
        //         sudoku[r][c] = '.';
        //     }
        // }
        return false;
    }

    public static boolean isSafe(int sudoku[][], int r, int c, int dig) {
        // col search
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][c] == dig)
                return false;
        }
        // row search
        for (int j = 0; j < 9; j++) {
            if (sudoku[r][j] == dig)
                return false;
        }
        // grid search
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int i = sr; i < (sr + 3); i++) {
            for (int j = sc; j < (sc + 3); j++) {
                if (sudoku[i][j] == dig)
                    return false;
            }
        }
        return true;
    }

    public static void printSol(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("sol exist");
            printSol(sudoku);
        } else {
            System.out.println("not exist");
        }
    }
}
