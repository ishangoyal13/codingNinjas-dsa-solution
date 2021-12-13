public class Solution {

	public static int minCostPath(int[][] cost) {
		//Find number of rows m  and number of cols n
		int m=cost.length;
		int n=cost[0].length;
				
		//Create (m+1) * (n+1) dp matrix with all values = infinity
		int[][] dp = new int[m+1][n+1];
		for (int i=0;i<dp.length;i++)
		{
			for (int j=0;j<dp[0].length;j++)
			{
				//We initialize each element as -infinity as the cost can be any positive or negative value (including +infinity)
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		
		//We start filling the minimum cost values for elements from (m-1,n-1) to (0,0)
		for (int i=m-1;i>=0;i--)
		{
			for (int j=n-1;j>=0;j--)
			{
				//Handle special case for i=m-1, j=n-1
				if (i==m-1 && j==n-1)
				{
					dp[i][j]=cost[i][j];
					continue;
				}
				int ans1=dp[i+1][j];
				int ans2=dp[i][j+1];
				int ans3=dp[i+1][j+1];
				
				dp[i][j]=cost[i][j]+Math.min(ans1, Math.min(ans2, ans3));
			}
		}
		return dp[0][0];	
	}
}
