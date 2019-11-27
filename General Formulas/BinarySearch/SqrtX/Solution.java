public class Solution{

  // find the sqrt x
  static int sqrt(int x){
    int l = 1;
    int r = x;
    int mid;

    while(l<=r){
      mid = l + (r-l)/2;
      if(mid*mid == x){
        return mid;
      }
      if(mid*mid < x){
        l = mid+1;
      }
      else{
        r = mid-1;
      }

    }
    return -1;
  }
  public static void main(String[] args){
    System.out.println(sqrt(16));
    System.out.print(sqrt(17));

  }
}
