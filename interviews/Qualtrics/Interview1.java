// Find square root of a number without Math.pow

public class Interview1{
// do binary search on the input

  public int squareRoot(int n){
    return binarySearch(n, 0, n);
  }

  public int binarySearch(int n, int left, int right){
    int mid = (left + right) / 2;
    int square = mid*mid;
    if(square == n){
      return mid;
    }
    while(left<right){

      square = mid*mid;
      if(n>square && n< square + mid){
        return mid;
      }
      if(square == n){
        return mid;
      }
      if(square > n){
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }
      mid = (left + right) / 2;

    }
    return mid;
  }
public static void main(String[] args){
  Interview1 s = new Interview1();
  System.out.println(s.squareRoot(25));

}
}
