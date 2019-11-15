
/*
Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[]
 is called Bitonic if it is first increasing,
then decreasing. Write a function that takes an array as argument and returns
the length of the longest bitonic subsequence.
A sequence, sorted in increasing order is considered Bitonic with the decreasing
 part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.

*/
public class LBS{
  public static int solve(int[] arr){
    int n = arr.length;

    // this will represent the value of longest increasing sequence starting from index 0 ending at ending i.
    int[] increasing = new int[n];
    int[] decreasing = new int[n];

    for(int i=0; i<n; i++){
      increasing[i] = 1;
      decreasing[i] = 1;
    }
    for(int i=1; i<n; i++){
      for(int j=i-1; j>=0; j--){
        if(arr[i] > arr[j]){
          increasing[i] = Math.max(increasing[j]+1, increasing[i]);
        }
      }
    }
    // this will represent the value of longest decreasing sequence starting from index i ending aft last.
    for(int i=n-1; i>=0; i--){
      for(int j=i+1; j<=n-1; j++){
        if(arr[i] > arr[j]){
          decreasing[i] = Math.max(decreasing[j]+1, decreasing[i]);
        }
      }
    }
    int res = 0;
    for(int i=0; i<=n-2; i++){
      if(increasing[i] + decreasing[i+1] > res){
        res = increasing[i] + decreasing[i+1];
      }
    }
    res = Math.max(res, decreasing[0]);
    res = Math.max(res, increasing[n-1]);
    return res;
    //


  }
  public static void main(String[] args){
    int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
              13, 3, 11, 7, 15};
              System.out.print(solve(arr));

    int arr1[] = {1, 11, 2, 10, 4, 5, 2, 1};
    System.out.print(solve(arr1));

    int arr2[] = {12, 11, 40, 5, 3, 1};
    System.out.print(solve(arr2));

    int arr3[] = {80, 60, 30, 40, 20, 10};
    System.out.print(solve(arr3));
  }
}
