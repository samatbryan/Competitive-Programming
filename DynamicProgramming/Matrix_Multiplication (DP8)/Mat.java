public class Mat{
/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together.
The problem is not actually to perform the multiplications,
but merely to decide in which order to perform the multiplications.

We have many options to multiply a chain of matrices because matrix multiplication is associative.
In other words, no matter how we parenthesize the product, the result will be the same.
*/

/*
input: Given an array p[] which represents the chain of matrices such
that the ith matrix Ai is of dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder()
that should return the minimum number of multiplications needed to multiply the chain.

*/
  public int solve(int p[], int n){
    int[][] dp = new int[n+1][n+1];
    for(int i=0; i<=n; i++){
      dp[i][i] = 0;
    }
    for(int L = 2; L<=n; L++){
      for(int i=0; i<n-l; i++){
        for(int pivot )
      }
    }
    //split by lengths. Do DP on lengths.
  }
}
