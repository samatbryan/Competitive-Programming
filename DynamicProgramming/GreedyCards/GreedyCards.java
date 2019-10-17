public class GreedyCards{

/*
Ning and Evan are playing a game, where there are n cards in a line. The cards are all face-up (so
they can both see all cards in the line) and numbered 2–9. Ning and Evan take turns. Whoever’s
turn it is can take one cardsfrom either the right end or the left end of the line. The goal for each
player is to maximize the sum of the cards they’ve collected
*/
  public static int greedy(int[] cards){
    // assume n is even
    // assume Evan goes first, and we want max score of Evan
    // we will always take the last card.
    int n = cards.length;
    int[][] dp = new int[n][n];
    for(int i=0; i<n; i++){
      dp[i][i] = cards[i];
    }
    for(int i=0; i<=n-2; i++){
      dp[i][i+1] = Math.max(cards[i],cards[i+1]);
    }


    for(int L = 3; L<=n; L++){
      for(int i=0; i<=n-L; i++){
        int leftmaximum = -1;
        int rightmaximum = -1;

        //say our player took left cardsand opponent takes greedy left
        if(cards[i+1]>cards[i+L-1]){
          leftmaximum = cards[i] + dp[i+2][i+L-1];
        }
        //say our player took left cardsand opponent takes greedy right

        if(cards[i+1]<cards[i+L-1]){
          leftmaximum = cards[i] + dp[i+1][i+L-2];
        }
        if(cards[i+1]==cards[i+L-1]){
          leftmaximum = cards[i] + dp[i+2][i+L-1];
        }
        //say our player took right cardsand opponent took greedy right
        if(cards[i]>cards[i+L-2]){
          rightmaximum = cards[i+L-1] + dp[i][i+L-3];
        }

        //say our player took right cardsand opponent took greedy left
        if(cards[i]<cards[i+L-2]){
          rightmaximum = cards[i+L-1] + dp[i+1][i+L-2];
        }
        if(cards[i]==cards[i+L-2]){
          rightmaximum = cards[i+L-1] + dp[i+1][i+L-2];
        }
        dp[i][i+L-1] = Math.max(leftmaximum,rightmaximum);
              //take first card


      }
    }
    return dp[0][n-1];


  }
  public static void main(String[] args){
    int arr1[] = { 8, 15, 3, 7 };
    int arr2[] = { 2, 2, 2, 2 };
    int arr3[] = { 20, 30, 2, 2, 2, 10 };

    System.out.println(greedy(arr1));
    System.out.println(greedy(arr2));
    System.out.println(greedy(arr3));

  }
}
