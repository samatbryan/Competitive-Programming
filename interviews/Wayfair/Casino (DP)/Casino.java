// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, int K) {
        // write your code in Java SE 8
        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<=K; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<=N; i++){
            dp[i][0] = i-1;
        }
        for(int i=0; i<=K; i++){
            dp[1][i] = 0;
        }

        dp[0][0] = 0;
        for(int i=2; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(i%2 ==0){
                    dp[i][j] = Math.min(dp[i-1][j] +1, dp[i/2][j-1] + 1);
                }
                else{
                    dp[i][j] = dp[i-1][j] + 1;

                }
            }
        }

        /*
        for(int i=0; i<=N; i++){
            for(int j=0; j<=K; j++){
                System.out.print("N ");
                System.out.print(Integer.toString(i));
                System.out.print(" ");
                System.out.print("K ");
                System.out.print(Integer.toString(j));
                System.out.print(" ");
                System.out.print(dp[i][j]);
                System.out.println();
            }
        }
        */
        return dp[N][K];
    }
}
