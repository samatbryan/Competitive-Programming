public class Repeat{
  public static boolean solve(int[] weights, int target){
    boolean[] dp = new boolean[target+1];
    dp[0] = true;
    for(int i=0; i<=target; i++){
      for(int j=0; j<weights.length; j++){
        if(i+weights[j] <= target){
          dp[i + weights[j]] = dp[i+weights[j]] || dp[i];

        }
      }
    }
    return dp[target];


  }
  public static void main(String[] args){
    int[] weights = new int[]{3,2};

    System.out.print(solve(weights, 11));

  }
}
