//Given a value N, if we want to make change for N cents,
//and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
//how many ways can we make the change? The order of coins doesn’t matter.
//For example, for N = 4 and S = {1,2,3}, there are four solutions:
//{1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
//For N = 10 and S = {2, 5, 3, 6}, there are five solutions:
//{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

public class Coinchange{


  public int solve(int[] coins, int value){


    int dp[][] = new int[value+1][coins.length];

    //row represents target amount
    //col represents up to the element of coins included
    // the value of dp represents the number of ways to get there
    dp[0][0]= 0;

    for(int i=0; i<coins.length; i++){
      dp[0][i] = 1;
    }

    for(int i=1; i<=value; i++){
      for(int j=0; j<coins.length; j++){
        int x =0;
        int y=0;

        if(i-coins[j]>=0){
          x = dp[i-coins[j]][j];
        }
        if(j>0){
          y = dp[i][j-1];

        }

        System.out.println(x+y);
        dp[i][j] = x+y;

      }

    }

    for(int i=0; i<=value; i++){
      for(int j=0; j<coins.length; j++){
        System.out.print(Integer.toString(i));
        System.out.print(" ");
        System.out.print(Integer.toString(j));
        System.out.print(" ");
        System.out.println( dp[i][j]);
      }
    }
    return dp[value][coins.length-1];
  }


  public static void main(String[] args){
    Coinchange c = new Coinchange();
    int[] coins = new int[]{2,3,5};
    System.out.println(c.solve(coins,5));

  }
}
