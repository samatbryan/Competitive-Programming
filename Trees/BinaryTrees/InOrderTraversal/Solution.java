public class Solution{

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
      this.val = val;
    }
  }

  // Recursive
  public static void inorder(TreeNode root){
    if(root == null){
      return;
    }
    inorder(root.left);
    System.out.print(root.val);
    inorder(root.right);
  }

  // Iterative
  public static void inorder(TreeNode root){
    Stack<TreeNode> s = new Stack<TreeNode>();

    while(s.size()!=0 || root!=null){

      while(root!=null){
        s.push(root);
        root = root.left;
      }
      root = s.pop();
      System.out.print(root.val);
      root = root.right;

    }
  }

  public static void main(String[] args){
    TreeNode n = new TreeNode(1);
    TreeNode l = new TreeNode(2);
    TreeNode r = new TreeNode(3);
    n.left = l;
    n.right = r;
    inorder(n);
  }
}
