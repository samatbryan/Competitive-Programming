
/*
Given an array of integers and a sum. We have to
 find sum of subarray having maximum sum less than or equal to given sum in array.

*/
public class Solution{

  static int solve(int[] arr, int k){
    int res = 0;
    int sum = 0;
    int start = 0;
    for(int i=0; i<arr.length; i++){
      sum += arr[i];
      while(sum>k){
        sum -= arr[start];
        start +=1;
      }
      if(sum>res){
        res = sum;
      }
    }

    return res;
  }
  public static void main(String[] args){
      int[] arr = new int[]{ 2, 4, 6, 8, 10 };
      System.out.print(solve(arr, 7));
  }
}
