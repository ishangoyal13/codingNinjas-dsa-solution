public class Solution {
    public static long balancedBTs(long n){
        if (n <= 1) { 
            return 1;
        } int mod =(int) Math.pow(10, 9) + 7; 
        long x = balancedBTs(n - 1);
        long y = balancedBTs(n - 2); 
        long temp1 = (x * x) % mod;
         long temp2 = (2 * x * y) % mod;
        long ans = (temp1 + temp2) % mod; return ans;
    }
}
