/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting
node to any node in the tree along the parent-child connections. The path must
contain at least one node and does not need to go through the root.
*/

public class Solution{
  int res = Integer.MIN_VALUE;

  public static int solve(TreeNode root){
    helper(root);
    return res;
  }

  public static int helper(TreeNode root){
    if(root==null){
      return 0;
    }
    int l = helper(root.left);
    int r = helper(root.right);

    int a = Math.max(l + root.val, r + root.val);

    res = Math.max(a,res);
    res = Math.max(res, l + r + root.val);
    res = Math.max(res,root.val);

    return Math.max(a, root.val);
  }


}
