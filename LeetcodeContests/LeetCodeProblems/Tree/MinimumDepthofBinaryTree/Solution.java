/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.


 */
class Solution {



    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /// DFS
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right == null){
            return 1;
        }

        dfs(root,1);
        return min;

    }
    void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(level < min){
                min = level;
            }
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

    }




    APPROACH BFS O(N)
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int expectedNodes = 1;
        int level = 0;
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            level +=1;
            int size = q.size();

            expectedNodes *=2;
            for(int i=0; i<size; i++){
                TreeNode t = q.poll();
                if(t.left== null && t.right==null){
                    return level;
                }
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }

        }
        return level;
    }
}
