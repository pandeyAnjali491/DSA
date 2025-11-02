package gridways;

public class ratMaze {
     public static boolean findWays(int arr[][], int r, int c, int res[][]) {
        // base case
        if (r == arr.length - 1 && c == arr.length - 1 && arr[r][c]==1){
            res[r][c]=1;
            return true;
        }   
        else if ( r >= arr.length || c >= arr.length || r<0 || c<0)
            return false;
        // logic
        if (arr[r][c] == 0)
            return false;
        // already visited dont go on that path
        if(res[r][c]==1) return false;
        // make path cell 1
        res[r][c]=1;
        if(findWays(arr, r, c + 1, res)) return true;
        if(findWays(arr, r + 1, c, res)) return true;
        if(findWays(arr, r, c - 1, res)) return true;
        if(findWays(arr, r - 1, c, res)) return true;
        // backtrack
        // means path glt that to again 0 kr dia
        res[r][c] = 0;
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int res[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        boolean poss = findWays(maze, 0, 0, res);
        System.out.println(poss);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
