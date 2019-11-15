/*

You start at index 0 in an array with length 'h'. At each step,
you can move to the left, move to the right, or stay in the same
place(Note! Stay in the same place also takes one step). How many
possible ways are you still at index 0 after you have walked 'n' step?

Example： n = 3
1. right->left->stay
2. right->stay->left
3. stay->right->left
4. stay->stay->stay



*/
public class Solution{

  public static int solveSpaceOptimized(int n){
    int[] prev = new int[n+1];
    int[] next = new int[n+1];
    prev[0] = 1;
    for(int i=1; i<=n; i++){
      for(int j=0; j<=n; j++){
        if(j==0){
          next[j] = prev[j] + prev[j+1];
        }
        else if(j==n){
          next[j] = prev[j] + prev[j-1];
        }
        else{
          next[j] = prev[j] + prev[j-1] + prev[j+1];
        }
      }
      prev = next.clone();
    }

    return prev[0];
  }


  public static int solve(int n){


    int[][] dp = new int[n+1][n+1];
    // base case when n = 0:
    // each index i is the number of ways to get there with index j steps.

    dp[0][0] = 1;
    for(int j=1; j<=n; j++){
      for(int i=0; i<=n; i++){
        if(i==0){
          dp[i][j] = dp[i][j-1] + dp[i+1][j-1];
        }
        else if(i==n){
          dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
        }
        else{
          dp[i][j] = dp[i][j-1] + dp[i-1][j-1] + dp[i+1][j-1];
        }
      }
    }
    return dp[0][n];
  }
  public static void main(String[] args){
    System.out.println(solve(15));
    System.out.print(solveSpaceOptimized(15));
  }
}
