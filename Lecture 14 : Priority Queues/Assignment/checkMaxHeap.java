public class Solution {

		public static boolean checkMaxHeap(int arr[])
	{
		boolean result = true;
		for(int i=(arr.length/2)-1;i>=0;i--)
		{
			result = heapCheck(arr,i,arr.length);
			if(result != true)
				return false;
		}
		return result;
	}
	private static boolean heapCheck(int arr[], int i, int length) {
		int parent = i;
		int c1= parent*2+1;
		int c2 = parent*2+2;
		if(arr[parent] < arr[c1])
			return false;
		else if(c2< length && arr[c2] > arr[parent])
			return false;
		else
			return true;
		
	}
}
