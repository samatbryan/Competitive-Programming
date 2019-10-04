class N_Queens {
    List<List<String>> res = new ArrayList<List<String>>();

    public void addToRes(int[][] board){
        List<String> add1 = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board.length; i++){
            sb = new StringBuilder();
            for(int j=0; j<board.length; j++){
                if(board[i][j] ==0){
                    sb.append(".");
                }
                else{
                    sb.append("Q");
                }
            }
            add1.add(sb.toString());
        }
        res.add(add1);
    }
    public boolean isSafe(int[][]board, int col, int row){
        int i,j;
        for(i=0; i<col; i++){
          if(board[row][i]==1){
            return false;
          }
        }
        // ul diagonal
        i=row-1;
        j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j] ==1){
                return false;
            }
            i-=1;
            j-=1;
        }
        i=row+1;
        j=col-1;
        while(i<board.length && j>=0){
            if(board[i][j]==1){
            return false;
          }
            i+=1;
            j-=1;
        }

        return true;
    }
    public void NQueens(int[][] board, int col, int n){
        if( col>=n){
            addToRes(board);
        }
        else{
            for(int i=0; i<n; i++){
                if(!isSafe(board, col, i)){
                    continue;
                }
                board[i][col] = 1;
                NQueens(board, col+1, n);
                board[i][col] = 0;

            }

        }
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        NQueens(board, 0, n);
        return res;
    }
}
