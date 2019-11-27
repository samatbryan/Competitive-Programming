public class Solution{

  // find the first value greater than or equal to x.

  static int find(int[] arr, int x){
    int res = -1;

    int l = 0;
    int r = arr.length - 1;
    int mid;
    while(l<=r){
      mid = l + (r-l)/2;
      if(arr[mid] >= x){
        res = arr[mid];
        r = mid -1;
      }
      else{
        l = mid +1;
      }

    }

    return res;
  }

  public static void main(String[] args){
    int[] arr = new int[]{1,2,4,5,6,7,8};
    System.out.print(find(arr,));
  }



}
