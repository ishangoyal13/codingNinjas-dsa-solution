import java.util.*;
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
		
    	private static ArrayList<Integer> arr = new ArrayList<Integer>();
    
        public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2)
        {
            elementsInRangeK1K2Helper(root,k1,k2);
            Collections.sort(arr);
            for (int i:arr)
                System.out.print(i+" ");
        }
		public static void elementsInRangeK1K2Helper(BinaryTreeNode<Integer> root,int k1,int k2){
            
            //Base case - if root=null
            if (root==null)
                return;
            
            int rootData=root.data;
            if (rootData<k1)
            {
                elementsInRangeK1K2Helper(root.right,k1,k2);
            }
            else if (rootData>k2)
            {
                elementsInRangeK1K2Helper(root.left,k1,k2);
            }
            else
            {
                //System.out.print(rootData+" ");
                arr.add(rootData);
                elementsInRangeK1K2Helper(root.right,k1,k2);
                elementsInRangeK1K2Helper(root.left,k1,k2);
            }
			
		}
		
		
	}
