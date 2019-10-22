public class Knightdialpad{
  static int[] dr = new int[]{1,1,-1,-1,2,2,-2,-2};
  static int[] dc = new int[]{2,-2,2,-2,1,-1,1,-1};

  public static int[] getNeighbors(int position){
    switch(position){
      case 0:
        int[] res = new int[]{4,6};
        return res;
      case 1:
        int[] res = new int[]{6,8};
        return res;
      case 2:
        int[] res = new int[]{7,9};
        return res;
      case 3:
        int[] res = new int[]{4,8};
        return res;
      case 4:
        int[] res = new int[]{3,9,0};
        return res;
      case 5:
        int[] res = new int[];
        return res;
      case 6:
        int[] res = new int[]{0,7,1};
        return res;
      case 7:
        int[] res = new int[]{2,6};
        return res;
      case 8:
        int[] res = new int[]{1,3};
        return res;
      case 9:
        int[] res = new int[]{4,2};
        return res;
    }
  }

  public static int solve(int N, int starting){
    int dp[][] = new int[N+1][10];
    for(int i=0; i<=9; i++){
      dp[0][i] = 1;
    }
  }
}
