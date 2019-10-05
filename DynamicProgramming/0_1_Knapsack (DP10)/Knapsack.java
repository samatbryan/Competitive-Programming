public class Knapsack{

  public int solve(int[] weights, int[] values, int weight){
    int n = values.length;
    int dp[][] = new int[n+1][weight+1];

    for(int i=0; i<=weight; i++){
      dp[0][i] = 0;
    }
    for(int i=0; i<=n; i++){
      dp[i][0] = 0;
    }

    for(int i=1; i<=n; i++){ // which item
      for(int j=1; j<=weight; j++){ // total weight
        if(weights[i-1]>j){
          dp[i][j] = dp[i-1][j]; //cant put item i in there.
        }
        else{
          dp[i][j] = Math.max(dp[i-1][j-weights[i-1]] + values[i-1], dp[i-1][j]);
        }

      }
    }
    return dp[n][weight];



  }
  public static void main(String[] args){
    Knapsack k = new Knapsack();
    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int  W = 50;
    System.out.println(k.solve(wt,val,W));
  }
}
