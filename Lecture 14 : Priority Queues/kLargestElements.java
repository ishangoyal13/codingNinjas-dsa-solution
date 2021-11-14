import java.util.*;

public class Solution {

	public static ArrayList<Integer> kLargest(int arr[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // inserting the first k elements in the queue
        for(int i=0;i<k;i++)
        {
            queue.add(arr[i]);
        }
        // now maintain the queue
        for(int i=k;i<arr.length;i++)
        {
            int min = queue.peek();
            if(arr[i]>min)
            {
                queue.remove();
                queue.add(arr[i]);
            }
        }
        for(int i=0;i<k;i++)
        {
            list.add(queue.remove());
        }
        return list;
		
	}
}
