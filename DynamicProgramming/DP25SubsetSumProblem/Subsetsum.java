/*
Given a set of non-negative integers,
and a value sum, determine if there
is a subset of the given set with sum equal to given sum.



O(Nw) where w is the sum;
dp[i][j] where i represents the sum, j represents the number of elements we use in the set from 0 to j

base case: dp[i][0] = false.
dp[0][0] = true;

for(int i=0; i<=sum; i++){
  for(int j=1; j<arr.length; j++){
    dp[i][j] = dp[i-arr[j]][j-1] v dp[i][j-1] is true
  }
}
*/

public class Subsetsum{

  public static boolean solve(int[] arr, int sum){
    boolean dp[][] = new boolean[sum+1][arr.length+1];
    // sum, how much of array we have.
    for(int i=0; i<=sum; i++){
      dp[i][0] = false;
    }
    dp[0][0] = true;
    for(int i=1; i<=sum; i++){
      for(int j=1; j<=arr.length; j++){
        if(i-arr[j-1]>=0){
          dp[i][j] = dp[i-arr[j-1]][j-1] || dp[i-1][j-1];
        }
        else{
          dp[i][j] = dp[i-1][j-1];
        }
      }
    }
    return dp[sum][arr.length];

  }
  public static void main(String[] args){
    int[] set = {3, 34, 4, 12, 5, 2};
    System.out.print(solve(set,60));
  }
}
