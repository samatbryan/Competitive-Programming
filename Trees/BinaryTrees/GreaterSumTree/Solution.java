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

  //Solution 1 CLEAN REVERSE In ORDER with running sum
  public TreeNode bstToGst(TreeNode root) {
       int[] sum = new int[1];

       helper(root, sum);
       return root;
   }
   public void helper(TreeNode root, int[] sum){
       if(root==null){
           return;
       }
       helper(root.right, sum);
       sum[0] += root.val;
       root.val = sum[0];
       helper(root.left, sum);
   }

   // Solution 2. more intuitive
    int index  = 0;
    ArrayList<Integer> a = new ArrayList<Integer>();

    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        int sum =0;
        for(int i=a.size()-1; i>=0; i--){
            sum += a.get(i);
            a.set(i,sum);
        }

        index = 0;
        change(root);
        return root;


    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        a.add(root.val);
        inorder(root.right);
    }
    public void change(TreeNode root){
        if(root == null){
            return;
        }
        change(root.left);
        root.val = a.get(index);
        index +=1;
        change(root.right);
    }



}
