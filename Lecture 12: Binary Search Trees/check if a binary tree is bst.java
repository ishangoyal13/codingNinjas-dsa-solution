import java.util.*;

public class Solution {
    
    
    public static int maximum(BinaryTreeNode<Integer> root)
    {
           if(root==null)
            return Integer.MIN_VALUE;
       
        return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));
        
        
    }
    
    
     public static int minimum(BinaryTreeNode<Integer> root)
    {
            if(root==null)
            return Integer.MAX_VALUE;
       
        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right)));
    }
    
    
    
    

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		if(root==null)
            return true;
        
        
        int leftmax= maximum(root.left);
        int rightmin=minimum(root.right);
        
       // boolean temp=true;
      
       
       // if(root.left!=null)
       // {
            	if(root.data<=leftmax)
           		 return false;
        
        
            	if(root.data>rightmin)
           		 return false;
        
        
       
     
         
    
            boolean	isLeftBst=isBST(root.left);
        
           boolean	isRightBst=isBST(root.right);
        
        
        
        if(isLeftBst && isRightBst)
            return true;
        else
            return false;
     
        
       
        
        
	}
}
