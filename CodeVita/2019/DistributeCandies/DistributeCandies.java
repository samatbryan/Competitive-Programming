
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
public class DistributeCandies{
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
      static boolean flag = false;

      public void solve(int testNumber, InputReader in, OutputWriter out) {
          // initialize matrix with -1's.
          int m  = in.nextInt();
          int n  = in.nextInt();
          int k  = in.nextInt();
          int l1  = in.nextInt();
          int l2 = in.nextInt();
          int l3  = in.nextInt();
          int[] one = new int[]{m,n,k};
          int[] two = new int[]{l1,l2,l3};
          long res = findMinX(one,two,3);

          out.printf(Long.toString(res));
        }


        static long inv(long a, long m)
      {
          long m0 = m, t, q;
          long x0 = 0, x1 = 1;

          if (m == 1)
          return 0;

          // Apply extended Euclid Algorithm
          while (a > 1)
          {
              // q is quotient
              //System.out.println(m);
              if(m==0){
                flag = true;
                return 1;
              }
              q = a / m;

              t = m;

              // m is remainder now, process
              // same as euclid's algo
              m = a % m;a = t;

              t = x0;

              x0 = x1 - q * x0;

              x1 = t;
          }

          // Make x1 positive
          if (x1 < 0)
          x1 += m0;

          return x1;
      }

      // k is size of num[] and rem[].
      // Returns the smallest number
      // x such that:
      // x % num[0] = rem[0],
      // x % num[1] = rem[1],
      // ..................
      // x % num[k-2] = rem[k-1]
      // Assumption: Numbers in num[] are pairwise
      // coprime (gcd for every pair is 1)
      static long findMinX(int num[], int rem[], long k)
      {
          // Compute product of all numbers
          long prod = 1;
          for (int i = 0; i < k; i++)
              prod *= num[i];

          // Initialize result
          long result = 0;

          // Apply above formula
          for (int i = 0; i < k; i++)
          {
              long pp = prod / num[i];

              //System.out.println(num[1]);
              long right = inv(pp, num[i]);
              if(flag){
                return -1;
              }
              /*System.out.println(right);
              if(right == -1){
                System.out.println("true");
                return -1;
              }
              */
              result += rem[i] * right * pp;
          }

          return result % prod;
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
