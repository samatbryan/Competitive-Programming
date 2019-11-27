import java.util.*;

public class BinaryTree{
  public static void main(String[] args){
    int[] arr = new int[]{1,2,3,4,5};
    BinaryTree bt = new BinaryTree(arr);
    bt.printLevelOrder();
  }

  Node root;
  // left child =  2i + 1
  // right child = 2i + 2
  BinaryTree(int[] arr){
    // level order binary Tree
    if(arr.length == 0){
      return;
    }
    root = new Node(arr[0]);
    setBinaryTree(root, arr, 0);
  }

  void setBinaryTree(Node root, int[] arr, int index){
    int n = arr.length;
    if(2*index + 1 < n){
      root.left = new Node(arr[2*index + 1]);
      setBinaryTree(root.left, arr, 2*index + 1);
    }
    if(2*index + 2 < n){
      root.right = new Node(arr[2*index + 2]);
      setBinaryTree(root.right, arr, 2*index + 2);
    }
  }

  void printLevelOrder(){
    ArrayDeque<Node> q = new ArrayDeque<Node>();
    q.add(root);
    Node curr;
    while(q.size() != 0){
      curr = q.pop();
      System.out.print( curr.val + " ");
      if(curr.left!=null){
        q.add(curr.left);
      }
      if(curr.right!= null){
        q.add(curr.right);
      }
    }
  }


  static class Node{
    Node left;
    Node right;
    int val;
    Node(int val){
        this.val  = val;
    }
  }

}
