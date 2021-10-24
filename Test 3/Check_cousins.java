import java.util.ArrayList;



public class solution {

	/*	Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	 */

	public static boolean isCousin(BinaryTreeNode<Integer> root,int node1,int node2) {
		
		
		return !isSiblings(root, node1, node2) && level(root, 0, node1) == level(root, 0, node2);
		
		
		
	}
	public static boolean isSiblings(BinaryTreeNode<Integer> root,int node1,int node2) {

		if(root==null) {
			return false;
		}
		if(root.left!=null && root.right!=null) {
			
			if(root.left.data == node1 && root.right.data == node2) {
				return true;
			}
			
		}
		return isSiblings(root.left, node1, node2) || isSiblings(root.right, node1, node2);
		
	}
	public static int level(BinaryTreeNode<Integer> root,int k,int node1) {

		if(root==null)
			return -1;
		if(root.data == node1) {
			return k;
		}
		int left  = level(root.left, k+1, node1);
		int right = level(root.right, k+1, node1);
		if(left==-1) {
			return right;
		}
		if(right==-1) {
			return left;
		}
		
		return -1;
		
	}
}
