import java.util.*;

public class Solution {
	public static int PairSum(int[] input, int size) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        if (size==0)
            return 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key:input)
        {	
            if(map.containsKey(key))
        	{
            	map.put(key,map.get(key)+1);
        	}
            else
            {
                map.put(key,1);
            }   
        }
        int countPairs=0;
        for (Integer i: map.keySet())
        {
            if (map.containsKey(-i) && i!=0)
            {
            	countPairs=countPairs+(map.get(i)*map.get(-i));   
            }
        }
        countPairs=countPairs/2;
        if (map.containsKey(0))
        {
            int val=map.get(0);
            countPairs=countPairs+(val*(val-1))/2;
        }
        return countPairs;
	}
}
