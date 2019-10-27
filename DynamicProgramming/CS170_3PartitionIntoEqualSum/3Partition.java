/*
Goal is to partition a set into three disjoint sets such that each set has sum n/3;
Return a true or false;

We can solve this by doing dp of 2 set.
We will have

dp[i][j][k] where i represents sum of set 1, j represents sum of set 2, k represents the number of elements from 1 to k
base case is when k = 0;
Then for i,j, dp[i][j][0] = false;
for i=j=0, dp[i][j][0] = true

for dp[i][j][k] = dp[i-arr[k]][j][k-1] v dp[i][j-arr[k]][k-1] v [dp][i][j][k];

return dp[n/3][n/3][n];
*/
