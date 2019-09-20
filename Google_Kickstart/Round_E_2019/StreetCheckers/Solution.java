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
import java.util.Map;
import java.util.HashMap;

// template
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        StreetCheckers solver = new StreetCheckers();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class StreetCheckers {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int L = in.nextInt();
            int R = in.nextInt();
            // Sieve of Era. Getting ready for prime factorization.
            int[] spf = new int[R+1];
            spf[0] = 0;
            spf[1] = 1;
            for(int i=2; i<=R; i++){
              if(spf[i] == 0){
                spf[i] = i;
                for(int j=2*i; j<=R; j+=i){
                  if(spf[j]==0){
                    spf[j] = i;
                  }
                }
              }
            }
            int c=0;
            for(int k=L; k<=R; k++){
              //System.out.println("current k");
              //System.out.println(k);

              Map<Integer,Integer> odds = new HashMap<Integer,Integer>();
              Map<Integer,Integer> evens = new HashMap<Integer,Integer>();
              int curr = k;
              while(curr!=1){
                if(spf[curr]%2==0){
                  int count = evens.getOrDefault(spf[curr], 0);
                  evens.put(spf[curr], count + 1);
                  //System.out.println("even");
                  //System.out.println((spf[curr]));
                }
                else{
                  int count = odds.getOrDefault(spf[curr], 0);
                  odds.put(spf[curr], count + 1);
                  //System.out.println("odd");

                  //System.out.println((spf[curr]));

                }
                curr = curr/spf[curr];
              }
              int Alice = 1;
              int Bob = 0;
              for(int v : odds.values()){
                Alice*= v+1;
              }
              for(int v : evens.values()){
                Bob = Alice * v;
              }
              if(Math.abs(Alice-Bob)<=2){
                c+=1;
              }
              //System.out.println(Alice);
              //System.out.println(Bob);
              //System.out.println();
            }
            out.printf("Case #%d: %s\n", testNumber, c);


            //From numbers L to R, Prime factorize each number.
            // Alice = number of odd factors of the numbers from 1 to the number
            // Bob = number of even factors of the number from 1 to the number

            // Do sieve of erathanos, and the smallest prime of the number from 1 to R:
              // store that into an array of size R obviously
            // from each number L through R. Prime factorize using that array. We do number = number / arr[number].

              //Add that factor to HASHSETS:
                  //if that number was even: add to our even arr. Else, add to our odd arr and +=1
                  // Notice bobs's hashset will only be 2, and just the count of 2. So Bobs = count(Alice) * value(2)
                  // Alice = values *= values+1
                  // Same for Bob - 1 because dont want to count the 1.


                //if abs(alice - bob) > 2. append num

            //

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
