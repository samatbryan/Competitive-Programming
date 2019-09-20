public class Solution{
  public static void main(String[] args) {
      InputStream inputStream = System.in;
      OutputStream outputStream = System.out;
      InputReader in = new InputReader(inputStream);
      OutputWriter out = new OutputWriter(outputStream);
      Autori solver = new Autori();
      //int testCount = Integer.parseInt(in.next());
      for (int i = 1; i <= testCount; i++)
          solver.solve(i, in, out);
      out.close();
  }

  static class Autori {
      public void solve(int testNumber, InputReader in, OutputWriter out) {
          int d = in.nextString();
          StringBuilder sb = new StringBuilder();
          sb.append(d.charAt(0));
          for(i=1; i<d.length(); i++){
            if(d.charAt(i)=='-'){
              sb.append(d.charAt(i+1));
            }
          }

          out.println(sb.toString());
          //out.printf("Case #%d: %s\n", testNumber, new String(ans));
      }


  }
}
