public class Bin{
/*
Following are common definition of Binomial Coefficients.

A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
A binomial coefficient C(n, k) also gives the number of ways, disregarding order,
that k objects can be chosen from among n objects; more formally,
the number of k-element subsets (or k-combinations) of an n-element set.

The Problem
Write a function that takes two parameters n and k and returns the value of
Binomial Coefficient C(n, k). For example, your function should return 6 for n = 4 and k = 2,
and it should return 10 for n = 5 and k = 2.

C(n, k) = C(n-1, k-1) + C(n-1, k)
C(n, 0) = C(n, n) = 1

*/

  public static int solve(int n, int k){
    if(k>n){
      return 0;
    }
    int[][] dp = new int[n+1][k+1];

    //base case is when n == k; 1
    //base case is when k ==0; = 1
    //base case is when n == 0; = 0
    for(int i=0; i<=k; i++){
      dp[i][i] = 1;
    }
    for(int i=0; i<=n; i++){
      dp[i][0] = 1;
    }
    for(int i=1; i<=n; i++){
      for(int p=1; p<=k; p++){
        dp[i][p] = dp[i-1][p] + dp[i-1][p-1];
      }
    }
    return dp[n][k];
  }
  public static void main(String[] args){
    System.out.print(solve(6,3));
  }
}
