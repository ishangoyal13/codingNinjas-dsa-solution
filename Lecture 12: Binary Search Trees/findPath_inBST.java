import java.util.ArrayList;

public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 * 		public BinaryTreeNode(T data) 
	 * 		{ 
	 * 			this.data = data; 
	 * 		}
	 * }
	 */

	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int x){
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        if(root == null)
			return null;
		ArrayList<Integer> output = new ArrayList<>();
		if(root.data==x)
		{
			
			output.add(root.data);
			return output;
		}
		// if the value of x is less than root then search on the left side of tree
		else if(x<root.data)
		{
			ArrayList<Integer> temp = getPath(root.left,x);
			if(temp!=null)
			{
				output.addAll(temp);
				output.add(root.data);
				return output;
			}
			else
				return null;
//			return output;
		}
		else if(x>root.data)
		{
			ArrayList<Integer> temp = getPath(root.right,x);
			if(temp!=null)
			{
                output.addAll(temp);
				output.add(root.data);
				return output;
			}
			else
				return null;
		}
		else {
			return null;
		}
	}
}
