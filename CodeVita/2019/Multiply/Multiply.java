
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
import java.lang.StringBuilder;

public class Multiply{
  public static void main(String[] args){
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    OutputWriter out = new OutputWriter(outputStream);
    //int testCount = Integer.parseInt(in.next());


    int D = in.nextInt();
    int N = in.nextInt();

    String s = solve(D,N);
    String lol = Integer.toString(D*D);
    //BigInteger bignum = new BigInteger(s);
    //Long res = Long.valueOf(s);
    //bignum = bignum.multiply(BigInteger.valueOf(D*D));
    //res *= D*D;
    out.printf(multiply(s,lol));
    out.close();
  }
  static String[] nums = new String[]{"1", "2", "3","4","5","6","7","8","9","0"};

  public static String solve(int d, int n){
    StringBuilder sb = new StringBuilder();
    String c = "";
    int count = 0;
    for(int i=0; i<n-1; i++){
      count = count%10;

      sb.append(nums[count]);
      count ++;
    }
    c = nums[count];
    String left = sb.toString();
    String right = sb.reverse().toString();

    return left + c + right;

  }
  public static String multiply(String num1, String num2) {
    String n1 = new StringBuilder(num1).reverse().toString();
    String n2 = new StringBuilder(num2).reverse().toString();

    int[] d = new int[num1.length()+num2.length()];

    //multiply each digit and sum at the corresponding positions
    for(int i=0; i<n1.length(); i++){
        for(int j=0; j<n2.length(); j++){
            d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
        }
    }
    StringBuilder sb = new StringBuilder();

    //calculate each digit
    for(int i=0; i<d.length; i++){
        int mod = d[i]%10;
        int carry = d[i]/10;
        if(i+1<d.length){
            d[i+1] += carry;
        }
        sb.insert(0, mod);
    }

    //remove front 0's
    while(sb.charAt(0) == '0' && sb.length()> 1){
        sb.deleteCharAt(0);
    }

    return sb.toString();
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
