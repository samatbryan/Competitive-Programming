public class MaximumSIS{

/*
Given an array of n positive integers. Write a program to find the sum of maximum sum
subsequence of the given array such that the integers in the subsequence are sorted in
increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output
should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should
be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
*/
  public static int solve(int[] arr){
    int n = arr.length;

    // represents value of sum of max subsequence starting from index i to end.
    int[] dp = new int[n];

    //base case: the largest value from the end is just the end of the array value
    dp[n-1] = arr[n-1];

    //starting from second to last value, and iterate through every value after it,
    //if the net value is greater, than set that as the max of itself or arr[i] + dp[next];

    for(int i=n-2; i>=0; i--){
      for(int j=i+1; j<=n-1; j++){
        if(arr[j] > arr[i]){
          dp[i] = Math.max(dp[i], arr[i] + dp[j]);
        }
        else{
          dp[i] = arr[i];
        }

      }
    }

    return
    return dp[0];
  }

  public static void main(String[] args){
    int arr[] = {10, 5, 4, 3};
    System.out.print(solve(arr));

  }
}
