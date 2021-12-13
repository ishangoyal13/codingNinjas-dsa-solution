public class Solution {

	public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        //Handling the base cases where number of houses = 0,1,2
        if (houses.length==0)
            return 0;
        
        if (houses.length==1)
            return houses[0];
        
        if (houses.length==2)
            return Math.max(houses[0],houses[1]);
        
        int n = houses.length;
        int[] dp = new int[n];
        dp[0]=houses[0];
        dp[1]=Math.max(houses[0],houses[1]);
        
        for (int i=2;i<n;i++)
        {
            //For every house, we consider two cases
            //Case 1 - Current house is counted as part of the max value => This means the previous house cannot be counted
            int maxVal1=dp[i-2]+houses[i];
            
            //Case 2 - Current house is not counted as part of the max value => This means previous house can be counted
            int maxVal2=dp[i-1];
            
            //Max value till current house is maximum of the two possible max values till now
            dp[i]=Math.max(maxVal1,maxVal2);
        }
        
        //Final element of dp stores max possible value for given number of houses and their respective amounts of loot
        return dp[n-1];
        
	}

}
