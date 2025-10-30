package gridways;

public class calGridWays {
    
    // bruteforce O( 2^(n+m) )
    public static int totalWays(int i, int j, int n, int m) {
        // last case
        if (i == n-1 && j == m-1) {
            return 1;
        }
        // boundary 
        else if(i==n || j==m){
            return 0;
        }
        int res = totalWays(i + 1, j, n, m) + totalWays(i, j + 1, n, m);
        return res;
    }

    // optimized sol - O(n) but cause TLE because of fact cal of large integer no.
    public static int opTotalWays(int n,int m){
        int res = (fact(n+m-2))/(fact(n-1)*fact(m-1));
        return res;
    }
    public static int fact ( int n ){
        if( n==1) return 1;
        int res = n * fact(n-1);
        return res;
    }

    // most optimized coming soon.....
    // DP topic

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        // int ways = totalWays(0, 0, n, m);
        int ways = opTotalWays(n, m);
        System.out.println(ways);
    }
}
