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

// template
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        CodeEatSwitcher solver = new CodeEatSwitcher();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class CodeEatSwitcher {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int d = in.nextInt(), s = in.nextInt();
            CodeEatSwitcher.G[] gs = new CodeEatSwitcher.G[s];
            int sa = 0;
            for (int i = 0; i < s; i++) {
                gs[i] = new CodeEatSwitcher.G(in.nextInt(), in.nextInt());
                sa += gs[i].a;
            }
            Arrays.sort(gs, (a, b) -> a.a * b.b - a.b * b.a);
            CodeEatSwitcher.G[] qs = new CodeEatSwitcher.G[d];
            for (int i = 0; i < d; i++) {
                qs[i] = new CodeEatSwitcher.G(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(qs, Comparator.comparingInt(x -> x.b));
            char[] ans = new char[d];
            int cx = 0, cy = sa;
            int ci = 0;
            for (int i = 0; i < d; i++) {
                while (ci < gs.length && qs[i].b > cx + gs[ci].b) {
                    cx += gs[ci].b;
                    cy -= gs[ci].a;
                    ci++;
                }
                if (ci >= gs.length) {
                    ans[qs[i].c] = 'N';
                } else {
                    int nx = cx + gs[ci].b, ny = cy - gs[ci].a;
                    ans[qs[i].c] = ccw(cx, cy, qs[i].b, qs[i].a, nx, ny) ? 'Y' : 'N';
                }
            }

            out.printf("Case #%d: %s\n", testNumber, new String(ans));
        }

        boolean ccw(long ax, long ay, long bx, long by, long cx, long cy) {
            return (bx - ax) * (cy - ay) - (by - ay) * (cx - ax) >= 0;
        }

        static class G {
            public int a;
            public int b;
            public int c;

            public G(int a, int b) {
                this.a = a;
                this.b = b;
            }

            public G(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }

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
