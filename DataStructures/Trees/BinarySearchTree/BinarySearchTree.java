import java.util.*;

public class BinarySearchTree{
  public static void main(String[] args){
    int[] arr = new int[]{1,2,3,4,5,6};
    BinarySearchTree bst  = new BinarySearchTree(arr);

  }
  Node root;
  int[] arr;

  BinarySearchTree(int[] arr){
    Arrays.sort(arr);
    this.arr = arr;
    root = makeBST(0, arr.length-1);
    printInOrder(root);
  }

  Node makeBST(int l, int r){
    if(l>r){
      return null;
    }
    int mid =  l + (r-l)/2;
    Node n = new Node(arr[mid]);
    n.left = makeBST(l,mid-1);
    n.right = makeBST(mid+1, r);

    return n;

  }

  void printInOrder(Node curr){
    if(curr == null){
      return;
    }
    printInOrder(curr.left);
    System.out.print(curr.val + " ");
    printInOrder(curr.right);
  }


  static class Node{
    Node left, right;
    int val;
    Node(int val){
      this.val = val;
    }
  }
}
