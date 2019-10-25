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
  public static int solve(int p[], int n){
    int[][] dp = new int[n][n];
    for(int i=0; i<n; i++){
      dp[i][i] = 0;
    }

    for(int L=2; L<=n; L++){
      for(int i=0; i<=n-L; i++){
        int min = Integer.MAX_VALUE;
        for(int j=i; j<i+L-1; j++){
          if(dp[i][j] + dp[j+1][i+L-1] + p[i]*p[j]*p[i+L-1] < min){
            min =dp[i][j] + dp[j][i+L-1] + p[i]*p[j]*p[i+L-1];
          }
        }

        dp[i][i+L-1] = min;
      }
    }
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        System.out.print(dp[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }

    return dp[0][n-1];
    //split by lengths. Do DP on lengths.
  }
  public static void main(String[] args){
    int arr[] = new int[] {5, 2, 3, 4};
    int size = arr.length;
    System.out.print(solve(arr, size));

  }
}
