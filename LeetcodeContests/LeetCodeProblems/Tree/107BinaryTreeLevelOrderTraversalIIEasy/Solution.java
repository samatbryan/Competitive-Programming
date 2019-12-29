/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> res = new ArrayList<List<Integer>>();
         if(root == null){
            return res;
        }


        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i=0; i<levelSize; i++){
                TreeNode t = q.poll();
                tmp.add(t.val);
                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right != null){
                    q.add(t.right);
                }
            }
            res.add(tmp);
        }
        Collections.reverse(res);
        return res;

    }

}
