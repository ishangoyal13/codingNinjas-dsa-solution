import java.util.*;
public class Solution {

	public static int kthLargest(int n, int[] arr, int k) {
		// Write your code here
		// base case
		if(k > n)
            return -1;
        // maintaining a priority queue for this purpos
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        // pushing all the elements of the arrar in the queue
        for(int i=0;i<arr.length;i++)
        	q.add(arr[i]);
        
        // now pop for k times from the queue to get the required element
        int result = 0;
        while(k>0)
        {
            k--;
            result = q.remove();
        }
        return result;
	}
}
