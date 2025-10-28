package nQueens;

import java.util.ArrayList;
import java.util.List;

// ques - we have to return all the possible solutions of nQueens in the form of list
public class nQueens1 {
    public static List<List<String>> nQueens(char chess[][], int row, List<List<String>> res) {
        if (row == chess.length) {
            List<String> sol = new ArrayList<String>();
            for (int i = 0; i < chess.length; i++) {
                StringBuilder str = new StringBuilder("");
                for (int j = 0; j < chess[i].length; j++) {
                    str.append(chess[i][j]);
                }
                sol.add(str.toString());
            }
            res.add(sol);
            return res;
        }
        // for each col in rows
        for (int j = 0; j < chess.length; j++) {
            if (isSafe(chess, row, j)) {
                chess[row][j] = 'Q';
                nQueens(chess, row + 1, res);
                chess[row][j] = '.';
            }
        }
        return res;
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

    public static List<List<String>> solveNQueens(int n) {
        char chess[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        res = nQueens(chess, 0, res);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        for (var ele : res) {
            System.out.println(ele);
        }
    }
}