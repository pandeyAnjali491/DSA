package nQueens;

// ques - return the count of all possible sol 
public class nQueens2 {
    static int count = 0;

    public static int nQueens(char chess[][], int row) {
        if (row == chess.length) {
            count++;
            return count;
        }
        // for each col in rows
        for (int j = 0; j < chess.length; j++) {
            if (isSafe(chess, row, j)) {
                chess[row][j] = 'Q';
                nQueens(chess, row + 1);
                chess[row][j] = '.';
            }
        }
        return count;
    }

    public static boolean isSafe(char chess[][], int row, int col) {
        // vertical up
        for (int i = row; i >= 0; i--) {
            if (chess[i][col] == 'Q')
                return false;
        }
        // left diag
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q')
                return false;
        }
        // right diag
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static int totalNQueens(int n) {
        char chess[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        nQueens(chess, 0);
        return count;
    }
    public static void main(String[] args) {
        int n = 5;
        int count = totalNQueens(n);
        System.out.println(count);
    }
}
