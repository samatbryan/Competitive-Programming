/*
Longest Subarray having sum of elements atmost ‘k’
Given an array of integers, our goal is to find the
length of largest subarray having sum of its elements atmost ‘k’ where k>0.

*/

public class Solution{
  static int solve(int[] arr, int k){
    int res = 0;
    int length = 0;
    int sum = 0;
    int start = 0;
    for(int i=0; i<arr.length; i++){
      sum+=arr[i];
      length +=1;
      if(sum>=k){
        while(sum>=k){
          sum -= arr[start];
          start++;
          length--;
        }
      }
      else{
        if(length>res){
          res = length;
        }
      }
    }
    return res;
  }

  public static void main(String[] args){
    int arr[] = new int[]{1, 1, 0, 1, 1, 0};
    int k = 4;
    System.out.print(solve(arr,3));

  }
}
