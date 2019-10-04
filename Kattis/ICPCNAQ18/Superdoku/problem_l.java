import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.io.InputStream;
import java.util.HashMap;
public class problem_l{
  public static void main(String[] args) {
      InputStream inputStream = System.in;
      OutputStream outputStream = System.out;
      InputReader in = new InputReader(inputStream);
      OutputWriter out = new OutputWriter(outputStream);
      Solution solver = new Solution();
      //int testCount = Integer.parseInt(in.next());
      for (int i = 1; i <= 1; i++)
          solver.solve(i, in, out);
      out.close();
  }

  static class Solution {
      public boolean validMove(int[][] board, int row, int col, int val){
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

          return true;
      }
      public boolean mysolve(int[][] board, int fill){
          int n = board.length;
          for(int r=0; r<n; r++){
              for(int c=0; c<n; c++){

                  if(board[r][c]!=0){
                      continue;
                  }
                  for(int val=1; val<=n; val++){
                      if(validMove(board, r,c,val)){
                          board[r][c] = val;
                          if(mysolve(board,fill+1)){
                              return true;
                          }
                          board[r][c] = 0;
                      }
                  }
                  return false;


              }
          }
          return true;

      }
      public void solve(int testNumber, InputReader in, OutputWriter out) {
          int n = in.nextInt();
          int k = in.nextInt();
          int[][] board = new int[n][n];
          HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

          for(int r=0; r<k; r++){
            hm = new HashMap<Integer,Integer>();
            for(int c=0; c<n; c++){
              board[r][c] = in.nextInt();
              if(hm.containsKey(board[r][c])){
                out.printf("no");
                return;
              }
              hm.put(board[r][c],1);
            }
          }
          for(int i=0; i<n; i++){
            hm = new HashMap<Integer,Integer>();
            for(int j=k-1; j>=0; j--){
              if(hm.containsKey(board[j][i])){
                out.printf("no");
                return;
              }
              hm.put(board[j][i],1);
            }
          }
          boolean b = mysolve(board, k*n);
          if(b){
            out.printf("yes");
            out.printf("\n");
            for(int i=0; i<n; i++){
              for(int j=0; j<n; j++){
                out.printf(String.valueOf(board[i][j]));
                out.printf(" ");
              }
              out.printf("\n");
            }
          }
          else{
            out.printf("no");
          }






          //out.printf("Case #%d: %s\n", testNumber, new String(ans));
      }

  }















  // REST IS INPUT/OUT
  static class InputReader {
      private InputStream stream;
      private byte[] buf = new byte[1 << 16];
      private int curChar;
      private int numChars;

      public InputReader(InputStream stream) {
          this.stream = stream;
      }

      public int read() {
          if (this.numChars == -1) {
              throw new InputMismatchException();
          } else {
              if (this.curChar >= this.numChars) {
                  this.curChar = 0;

                  try {
                      this.numChars = this.stream.read(this.buf);
                  } catch (IOException var2) {
                      throw new InputMismatchException();
                  }

                  if (this.numChars <= 0) {
                      return -1;
                  }
              }

              return this.buf[this.curChar++];
          }
      }

      public int nextInt() {
          int c;
          for (c = this.read(); isSpaceChar(c); c = this.read()) {
              ;
          }

          byte sgn = 1;
          if (c == 45) {
              sgn = -1;
              c = this.read();
          }

          int res = 0;

          while (c >= 48 && c <= 57) {
              res *= 10;
              res += c - 48;
              c = this.read();
              if (isSpaceChar(c)) {
                  return res * sgn;
              }
          }

          throw new InputMismatchException();
      }

      public String next() {
          int c;
          while (isSpaceChar(c = this.read())) {
              ;
          }

          StringBuilder result = new StringBuilder();
          result.appendCodePoint(c);

          while (!isSpaceChar(c = this.read())) {
              result.appendCodePoint(c);
          }

          return result.toString();
      }

      public static boolean isSpaceChar(int c) {
          return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
      }

  }

  static class OutputWriter {
      private final PrintWriter writer;

      public OutputWriter(OutputStream outputStream) {
          writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
      }

      public OutputWriter(Writer writer) {
          this.writer = new PrintWriter(writer);
      }

      public void printf(String format, Object... objects) {
          writer.printf(format, objects);
      }

      public void close() {
          writer.close();
      }

  }
}
