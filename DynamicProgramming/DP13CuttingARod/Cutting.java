/*
Given a rod of length n inches and an array of prices that contains
 prices of all pieces of size smaller than n. Determine the maximum
 value obtainable by cutting up the rod and selling the pieces. For
 example, if length of the rod is 8 and the values of different pieces
 are given as following, then the maximum obtainable value is 22
  (by cutting in two pieces of lengths 2 and 6)

  length   | 1   2   3   4   5   6   7   8
  --------------------------------------------
  price    | 1   5   8   9  10  17  17  20

*/

public class Cutting{

  public static int solve(int price[], int n){
    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = price[0];

    // base case as length i rod as price [i];
    for(int i=1; i<=price.length; i++){
      dp[i] = price[i-1];
    }

    // for each length i, the maximum price for length i is splitting into j and i-j.
    for(int i=2; i<=n; i++){
      int max = Integer.MIN_VALUE;
      for(int j=1; j<=i; j++){
        dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
      }
    }


    return dp[n];
  }
  public static void main(String[] args){
    int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
    System.out.print(solve(arr, 8));
  }
}
