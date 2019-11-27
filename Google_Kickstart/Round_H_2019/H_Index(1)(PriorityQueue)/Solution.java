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
import java.util.ArrayList;
import java.util.PriorityQueue;

// template

// Passes Hidden
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        H solver = new H();
        int testCount = in.nextInt();

        for (int i = 1; i <= testCount; i++){
          solver.solve(i, in, out);
        }
        out.close();
    }

    static class H {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            ArrayList<Integer> lol = new ArrayList<Integer>();
            int N = in.nextInt();
            int[] cits = new int[100002];
            int num;
            PriorityQueue<Integer> pq =
                          new PriorityQueue<Integer>();

            int ans = 0;

            for(int i=0; i<N; i++){
              num = in.nextInt();
              if(num>ans){
                pq.add(num);
                while(pq.peek() <= ans){
                  pq.poll();
                }
                if(pq.size() >= ans+1){
                  ans = ans + 1;
                }
              }


              lol.add(ans);

            }


            out.printf("Case #%d: ", testNumber);
            for(int i=0; i<lol.size(); i++){
              if(i==lol.size()-1){
                out.printf(Integer.toString(lol.get(i)));
                continue;

              }
              out.printf(Integer.toString(lol.get(i)));

              out.printf(" ");
            }
            out.printf("\n");
        }

        // doesnt pass
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            ArrayList<Integer> lol = new ArrayList<Integer>();
            int N = in.nextInt();
            int[] cits = new int[100002];
            int num;

            int ans = 0;
            int prev = 1;

            for(int i=0; i<N; i++){
              num = in.nextInt();
              for(int j=1; j<=num; j++){
                cits[j]+=1;
              }
              if(i==0){
                lol.add(1);
                prev = 1;
                continue;
              }
              else{
                if(cits[prev+1] >= prev+1){
                  prev = prev+1;
                }
              }
              lol.add(prev);
            }



            out.printf("Case #%d: ", testNumber);
            for(int i=0; i<lol.size(); i++){
              if(i==lol.size()-1){
                out.printf(Integer.toString(lol.get(i)));
                continue;

              }
              out.printf(Integer.toString(lol.get(i)));

              out.printf(" ");
            }
            out.printf("\n");
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
