/*
Given a binary tree and a sum, determine if the tree has
a root-to-leaf path such that adding up all the values along
 the path equals the given sum.

Note: A leaf is a node with no children.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return helper(root, sum, 0);
    }
    public boolean helper(TreeNode root, int sum, int currSum){
        if(root==null){
            return false;
        }
        currSum += root.val;
        

        if(root.left!=null && root.right!=null){
            return helper(root.left, sum, currSum) || helper(root.right, sum, currSum);
        }
        if(root.left!=null){
            return helper(root.left, sum, currSum);
        }
        if(root.right!=null){
            return helper(root.right, sum, currSum);
        }
        if(currSum == sum){
            return true;
        }
        return false;


    }
}
