public class Coinchange{

  public int solve(int[] arr, int target){
    int[] dp = new int[target+1];
    dp[0] = 0;
    for(int j=1; j<=target; j++){
      dp[j] = Integer.MAX_VALUE;
    }

    for(int i=0; i<target; i++){
      for(int j=0; j<arr.length; j++){
        if(i+arr[j] <= target){
          dp[i+arr[j]] = Math.min(dp[i+arr[j]], dp[i]+1);
        }
      }
    }
    return   dp[target];

  }
  public static void main(String[] args){
    int[] arr = new int[]{1,2,5,10,20,50,100};
    Coinchange c = new Coinchange();
    System.out.println(c.solve(arr, 9));

  }
}
