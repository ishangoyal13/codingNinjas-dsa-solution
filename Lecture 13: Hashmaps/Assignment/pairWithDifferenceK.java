import java.util.HashMap;
public class Solution {

	public static int getPairsWithDifferenceK(int arr[], int k) {
		//Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key:arr)
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
        /*
        for (Integer i: map.keySet())
        {
            System.out.println(i + ": " + map.get(i));
        }
        System.out.println();
        */
        int countPairs=0;
        if (k==0)
        {
            for (Integer i: map.keySet())
        	{
                int val=map.get(i);
            	countPairs=countPairs+(val*(val-1))/2;
        	}
            return countPairs;
        }
        
        for (Integer i: map.keySet())
        {
            
            if (map.containsKey(k+i))
            {
                
            	countPairs=countPairs+(map.get(i)*map.get(k+i));   
                
            }
            if (map.containsKey(i-k))
            {
                
            	countPairs=countPairs+(map.get(i)*map.get(i-k));   
                
            }
            
        }
        countPairs=countPairs/2;
        return countPairs;
	}
}
