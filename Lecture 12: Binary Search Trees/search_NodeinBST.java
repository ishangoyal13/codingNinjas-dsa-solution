public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */


	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root==null)
        {
            return false;
        }
        
        int rootData=root.data;
        if (k<rootData)
        {
            return searchInBST(root.left,k);
        }
        else if(k>rootData)
        {
            return searchInBST(root.right,k);
        }
        else
        {
            return true;
        }
        
		
	}
}
