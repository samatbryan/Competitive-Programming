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
public class problem_j{
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
      static int move(int[][] a, int row, int col){
        int value = 0;
        int maximum = 0;
        if(a[row][col]==0){
          return 0;
        }
        int newrow = row;
        int newcol = col;
        int nnrow = row;
        int nncol = col;
        //upright
        if(row-2>=0){
          if(a[row-2][col] ==0){
            value = a[row][col] * a[row-1][col];
            if(value>maximum){
              maximum = value;
              newrow = row-1;
              nnrow = row-2;

            }
          }
        }

        //downleft
        if(row+2<5){
          if(a[row+2][col] ==0){
            value = a[row][col] * a[row+2][col];
            if(value>maximum){
              maximum = value;
              newrow = row+2;

            }
          }
        }
        //downright
        if(row+2<5 && col+2<5){
          if(a[row+2][col+2] ==0){
            value = a[row][col] * a[row+2][col+2];
            if(value>maximum){
              maximum = value;
              newrow = row-2;
              newcol = col +2;

            }
          }
        }

        //upleft
        if(row-2>=0 && col-2>=0){
          if(a[row-2][col-2] ==0){
            value = a[row][col] * a[row-1][col-1];
            if(value>maximum){
              maximum = value;
              newrow = row-2;

            }
          }
        }

        //left
        if(col-2>=0){
          if(a[row][col-2] ==0){

          }
        }
        //right
        if(col+2<5){
          if(a[row][col+2] ==0){

          }
        }

        a[newrow][newcol] = 0;
        a[nnrow][nncol] = a[row][col];
        a[row][col] = 0;
        
        return value;
      }
      public void solve(int testNumber, InputReader in, OutputWriter out) {
          int[][] arr  = new int[5][5];
          int num_holes = 1;
          int res = 0;
          // initialize matrix with -1's.
          for(int i=1; i<=5; i++){
            for(int j=1; j<=5; j++){
              arr[i][j] = -1;
            }
          }

          for(int i=1; i<=5; i++){
            for(int j=0; j<i; j++){
              int val = in.nextInt();
              arr[i-1][j] = val;
            }
          }
          while(num_holes<15){
            int maxx = 0;
            for(int y=0; y<5; y++){
              for(int t=0; t<5; t++){
                if(arr[y][t]==0){
                  int val = move(arr,y,t);
                  if(val>maxx){
                    maxx = val;
                  }
                }
              }
            }
            res += maxx;
            alternate *=-1;

            num_holes +=1;

          }

          for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
              System.out.print(arr[i][j]);
            }
            System.out.println();
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
