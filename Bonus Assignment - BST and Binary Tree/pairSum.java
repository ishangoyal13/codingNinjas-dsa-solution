import java.util.Stack;
public class Solution {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {

        if(root==null) {
            return ;
        }

      
        Stack<BinaryTreeNode<Integer>> stack1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> stack2 = new Stack<>();
        BinaryTreeNode<Integer> temp = root;
        while(temp!=null){
            stack1.push( temp  );
            temp = temp.left;
        }
        temp =root;
        while(temp!=null){
            stack2.push( temp  );
            temp = temp.right;
        }


        // Assume BST contains all unique elements
        while( !stack1.isEmpty() && !stack2.isEmpty() && (stack1.peek().data < stack2.peek().data) ) {

            BinaryTreeNode<Integer> frontNode1 = stack1.peek(),frontNode2 = stack2.peek();

            if(frontNode1.data + frontNode2.data == s) {

                System.out.println( frontNode1.data +" " + frontNode2.data );
                stack1.pop();
                stack2.pop();
                    
                

                frontNode1 = frontNode1.right;

                while(frontNode1!=null) {
                    stack1.push(frontNode1);
                    frontNode1 = frontNode1.left;
                }

                frontNode2 = frontNode2.left;

                while(frontNode2!=null) {
                    stack2.push(frontNode2);
                    frontNode2 = frontNode2.right;
                  
                }


            }

            else if( frontNode1.data + frontNode2.data  < s  ) {
                stack1.pop();
                
                
                frontNode1 = frontNode1.right;

                while(frontNode1!=null) {
                    stack1.push(frontNode1);
                    frontNode1 = frontNode1.left;
                }



            }
            else {
                stack2.pop();
                    
                
                frontNode2 = frontNode2.left;

                while(frontNode2!=null) {
                    stack2.push(frontNode2);
                    frontNode2 = frontNode2.right;
                }

            }


        }

    }

}
