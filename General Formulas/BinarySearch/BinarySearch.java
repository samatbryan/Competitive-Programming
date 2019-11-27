public class BinarySearch{
  // return the index of the target
  // if it doesn't exist, return -1;
  static int binarysearch(int[] arr, int target){
    int l = 0;
    int r = arr.length - 1;
    int mid;
    int res = -1;
    while(l<=r){
      mid = l + (r-l)/2;
      if(arr[mid]==target){
        return mid;
      }
      if(arr[mid] < target){
        l = mid + 1;
      }
      else{
        r = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args){
    int[] arr  = new int[]{1,3,5,7,9,11};
    System.out.print(binarysearch(arr, 9));

  }
}
