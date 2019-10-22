
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
import java.util.HashSet;
import java.math.BigInteger;

class OfficeTime{
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
        int n = in.nextInt();
        int m = in.nextInt();
        //System.out.println("here");
        long x = fib1(n,m) % m;
        long y = fib1(n+1,m) % m;
        long res = (x*y)% m;

        out.printf(Long.toString(res));

        //out.printf(Long.toString(fibbonaci(n,m)));
      }


      static long fib1(int N , int m) {
        if (N <= 1) {
          return N;
        }
        long[][] A = new long[][]{{1, 1}, {1, 0}};
        matrixPower(A, N-1, m);

        return A[0][0];
    }

    static void matrixPower(long[][] A, long N, int m) {
        if (N <= 1) {
          return;
        }
        matrixPower(A, N/2, m);
        multiply(A, A, m);

        long[][] B = new long[][]{{1, 1}, {1, 0}};
        if (N%2 != 0) {
            multiply(A, B, m);
        }
    }

    static void multiply(long[][] A, long[][] B, int m) {
        long x = (A[0][0] * B[0][0] + A[0][1] * B[1][0])%m;
        long y = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) %m;
        long z = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) %m;
        long w = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) %m;

        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }

      static long fib(int N) {
       double goldenRatio = (1 + Math.sqrt(5)) / 2;
       return (long)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
   }
      static long solution(int n, int m){
        long x = fib(n) % m;
        long y = fib(n+1) % m;

        return (x*y)%m;
      }
      static long fibbonaci(int n, int m){
        if(n==1){
          return  1;
        }
        long res = 1;
        long prev = 0;
        long curr = 1;
        long next = -1;
        long temp;
        for(int i=2; i<=n+1; i++){
          if(curr>1000000000){
            prev = prev%m;
            curr = curr%m;
          }
          next = (prev + curr);

          prev = curr;

          curr = next;
        }
        //System.out.println(curr);
        //System.out.println(prev);
        //return curr*curr + prev*prev;
        //System.out.println(curr);
        //System.out.println(prev);
        //System.out.println(curr*prev);
        curr = curr%m;
        prev = prev%m;
        res = curr*prev;
        long finalx = res % m;
        return finalx;

      }




      }
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
