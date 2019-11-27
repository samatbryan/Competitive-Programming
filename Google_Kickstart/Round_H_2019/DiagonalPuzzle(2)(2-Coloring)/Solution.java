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
        int ans;
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            ans = Integer.MAX_VALUE;
            int N = in.nextInt();
            char[][] board = new char[N][N];
            for(int i=0; i<N; i++){
              String c = in.next();
              for(int j=0; j<N; j++){
                board[i][j] = c.charAt(j);
              }
            }
            boolean done = true;
            for(int i=0; i<N; i++){
              for(int j=0; j<N; j++){
                if(board[i][j] == '.'){
                  done = false;
                  break;
                }
              }
            }
            if(done){
              out.printf("Case #%d: %s\n", testNumber, "0");
              return;
            }
            else{
              helper(board, 0);
            }



            out.printf("Case #%d: %s\n", testNumber, Integer.toString(ans));
        }
        public void checkBoard(char[][] board, int count){
          for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
              if(board[i][j] != '#'){
                return;
              }
            }
          }
          if(count < ans){
            ans = count;
          }
        }

        public void helper(char[][] board, int moves){
          boolean done = true;
          int N = board.length;
          for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
              if(board[i][j] == '.'){
                done = false;
                break;
              }
            }
          }
          if(done){
            if(moves<ans){
              ans = moves;
            }
            return;
          }
          int nummoves = 2*(2*N-1);
          for(int i=0; i<nummoves; i++){


            char[][] newboard = new char[N][N];
            for(int x=0; x<N; x++){
              for(int y=0; y<N; y++){
                newboard[x][y]= board[x][y];
              }
            }
            makeMove(newboard, i,0);
          }
        }

        public void printBoard(char[][] board){
          int n = board.length;
          for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
              System.out.print(board[i][j]);
              System.out.print(" ");
            }
            System.out.println();
          }
          System.out.println();

        }
        public void makeMove(char[][] board, int move, int count){
          int N = board.length;

          int totalmoves = 2*(2*N-1);

          boolean complete = true;
          for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
              if(board[i][j] == '.'){
                complete = false;
                break;
              }
            }
          }
          if(complete){
            //System.out.print("HEREEE");
            if(count<ans){
              ans = count;
            }
            return;
          }
          int imove = move;

          boolean oD = false;
          int n = board.length;
          int row, col;
          if(move>=2*n-1){
            oD = true;
            move = move - (2*n-1);
          }
          if(oD){
            if(move<n){
              row = 0;
              col = n-1-move;
            }
            else{
              col = 0;
              row = move - n + 1;
            }
            boolean full = true;
            int copyrow = row;
            int copycol = col;
            int frow = row;
            int fcol = col;
            while(copyrow>=0 && copycol >=0 && copyrow <n && copycol <n){
              if(board[copyrow][copycol] != '#'){
                full = false;
                break;
              }
              copyrow +=1;
              copycol +=1;
            }
            //downright

            if(!full){
              count +=1;
              while(row>=0 && col >=0 && row <n && col <n){
                if(board[row][col] == '.'){
                  board[row][col] = '#';
                }
                else{
                  board[row][col] = '.';
                }
                row +=1;
                col +=1;
              }
              //printBoard(board);
              checkBoard(board,count);

            }
            for(int next = imove+1; next<totalmoves; next++){
              char[][] newboard = new char[N][N];
              for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                  newboard[x][y]= board[x][y];
                }
              }

              makeMove(newboard, next, count);
              if(!full){
                  while(frow>=0 && fcol >=0 && frow <n && fcol <n){
                    if(board[frow][fcol] == '.'){
                      board[frow][fcol] = '#';
                    }
                    else{
                      board[frow][fcol] = '.';
                    }
                    frow -=1;
                    fcol +=1;
                  }



              }
            }

          }
          else{
            if(move<n){
              col = 0;
              row = move;

              //row=0;
              //col=move;
            }
            else{
              col = n-1;
              row = move-n+1;
            }

            // now make move.
            boolean full = true;
            int frow = row;
            int fcol = col;
            int copyrow = row;
            int copycol = col;
            while(copyrow>=0 && copycol >=0 && copyrow <n && copycol <n){
              if(board[copyrow][copycol] != '#'){
                full = false;
                break;
              }
              copyrow -=1;
              copycol +=1;
            }

            if(!full){
              count +=1;
              while(row>=0 && col >=0 && row <n && col <n){
                if(board[row][col] == '.'){
                  board[row][col] = '#';
                }
                else{
                  board[row][col] = '.';
                }
                row -=1;
                col +=1;
              }
              //upright
              printBoard(board);
              checkBoard(board,count);

            }

            for(int next = imove+1; next<totalmoves; next++){
              char[][] newboard = new char[N][N];
              for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                  newboard[x][y]= board[x][y];
                }
              }

              makeMove(newboard, next, count);
              if(!full){
                  while(frow>=0 && fcol >=0 && frow <n && fcol <n){
                    if(board[frow][fcol] == '.'){
                      board[frow][fcol] = '#';
                    }
                    else{
                      board[frow][fcol] = '.';
                    }
                    frow -=1;
                    fcol +=1;
                  }



              }
            }
          }


          for(int next = imove+1; next<totalmoves; next++){
            char[][] newboard = new char[N][N];
            for(int x=0; x<N; x++){
              for(int y=0; y<N; y++){
                newboard[x][y]= board[x][y];
              }
            }

            makeMove(newboard, next, count);
          }

          // iterate over the rest;
//
//

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
