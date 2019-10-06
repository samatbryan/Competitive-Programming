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
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;


public class problem_a{
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

      public boolean isAlpha(String s){
        if(s.equals("*") || s.equals("-") || s.equals("+")){
          return false;
        }
        return true;
      }


      public void solve(int testNumber, InputReader in, OutputWriter out) {
          Deque<Boolean> stack = new ArrayDeque<Boolean>();

          String[] alphabets = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                                        "R" , "S", "T", "U", "V", "W", "X" ,"Y", "Z"};
          int n = in.nextInt();



          HashMap<String, Boolean> hm  = new HashMap<String, Boolean>();

          for(int i=0; i<2*n; i++){
            String op = in.next();
            if(op=="T"){
              hm.put(alphabets[i], true);
            }
            else{
              hm.put(alphabets[i], false);
            }
          }
          //System.out.println(c);

          Scanner scan = new Scanner(System.in);

          for(int i=0; i<250;i++){
            if(scan.hasNext()){
              String p = scan.next();
              System.out.println(p);
            }
          }
          scan.close();


          String q = in.next();
          System.out.println(q);
          StringBuilder sb = new StringBuilder();
          boolean prev;
          while(scan.hasNext()){
            String p =  scan.next();
            if(isAlpha(p)){
              stack.push(hm.get(p));
            }
            else{
              if(p.equals("+")){
                Boolean right = stack.pop();
                Boolean left = stack.pop();
                stack.push(right || left);
              }
              else if(p.equals("*")){
                Boolean right = stack.pop();
                Boolean left = stack.pop();
                stack.push(right && left);
              }
              else{
                Boolean left = stack.pop();
                stack.push(!left);
              }
            }

          }


          Boolean last = stack.pop();
          if(last){
            System.out.println("T");
          }
          else{
            System.out.println("F");
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
