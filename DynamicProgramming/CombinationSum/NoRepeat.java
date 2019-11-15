public class NoRepeat{
  public static boolean solution(int[] weights, int target){
    // return minimum number of coins to get to target
    int n = weights.length;
    boolean[][] dp = new boolean[target+1][n+1];

    //boolean[][] dp = new boolean[weights.length+1][target+1];
    for(int i=0; i<=weights.length; i++){
      dp[0][i] = true;
    }
/*
    for(int i=1; i<=n; i++){
      for(int j=1; j<=target; j++){
          if(j-weights[i-1]<0){
            dp[i][j] = dp[i-1][j];
          }
          else{
            dp[i][j] = dp[i-1][j-weights[i-1]] || dp[i-1][j];
          }
      }
    }
*/

    for(int i=1; i<=target; i++){
      for(int j=1; j<=n; j++){
        if(i-weights[j-1]<0){
          dp[i][j] = dp[i][j-1];
        }

        else{
          dp[i][j] = dp[i][j-1] || dp[i-weights[j-1]][j-1];
        }
      }
    }

    for(int i=0; i<=target; i++){
      System.out.print("target: ");
      System.out.print(i);
      for(int j=0; j<=n; j++){
        System.out.print(dp[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }

    return dp[target][weights.length];
  //  return dp[weights.length][target];

  }
  public static void main(String[] args){
    int[] weights = new int[]{1,2};
    System.out.print(solution(weights, 4));
  }
}
