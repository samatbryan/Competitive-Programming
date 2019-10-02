class RatMaze{

  int[] dr = new int[]{0,1};
  int[] dc = new int[]{1,0};

  boolean validMove(int row, int col, int n){
    if(row>=n || col>=n){
      return false;
    }

    return true;
  }
  void printBoard(int[][] board, int n){
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(board[i][j]!=7){
          board[i][j] = 0;
        }
        System.out.print(board[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  boolean solve(int[][] board, int row, int col, int n){
    if(row == n-1 && col == n-1){
      printBoard(board, n);
      return true;
    }
    for(int i=0; i<2; i++){
      int newr = row + dr[i];
      int newc = col + dc[i];
      if(!validMove(newr,newc,n)){
        continue;
      }
      if(board[newr][newc]!=1){
        continue;
      }
      int tmpr = row;
      int tmpc = col;
      board[newr][newc] = 7;
      row = newr;
      col = newc;
      if(solve(board,newr,newc,n)){
          return true;
      }
      row = tmpr;
      col = tmpc;
      board[newr][newc] = 1;
    }
    return false;

  }
  public static void main(String[] args){
    int[][] board = new int[][]{  {1, 0, 0, 0},
                                  {1, 1, 0, 1},
                                  {0, 1, 0, 0},
                                  {1, 1, 1, 1}};
    RatMaze rm = new RatMaze();
    board[0][0] = 7;
    rm.solve(board, 0,0,4);


  }
}
