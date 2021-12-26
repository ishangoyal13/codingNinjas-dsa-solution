public class Solution { 
    public static int canSumTo(int k, int x, int n) {
        int rest = (int) (x - Math.pow(k, n)); 
        if (rest == 0) 
        {
            return 1;
        } else if (rest < 0) {
            return 0; 
        }
        int r = 0;
        for (int i = k+1; i < rest; i++) {
            r += Solution.canSumTo(i, rest, n);
        } 
        return r; 
    } public static int allWays(int x, int n) { 
        int r = 0; for (int i = 1; i < x; i++) {
            r += canSumTo(i, x, n); 
        }
        return r;
    }
}
