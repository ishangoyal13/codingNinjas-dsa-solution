/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {

	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {

        rootToLeafPathsSumToK(root, k,"");

    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k,String output) {

    	 if(root==null){
             return ;
         }
    	
        if(k==root.data) {
            System.out.println(output+root.data);
            return ;
        }
       
        rootToLeafPathsSumToK(root.left, k - root.data, output + root.data+" " );
        rootToLeafPathsSumToK(root.right, k - root.data, output + root.data+" " );


    }

}
