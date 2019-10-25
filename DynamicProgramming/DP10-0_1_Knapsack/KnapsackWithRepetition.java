import java.util.*;

public class KnapsackWithRepetition{

  public int solve(int[] items, int[] weights, int weight){
    int[] dp = new int[weight+1];
    dp[0] = 0;
    for(int i=0; i<=weight; i++){
      for(int j=0; j<items.length; j++){
        if(i+weights[j] > weight){
          continue;
        }
        dp[i+weights[j]] = Math.max(dp[i+weights[j]],dp[i] + items[j]);
      }
    }
    return dp[weight];
  }

  public static void main(String[] args){
    KnapsackWithRepetition k = new KnapsackWithRepetition();
    int[] items = new int[]{30,14,16,9};
    int[] weights = new int[]{6,3,4,2};
    System.out.println(k.solve(items,weights,10));
  }
}
