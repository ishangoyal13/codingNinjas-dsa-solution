public class Solution {
    
	public static int countMinStepsToOne(int n) {
		//Your code goes here
        if (n<=1)
            return 0;
        else if (n==2 || n==3)
            return 1;
        
       int output1=countMinStepsToOne(n-1);
       int output2=Integer.MAX_VALUE;
       int output3=Integer.MAX_VALUE;
        
       if (n%2==0)
           output2=countMinStepsToOne(n/2);
        
       if (n%3==0)
           output3=countMinStepsToOne(n/3);
        
       return Math.min(Math.min(output2,output3),output1)+1;
	}

}
