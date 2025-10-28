package nQueens;
public class oneSolOfNQueens {
    public static boolean nQueens(char chess[][], int row) {
        if (row == chess.length) {
            return true;
        }
        // for each col in rows
        for (int j = 0; j < chess.length; j++) {
            if (isSafe(chess, row, j)) {
                chess[row][j] = 'Q';
                if(nQueens(chess, row + 1)){
                    return true;
                }
                chess[row][j] = '.';
            }
        }
        return false;
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

    public static void printArr(char arr[][]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------chess board----");
    }

    public static void main(String[] args) {
        int n = 5;
        char chess[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        if(nQueens(chess, 0)){
            System.out.println("sol exist");
            printArr(chess);
        }
        else{
            System.out.println("not exist");
        }
        
    }
}
