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
public class Peg_Game_For_Two{
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
      public int[] dr = new int[]{-1,1,1,-1,0,0};
      public int[] dc = new int[]{-1,1,0,0,-1,1};

      static boolean valid(int r, int c){
        if(c<0 || r<0 || r>4 || c>r){
          return false;
        }
        return true;
      }

      int backtrack(int[][] board, boolean player){
        boolean possible = false;

        int bestScore = Integer.MAX_VALUE;
        if(player){
          bestScore = Integer.MIN_VALUE;
        }

        for(int r=0; r<5; r++){
          for(int c=0; c<=r; c++){

            if(board[r][c] ==0){
              continue;
            }
            for(int k=0; k<6; k++){
              if(!valid(r+2*dr[k],c+2*dc[k])){
                continue;
              }
              if(board[r+2*dr[k]][c+2*dc[k]]!=0){
                continue;
              }
              if(board[r+dr[k]][c+dc[k]] ==0 ){
                continue;
              }
              possible = true;

              board[r+2*dr[k]][c+2*dc[k]] = board[r][c];
              int temp = board[r+dr[k]][c+dc[k]];
              board[r][c] = 0;
              board[r+dr[k]][c+dc[k]] = 0;

              if(player){
                bestScore = Math.max(bestScore, temp*board[r+2*dr[k]][c+2*dc[k]] + backtrack(board,!player));
              }
              else{
                bestScore = Math.min(bestScore, -temp*board[r+2*dr[k]][c+2*dc[k]] + backtrack(board,!player));
              }
              board[r][c] = board[r+2*dr[k]][c+2*dc[k]];
              board[r+2*dr[k]][c+2*dc[k]] = 0;
              board[r+dr[k]][c+dc[k]] = temp;

            }
          }
        }


        if(!possible){
          return 0;
        }
        return bestScore;
      }

      public void solve(int testNumber, InputReader in, OutputWriter out) {
          // initialize matrix with -1's.
          int[][] a = new int[5][];
          for(int i=1; i<=5; i++){
            a[i-1] = new int[i];
            for(int p=0; p<i; p++){
              a[i-1][p] = in.nextInt();
            }
          }
          int res = backtrack(a,true);

          out.printf(res + "");
          }

            //out.printf("Case #%d: %s\n", testNumber, new String(ans));
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
