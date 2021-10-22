public class Solution 
{
    private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String path, int currSum) 
    {
        if(root == null) 
        {
            return;
        } if (root.left == null && root.right == null) 
        {
            currSum += root.data; 
            if (currSum == k) { 
                System.out.println((path + root.data + " ")); 
            }
            return;
        } rootToLeafPathsSumToK(root.left, k, (path + root.data + " "), (currSum + root.data)); 
        rootToLeafPathsSumToK(root.right, k, (path + root.data + " "), (currSum + root.data));
    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) 
    {
        rootToLeafPathsSumToK(root, k, "", 0);
    }
}
