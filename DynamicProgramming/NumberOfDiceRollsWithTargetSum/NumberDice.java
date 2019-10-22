/*
You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7
to roll the dice so the sum of the face up numbers equals target.

*/

class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        // dp table of number of dice we have and the target sum
        // value = number of ways;


        int[][] dp = new int[d+1][Math.max(f+1,target+1)];

        // base case: if we have 0 dice, then we cant get any target value.
        for(int i=0; i<=target; i++){
            dp[0][i] = 1;
        }
        // base case: we cant get the target 0.
        for(int i=0; i<=d; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=f; i++){
            dp[1][i] = 1;
        }
        // recursive step: dp[i+1][target + f] = dp[i][target];

        int modT = (int) Math.pow(10,9) + 7;
        for(int i=1; i<d; i++){
            for(int j=1; j<=target; j++){
                for(int k=1; k<=f; k++){
                    if(i+1<=d && j+k<=target){
                                // dp table of number of dice we have and the                                           targetsum
                    // value = number of ways;
                        dp[i+1][j+k] = dp[i+1][j+k] % modT;
                        dp[i+1][j + k] += dp[i][j] % modT;
                    }
                }
            }
        }

        return dp[d][target] % modT;

    }
}
