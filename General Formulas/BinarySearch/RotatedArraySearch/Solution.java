/*

Find the smallest element in a rotated sorted array


4 5 6 7 1 2 3
*/

// pick the first false condition.
// true if number is >= right number
// false if number is <= right number

public class Solution{

  static int smallest(int[] arr){
    int res = -1;
    int l = 0;
    int r = arr.length - 1;
    int mid;
    int end = arr[r];

    while(l<=r){
      mid = l + (r-l)/2;
      if(arr[mid]<end){
        res = arr[mid];
        r = mid-1;
      }
      else{
        l = mid +1;
      }
    }
    return res;
  }

  public static void main(String[] args){
    int[] arr = new int[]{4, 5 ,6, 7 ,1 ,2, 3};
    System.out.print(smallest(arr));
  }
}
