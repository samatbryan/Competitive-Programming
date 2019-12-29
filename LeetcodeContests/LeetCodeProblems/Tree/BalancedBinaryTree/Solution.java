/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

110.  https://leetcode.com/problems/balanced-binary-tree/
 Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

 */

 O(N) Bottom Up Solution. it just uses get Max Height in a bottom up way and flags if theres wrong shit
class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        helper(root);
        return flag == true;
    }
    public int getMaxHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        if(Math.abs(left - right) > 1){
            flag = false;

        }
        return 1 + Math.max(left,right);

    }
}
