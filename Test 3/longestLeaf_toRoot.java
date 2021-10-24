import java.util.ArrayList;

public class Solution {

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
	
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		if(root==null) {
			return new ArrayList<>();
		}
		
		ArrayList<Integer> leftArrayList = longestRootToLeafPath(root.left);
		ArrayList<Integer> rightArrayList = longestRootToLeafPath(root.right);
		
		if(leftArrayList.size()>=rightArrayList.size()) {
			
			leftArrayList.add(root.data);
			return leftArrayList;
			
		}
		else {
			rightArrayList.add(root.data);
			return rightArrayList;
		}
		
	}

	
	
}
