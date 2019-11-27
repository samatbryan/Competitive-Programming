// Segment comes from the fact that we can get segments of an array fast
// Good for range Queries.

/*
O(space)
height = O(logN)

O(LogN) update
O(LogN) query
leaf nodes of a segment tree are the elements of our array
*/
import java.util.*;

public class SegmentTree{
  int[] segtree;
  int N;

  SegmentTree(int[] arr){
    this.arr = arr;
    N = arr.length;
    //height of tree
    int height = (int) Math.ceil(Math.log(N) / Math.log(2));
    //max size of segment tree
    int max_size = (int) Math.pow(2,height+1) - 1;
    //our segtree data structure is an array
    segtree = new int[max_size];
    //util to fill in our segtree
    constructSegTreeUtil(arr, 0 , n-1, 0);
  }
  // A utility function to get the middle index from corner indexes.
    int getMid(int l, int r) {
        return l + (r - l) / 2;
    }

  // recursive utility to construct out "heap"-like segment tree. "i" = currentNode
  void constructSegTreeUtil(int[] arr, int l, int r, int i){
    if(l==r){
      segtree[i] = arr[l];
      return segtree[i];
    }
    int mid = getMid(l,r);

    //Arr[(2*i)+1]	Returns the left child node
    //Arr[(2*i)+2]	Returns the right child node
    segtree[i] = constructSegTreeUtil(arr, l, mid, 2*i + 1) +
                 constructSegTreeUtil(arr, mid+1, r, 2*i + 2);
    return segtree[i];
  }


}
