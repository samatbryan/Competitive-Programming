import java.util.HashMap;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class A{
  public static void main(String[] args){
    Solution s = new Solution();
    s.solve();
  }

  static class Solution{

    public boolean isAlpha(String s){
      if(s.equals("*") || s.equals("-") || s.equals("+")){
        return false;
      }
      return true;
    }

    public void solve(){
      Deque<Boolean> stack = new ArrayDeque<Boolean>();

      String[] alphabets = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                                    "R" , "S", "T", "U", "V", "W", "X" ,"Y", "Z"};



      HashMap<String, Boolean> hm  = new HashMap<String, Boolean>();
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      for(int i=0; i<n; i++){
        String op = in.next();
        if(op.equals("T")){
          //System.out.println(alphabets[i]);
          hm.put(alphabets[i], true);
        }
        else{
          hm.put(alphabets[i], false);
        }
        //System.out.println(op);
      }

      while(in.hasNext()){
        String p = in.next();

        if(isAlpha(p)){
          //System.out.println(p);
          stack.push(hm.get(p));
          //System.out.println("pushing alphabets");
          //System.out.println(hm.get(p));
        }
        else{
          if(p.equals("+")){
            //System.out.println(p);
            Boolean right = stack.pop();
            Boolean left = stack.pop();
            stack.push(right || left);
            //System.out.println(right||left);

          }
          else if(p.equals("*")){
            Boolean right = stack.pop();
            Boolean left = stack.pop();
            stack.push(right && left);
            //System.out.println(right&&left);
          }
          else{
            Boolean left = stack.pop();
            //System.out.println(!left);

            stack.push(!left);
          }
        }
      }
      //in.close();
      //System.out.println("out");
      Boolean last = stack.pop();
      if(last){
        System.out.printf("T");

      }
      else{
        System.out.printf("F");
      }



    }
  }
}
