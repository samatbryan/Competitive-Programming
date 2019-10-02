class Knight_Tour {


  int[] dr = new int[]{-2, -2, -1, -1, 2, 2, 1, 1};
  int[] dc = new int[]{-1,  1, -2,  2, 1,-1, 2,-2};
  int count =0;
  boolean bounds(int row, int col, int n){
    if(row<0 || col <0 || row>=n || col>=n){
      return false;
    }
    return true;
  }

  boolean backtrack(int[][] board, int row, int col, int n, int visited){
    boolean possible = false;
    if(visited>n*n){
      return false;
    }
    if(visited == n*n){
      count+=1;

      for(int i=0; i<board.length; i++){
        for(int j=0; j<board[i].length; j++){
          System.out.print(board[i][j]);
          System.out.print(" ");
        }
        System.out.println();
      }
      System.out.println();

      return true;
    }

    for(int i=0; i<8; i++){
      int newr = row+dr[i];
      int newc = col+dc[i];
      if(!bounds(newr,newc,n)){
        continue;
      }
      if(board[newr][newc] != -1){
        continue;
      }
      possible = true;
      board[newr][newc] = visited;
      if(backtrack(board, newr, newc, n, visited+1)){
        return true;
      }
      board[newr][newc] = -1;

    }
    return false;

  }

  int[][] solve(int n){
    int[][] board = new int[n][n];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        board[i][j]= -1;
      }
    }
    board[0][0] = 0;
    backtrack(board, 0,0, n, 1);
    return board;
  }



  public static void main(String[] args){
    Knight_Tour k = new Knight_Tour();
    int[][] l = k.solve(8);
    for(int i=0; i<l.length; i++){
      for(int j=0; j<l[i].length; j++){
        System.out.print(l[i][j]);
      }
      System.out.println();
    }


  }
}
