/*

Given a binary search tree and the lowest and highest boundaries as L and R,
trim the tree so that all its elements lies in [L, R] (R >= L).
You might need to change the root of the tree, so the result should
return the new root of the trimmed binary search tree.


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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){
            return null;
        }
        if(root.val >= L && root.val <=R){
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
            return root;
        }
        if(root.val>R){
            root = root.left;
            return trimBST(root,L,R);
        }
        if(root.val<L){
            root = root.right;
            return trimBST(root,L,R);
        }
        return root;


    }
}
