public class Solution {

	public static int countMinStepsToOne(int n) {
		//Your code goes here
        if (n==0 || n==1)
            return 0;
        else if (n==2 || n==3)
            return 1;
        
        int[] dp = new int[n+1];
        for (int i=0;i<n+1;i++)
            dp[i]=-1;
        
        //Setting base cases
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;
        for (int i=4;i<=n;i++)
        {
            //System.out.println("Current i: "+i);
            int ans1=dp[i-1];
            int ans2=Integer.MAX_VALUE,ans3=Integer.MAX_VALUE;
            if (i%2==0)
            {
                ans2=dp[i/2];
            }
            if (i%3==0)
            {
                ans3=dp[i/3];
            }
            //System.out.println("ans1: "+ans1+", ans2: "+ans2+", ans3: "+ans3);
            dp[i]=Math.min(ans1,Math.min(ans2,ans3))+1;
            //System.out.println(i+": "+dp[i]);
        }
        return dp[n];
	}

}
