class Solution {

    char[] values = new char[]{'1','2','3','4','5','6','7','8','9'};
    public boolean validMove(char[][] board, int row, int col, char val){
        for(int i=0; i<col; i++){
            if(board[row][i] == val){
                return false;
            }
        }
        for(int i=0; i<row; i++){
            if(board[i][col] == val){
                return false;
            }
        }

        int k = (row/3)*3;
        int l = (col/3)*3;
        for(int i =k; i<k+3; i++){
            for(int j=l; j<l+3; j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }


        return true;
    }
    public boolean solve(char[][] board, int fill){
        int n = board.length;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){

                if(board[r][c]!='.'){
                    continue;
                }
                for(int val=0; val<=8; val++){
                    char v = values[val];
                    if(validMove(board, r,c,v)){
                        board[r][c] = v;
                        if(solve(board,fill+1)){
                            return true;
                        }
                        board[r][c] = '.';
                    }
                }
                return false;


            }
        }
        return true;

    }
    public void solveSudoku(char[][] board) {
        solve(board, 1);
    }
    public static void main(String[] args){
      Solution s = new Solution();
      char[][] inpu = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                                  {'6','.','.','1','9','5','.','.','.'},
                                  {'.','9','8','.','.','.','.','6','.'},
                                  {'8','.','.','.','6','.','.','.','3'},
                                  {'4','.','.','8','.','3','.','.','1'},
                                  {'7','.','.','.','2','.','.','.','6'},
                                  {'.','6','.','.','.','.','2','8','.'},
                                  {'.','.','.','4','1','9','.','.','5'},
                                  {'.','.','.','.','8','.','.','7','9'}};
      s.solve(inpu,1);
      for(int i=0; i<inpu.length; i++){
        for(int j=0; j<inpu[i].length; j++){
          System.out.print(inpu[i][j]);
          System.out.print("   ");
        }
        System.out.println();
      }


    }
}
