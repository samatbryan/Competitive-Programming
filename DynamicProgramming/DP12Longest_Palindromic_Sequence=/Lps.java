/*

Given a sequence, find the length of the longest palindromic subsequence in it.

As another example, if the given sequence is “BBABCBCAB”,
then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
 “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.


GEEKSFORGEEKS
EEKEE
EESEE
EEFEE


Recursive step: T(i,j) = Math.max( T(i+1, j-1) + 2)
                      else, Max(T(i+1, j) , T(i,j-1) else).
*/

public class Lps{

  public static int solve(String s){
    int n = s.length();
    int[][] dp = new int[n][n];
    // we will iterate by length and then return dp[0][n-1];

    //base case is length 1 string.
    for(int i=0; i<n; i++){
      dp[i][i] = 1;
    }

    for(int L=2; L<=n; L++){
      for(int i=0; i<=n-L; i++){
        if(s.charAt(i) == s.charAt(i+L-1)){
          dp[i][i+L-1] = 2 + dp[i+1][i+L-2];
        }
        else{
          dp[i][i+L-1] = Math.max(dp[i+1][i+L-1] , dp[i][i+L-2]);
        }
      }
    }

    for(int i=0; i<n; i++){
      for(int j=i; j<n; j++){
        System.out.print(dp[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
    return dp[0][n-1];
  }
  public static void main(String[] args){
    String s = "GEEKSFORGEEKS";
    System.out.print(solve(s));

  }
}
