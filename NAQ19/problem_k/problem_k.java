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
public class problem_k{
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
      public void solve(int testNumber, InputReader in, OutputWriter out) {

          int done[] = new int[26];
          String s = in.next();
          int a[] = new int[26];
          int res = 0;
          int n = s.length();
          StringBuilder sb = new StringBuilder();
          for(int i=0; i<n; i++){
            if(done[s.charAt(i) - 'a'] == 0){
              sb = new StringBuilder();
              int dist_count =0;
              Arrays.fill(a, 0);

              for(int j=i; j<n; j++){
                if(a[s.charAt(j) - 'a'] ==0){
                  sb.append(s.charAt(j));
                  dist_count++;
                  if(dist_count>1){
                    System.out.println(sb.toString());
                    res ++;
                  }
                }
                a[s.charAt(j) -'a']++;
              }
              done[s.charAt(i) - 'a'] +=1;
            }



          }

          out.printf(Integer.toString(res));
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
