public class Solution {

	/*	Binary Tree Node class 
	 * 
	 * 	class BinaryTreeNode<T> {
			T data;
			BinaryTreeNode<T> left;
			BinaryTreeNode<T> right;
			
			public BinaryTreeNode(T data) {
				this.data = data;
			}
		}
		*/
	
		public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
            return SortedArrayToBSTHelper(arr,0,n-1);
			
		}
    
        public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int si, int ei){
            if (si>ei)
                return null;
            
            int mid=(si+ei)/2;
            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
            
            root.left=SortedArrayToBSTHelper(arr,si,mid-1);
            root.right=SortedArrayToBSTHelper(arr,mid+1,ei);
            return root;
			
		}
	}
