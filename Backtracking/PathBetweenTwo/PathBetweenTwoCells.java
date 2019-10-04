public class PathBetweenTwoCells{


  int sX;
  int sY;
  int dX;
  int dY;

  int[] dr = new int[]{0,  0, 1, -1};
  int[] dc = new int[]{1, -1, 0,  0};

  static boolean flag = false;

  public boolean possible(int row, int col, int boundX, int boundY){
    if(row>boundX || col>boundY || col<0 || row <0){
      return false;
    }
    return true;
  }

  public void backtrack(int[][] maze, int sourceX, int sourceY, int destX, int destY, int row, int col){
    if(flag){
      return;
    }
    if(row==destX && col == destY){
      flag = true;
      return;
    }
    for(int i=0; i<4; i++){

      if(possible(row+dr[i],col+dc[i],maze.length-1, maze[0].length-1) && maze[row+dr[i]][col+dc[i]]==0){
        maze[row+dr[i]][col+dc[i]] = -1;
        backtrack(maze,sX,sY, dX, dY, row + dr[i], col + dc[i]);

      }
    }
  }

  public void solve(int[][] maze, int sourceX, int sourceY, int destX, int destY){
    sX = sourceX;
    sY = sourceY;
    dX = destX;
    dY = destY;

    maze[sX][sY] = -1;
    backtrack(maze,sX, sY, dX, dY, sX, sY);
  }



  public static void main(String[] args){
    int[][] maze = new int[][]{
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0}
        };
    PathBetweenTwoCells p = new PathBetweenTwoCells();

    p.solve(maze, 0, 0, 0,1);
    for(int i=0; i<4;i++){
      for(int j=0; j<5; j++){
        System.out.print(maze[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
    if(flag){
      System.out.println("true");
    }
    else{
      System.out.println("false");
    }
  }
}
