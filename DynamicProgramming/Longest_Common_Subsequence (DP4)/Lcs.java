public class Lcs{

  public int solve(String a, String b){
    int m = a.length();
    int n = b.length();

    // represents the longest common substring of length of each substring.
    int dp[][] = new int[m+1][n+1];

    for(int i=0; i<=n; i++){
      dp[0][i] = 0;
    }
    for(int i=0; i<=m; i++){
      dp[i][0] = 0;
    }


    for(int i=1; i<=m; i++){
      for(int j=1; j<=n; j++){
        // if the last character of both matches
        // then theres 1 + matching of the prev two strings
        if(a.charAt(i-1) == b.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1] + 1;
        }
        else{
          // if they dont match, the longest is the two options
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return dp[m][n];

  }
  public static void main(String[] args){
    Lcs l = new Lcs();
    String a = "AGGTAB";
    String b = "GXTXAYB";
    System.out.println(l.solve(a,b));
  }
}
