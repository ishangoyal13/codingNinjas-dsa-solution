class deleteClass
{
	BinaryTreeNode<Integer> root;
	boolean isDelete;
	// creating a constructor
	deleteClass(BinaryTreeNode<Integer> root,boolean isDelete)
	{
		this.root = root;
		this.isDelete = isDelete;
	}
}

public class BinarySearchTree {
    private BinaryTreeNode<Integer> root2 = null;
    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root2, int x)
    {
        if (root2 == null) {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(x);
			return newNode;
		}
		if (root2.data >= x) {
			root2.left = insertHelper(root2.left, x);
		} else if (root2.data < x) {
			root2.right = insertHelper(root2.right, x);
		}
		return root2;
    }
	public void insert(int x) {
		//Implement the insert() function
	 	root2 = insertHelper(root2,x);
	}
    
	private static int findingSmallest(BinaryTreeNode<Integer> root2)
	{
		int min = root2.data;
		while(root2.left!=null)
		{
			min = root2.left.data;
			root2= root2.left;
		}
		return min;
	}
	public static deleteClass deleteHelper(BinaryTreeNode<Integer> root2, int x)
	{
		if(root2 == null)
		{
			deleteClass temp = new deleteClass(null,false);
			return temp;
		}
		if(root2.data < x)
		{
			deleteClass left = deleteHelper(root2.right,x);
			// now updating the root
			root2.right = left.root;
			// instead of creating a new object we will reuse the previous object(left)
			left.root = root2;
			return left;
		}
		else if(root2.data > x)
		{
			deleteClass right=deleteHelper(root2.right,x);
			root2.right = right.root;
			right.root = root2;
			return right;
		}
		else
		{
			deleteClass temp = null;
			// case-1 when the root don't have any children
			if(root2.left == null && root2.right == null)
			{
				temp = new deleteClass(null,true);
//				return temp;
			}
			
			// case-2 when the root have one child
			else if(root2.left == null && root2.right!=null)
			{
				temp = new deleteClass(root2.right,true);
//				return temp;
			}
			else if(root2.left!=null && root2.right == null)
			{
				temp = new deleteClass(root2.left,true);
//				return temp;
			}
			
			// case-3 when root have both the children
			// then replace the data of root with the smallest value in right subtree
			else if(root2.left!=null && root2.right!=null)
			{
				// finding the smallest in right subtree
				root2.data = findingSmallest(root2.right);
				// now deleting that node
				deleteClass temp2 = deleteHelper(root2.right,root2.data);
				root2.right = temp2.root;
				temp = new deleteClass(root2,true);
//				return temp;
			}
			return temp;
				
		}
	}
	public void remove(int data) {
		//Implement the remove() function
        // for successful deletion of node
		deleteClass result = deleteHelper(root2,data);
		root2 = result.root;
		return;
	}
	private static void printTreeHelper(BinaryTreeNode<Integer> root)
    {
        if(root == null)
            return;
        String str = root.data+":";
        if(root.left!=null)
            str = str+"L:"+root.left.data+",";
        if(root.right!=null)
            str = str+"R:"+root.right.data;
        System.out.println(str);
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }
	public void printTree() {
		//Implement the printTree() function
        printTreeHelper(root2);
	}
	
    private static boolean searchHelper(BinaryTreeNode<Integer> root, int x)
    {
        if(root == null)
            return false;
        if(root.data == x)
            return true;
        else if(root.data < x)
            return searchHelper(root.right,x);
        else 
            return searchHelper(root.left,x);
    }
	public boolean search(int x) {
		//Implement the search() function
        return  searchHelper(root2, x);
        
	}
	

}
