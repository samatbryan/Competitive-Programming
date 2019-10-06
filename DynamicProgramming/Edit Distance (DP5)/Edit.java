public class Edit{
  public int solve(String a, String b){
    int m = a.length();
    int n = b.length();
    int[][] dp = new int[m+1][n+1];

    for(int i=0; i<=m; i++){
      dp[i][0] = i;
    }
    for(int i=0; i<=n; i++){
      dp[0][i] = i;
    }
    for(int i=1; i<=m; i++){
      for(int j=1; j<=n; j++){
        if(a.charAt(i-1) == b.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1];
        }
        else{
          dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
        }
      }
    }
    return dp[m][n];
  }


  public static void main(String[] args){
    Edit e = new Edit();
    String a =  "h";
    String b = "gesek";
    // return 1;
    System.out.println(e.solve(a,b));

  }
}
