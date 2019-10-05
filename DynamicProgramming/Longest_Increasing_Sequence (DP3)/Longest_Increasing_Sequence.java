class Longest_Increasing_Sequence{

  public int lis(int[] nums){
      int max = 1;
      int[] dp = new int[nums.length];

      for(int i=0; i<nums.length; i++){
        dp[i] = 1;
      }
      for(int i=nums.length-2; i>=0; i--){
        for(int j=i+1; j<nums.length; j++){
          if(nums[i]<nums[j]){
            dp[i] = Math.max(dp[i],dp[j]+1);
            if(dp[i]>max){
              max = dp[i];
            }
          }
        }
      }
      //System.out.println(dp[0]);
      return max;

  }
  public static void main(String[] args){
    Longest_Increasing_Sequence l = new Longest_Increasing_Sequence();
    int[] a = new int[]{50, 3, 10, 7, 40, 80};
    System.out.println(l.lis(a));
  }
}
