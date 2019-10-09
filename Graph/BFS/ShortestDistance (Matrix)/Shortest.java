import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;
public class Shortest{
  int[] dr = new int[]{1,-1,0,0};
  int[] dc = new int[]{0,0,1,-1};

  public boolean validMove(int r, int c, int maxR, int maxC){
    if(r<0 || c<0 || r>maxR || c>maxC){
      return false;
    }
    return true;
  }

  public int solve(int[][] board, int sourceRow, int sourceCol, int destRow, int destCol){
    Shortest.Node source =  new Shortest.Node(sourceRow, sourceCol, 0);
    Queue<Shortest.Node> q = new ArrayDeque<Shortest.Node>();

    Boolean[][] visited = new Boolean[board.length][board[0].length];
    for(int i=0; i<board.length; i++){
      for(int j=0; j<board[0].length; j++){
        visited[i][j] = false;
      }
    }
    q.add(source);
    visited[source.row][source.col] = true;

    while(!q.isEmpty()){
      Shortest.Node item = q.poll();

      if(board[item.row][item.col] == 2){
        return item.dist;
      }
      for(int i=0; i<4; i++){
        int newR = item.row + dr[i];
        int newC = item.col + dc[i];
        if(validMove(newR, newC, board.length-1, board[0].length -1)){
          if(visited[newR][newC]){
            continue;
          }
          Shortest.Node neighbor = new Shortest.Node(newR, newC, item.dist+1);
          q.add(neighbor);
          visited[newR][newC] = true;
        }
      }
    }
    return -1;



  }

  static class Node{
    int row;
    int col;
    int dist;

    public Node(int row, int col, int dist){
      this.row = row;
      this.col = col;
      this.dist = dist;
    }
  }
  public static void public static void main(String[] args) {

  }(String[] args){
    Shortest s = new Shortest();
    int[][] board = new int[][]{
      {0,0,0},
      {0,0,0},
      {0,2,0}
    };
    System.out.println(s.solve(board, 2,2, 0,0));

  }

}
