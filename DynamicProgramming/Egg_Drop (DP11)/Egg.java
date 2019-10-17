public class Egg{

/*
The following is a description of the instance of this famous puzzle involving n=2 eggs
and a building with k=36 floors.

Suppose that we wish to know which stories in a 36-story building are safe
to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result,
the experiment can be carried out in only one way. Drop the egg from the first-floor window;
if it survives, drop it from the second floor window. Continue upward until it breaks.
In the worst case, this method may require 36 droppings. Suppose 2 eggs are available.

What is the least number of egg-droppings that is guaranteed to work in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which
eggs should be dropped so that total number of trials are minimized
*/
static int eggDrop(int floor, int egg){
  int[][]dp = new int[floor+1][egg+1];
  for(int i=0; i<=egg; i++){
    dp[0][i] = 0;
    dp[1][i] = 1;
  }
  for(int i=0; i<=floor; i++){
    dp[i][1] = i;
  }


  for(int i=2; i<=floor; i++){
    for(int j=2; j<=egg; j++){
      int minimum = Integer.MAX_VALUE;

      // we can drop from floor 1, floor 2, floor ...
      for(int f=1; f<=i; f++){
        // if we drop from floor x and it breaks, then we have f-1 floors left and j-1 eggs;
        // if we drop from floor x and it doesnt break, then we only have i-f eggs left and still j eggs;
        // get the worst case of those two, and add one drop.
        int maximum = 1 + Math.max(dp[f-1][j-1], dp[i-f][j]);
        //System.out.println(maximum);
        if(maximum<minimum){
          minimum = maximum;
        }
      }
      dp[i][j] = minimum;
    }
  }
  for(int i=0; i<=floor; i++){
    for(int j=0; j<=egg; j++){
      System.out.print(dp[i][j]);
      System.out.print(" ");
    }
    System.out.println();
  }
  return dp[floor][egg];

}
public static void main(String[] args){
  System.out.println(eggDrop(36,2));
}


}
