public class Mincostpath{
/*
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a
function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 Each cell of the matrix represents a cost to traverse through that cell.
 Total cost of a path to reach (m, n) is sum of all the costs on that path (
 including both source and destination). You can only traverse down, right and
 diagonally lower cells from a given cell, i.e., from a given cell (i, j), cell
 s (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all c
 osts are positive integers.

*/
  public int solve(int[][] maze){
    int n = maze.length;
    int m = maze[0].length;
    int[][] dp = new int[n][m];

    dp[n-1][m-1] = maze[n-1][m-1];

    for(int i=m-2; i>=0; i--){
      dp[n-1][i] = maze[n-1][i] + dp[n-1][i+1];
    }

    for(int i=n-2; i>=0; i--){
      dp[i][m-1] = maze[i][m-1] + dp[i+1][m-1];
    }

    for(int i = m-2; i>=0; i--){
      for(int j= n-2; j>=0; j--){
        dp[i][j] = maze[i][j] +
                  Math.min(dp[i+1][j], Math.min(dp[i][j+1],dp[i+1][j+1]));
      }
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        System.out.print(dp[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
    return dp[0][0];

  }
  public static void main(String[] args){
    Mincostpath m = new Mincostpath();
    int[][] maze = new int[][]{
      {1, 2, 3},
      {4, 8, 2},
      {1, 5, 3}
    };
    System.out.println(m.solve(maze));

  }
}
