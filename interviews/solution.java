import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution {
    public void solve(){
      String[] a = new String[]{"hello", "a", "b", "ab", "bye", "die"};
      Arrays.sort(a);
      for(int i=0; i<a.length; i++){
        System.out.println(a[i  ]);

      }
    }
    public static void main(String args[] ) throws Exception {
      solution s = new solution();
      s.solve();
    }

}
