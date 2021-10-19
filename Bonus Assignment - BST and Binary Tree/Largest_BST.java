class Pair<T,V>{
	T first;
	V second;
//	public Pair(T first,V second) {
//		this.first = first;
//		this.second = second;
//	}
}
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
	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {

        return largestBSTSubtree1(root).second.second;
    }
    public static Pair<Pair<Integer,Integer>,Pair<Boolean,Integer>> largestBSTSubtree1(BinaryTreeNode<Integer> root) {

        if(root==null) {
            Pair<Integer,Integer> innerPair1 = new Pair<>();
            innerPair1.first =Integer.MIN_VALUE;
            innerPair1.second = Integer.MAX_VALUE;
            Pair<Boolean,Integer> innerPair2= new Pair<>();
            innerPair2.first =true;
            innerPair2.second = 0;
            Pair<Pair<Integer,Integer>,Pair<Boolean,Integer>> ansPair = new Pair<>();
            ansPair.first = innerPair1;
            ansPair.second = innerPair2;
            return ansPair;
        }

        Pair<Pair<Integer,Integer>,Pair<Boolean,Integer>> leftAnsPair = largestBSTSubtree1(root.left);
        Pair<Pair<Integer,Integer>,Pair<Boolean,Integer>> rightAnsPair = largestBSTSubtree1(root.right);
        Pair<Pair<Integer,Integer>,Pair<Boolean,Integer>> ansPair = new Pair<>();
        Pair<Integer,Integer> innerPair1 = new Pair<>();
        Pair<Boolean,Integer> innerPair2= new Pair<>();
        innerPair1.first = Math.max( Math.max( leftAnsPair.first.first  , rightAnsPair.first.first ),
                                    root.data
                                   );
        innerPair1.second = Math.min( Math.min( leftAnsPair.first.second  , rightAnsPair.first.second ),
                                     root.data
                                    );
        innerPair2.first = leftAnsPair.second.first && rightAnsPair.second.first && 
            ( leftAnsPair.first.first < root.data  ) &&
            (rightAnsPair.first.second > root.data);
        
        if( innerPair2.first) {
            innerPair2.second = Math.max( leftAnsPair.second.second  , rightAnsPair.second.second
                                        ) + 1;
        }
        else{
            innerPair2.second = Math.max(leftAnsPair.second.second , rightAnsPair.second.second);
        }
        ansPair.first = innerPair1;
        ansPair.second = innerPair2;

        return ansPair;




    }

}
