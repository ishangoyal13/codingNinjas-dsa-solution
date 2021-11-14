public class Solution {
	public static void downHeapify(int arr[],int i,int n)
	{
		int parent = i;
		int c1 = parent*2+1;
		int c2 = parent*2+2;
		while(c1<n)
		{
			int smaller = parent;
			if(arr[c1] < arr[parent])
				smaller = c1;
			if(c2 < n && arr[c2]<arr[smaller])
				smaller = c2;
			// no swapping required
			if(smaller == parent)
				return;
			// swap them and update the indices
			int temp = arr[parent];
			arr[parent] = arr[smaller];
			arr[smaller] = temp;
			parent = smaller;
			c1 = parent*2+1;
			c2 = parent*2+2;
			
		}
	}
	public static void inplaceHeapSort(int arr[]) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Change in the given input itself.
		* Taking input and printing output is handled automatically.
		*/
		int n = arr.length;
		for(int i = n/2-1;i>=0;i--)
		{
			downHeapify(arr,i,n);
		}
		// now remove the element from the starting and put them at their respective position from the end
		for(int i = n-1;i>=0;i--)
		{
			// first swap them and then heapify them again
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			downHeapify(arr,0,i);
		}
	}
}
