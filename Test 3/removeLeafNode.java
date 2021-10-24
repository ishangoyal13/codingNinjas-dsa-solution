public class Solution {

	/*	TreeNode structure 
	 * 
	 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		if(root == null)
			return null;
		// when there are no children of the given root
		if(root.children.size()==0)
			return null;
		for(int i = 0;i<root.children.size();i++)
		{
			TreeNode<Integer> temp = removeLeafNodes(root.children.get(i));
			if(temp == null)
			{
				root.children.remove(i);
				i--;
			}
		}
		return root;
		
	}
}
