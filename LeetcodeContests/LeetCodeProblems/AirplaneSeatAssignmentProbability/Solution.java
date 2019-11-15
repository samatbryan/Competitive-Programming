/*
Medium

n passengers board an airplane with exactly n seats. The first passenger has lost the ticket and picks a seat randomly. But after that, the rest of passengers will:

Take their own seat if it is still available,
Pick other seats randomly when they find their seat occupied
What is the probability that the n-th person can get his own seat?



*/

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        //smaller cases
        // n=1: 1.00
        // n=2: 1/2(1)
        // n=3: 1/3(1) + 1/3(n==2)
        // n=4: 1/4(1) + 1/4(n==3) + 1/4(n==2)
        // n=5: 1/5(1) + 1/5(n==4) + 1/5(n==3) + 1/5(n==2)


        // n=1: 1.00
        // n=2: 1.00
        // n=3: 1.00 + n=2 = 2
        // n=4: 1 + 2 + 1 = 4
        // n=5: 1 + 4 + 2 + 1 = 8
        // n=6: 1 + 8 + 4 + 2 + 1 = 16
        // n=7: 1 + 16 + 8 + 4 + 2 + 1 = 32

        // n==k: 1 + (k-1) + (k-2) + ... (2)
        double[] dp = new double[n+1];
        dp[1] = 1;
        if(n==1){
            return 1;
        }
        dp[2] = 1.0/2.0;

        double runningSum = dp[2];
        for(int i=3; i<=n; i++){
            dp[i] = (runningSum + 1) / i;
            runningSum += dp[i];
        }
        return dp[n];
    }
}
