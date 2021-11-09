import java.util.*;
public class Solution {
	
	public static int buyTicket(int arr[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		if(k>=arr.length)
			return Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i:arr)
		{
			list.add(i);
			q.add(i);
		}
		int time = 0;
		
		
		for(int i = 0;i<list.size();i++)
		{
			if(list.get(i)>=q.peek())
			{
				time++;
				if(i == k)
					break;
				q.remove();
				
			}
			else {
				list.add(list.get(i));
				list.remove(i);
				if(k==i)
					k = list.size()-1;
				else
					k--;
				i--;
				
			}
		}
		return time;
	}
}
