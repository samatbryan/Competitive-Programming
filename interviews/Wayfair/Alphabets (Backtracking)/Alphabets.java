// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    HashMap<Integer, String> hm = new HashMap<Integer, String>();
    int longest = -1;
    public boolean validMove(String s){

        int n = s.length();
        if(n<3){
            return true;
        }
        if(s.charAt(n-1) == s.charAt(n-2) && s.charAt(n-2) == s.charAt(n-3)){
            return false;
        }
        return true;
    }
    public void backtrack(int A, int B, int C, String s){
        if(s.length()>longest){
            longest = s.length();
        }
        if(s.length()>0){
            hm.put(s.length(), s);
        }
        if(A>0){
            String y = s + "a";

            if(validMove(y)){
                backtrack(A-1,B,C,y);
            }
        }
        if(B>0){
            String z = s + "b";
            if(validMove(z)){
                backtrack(A,B-1,C,z);
            }
        }
        if(C>0){
            String x = s + "c";
            if(validMove(x)){
                backtrack(A,B,C-1,x);
            }
        }


    }
    public String solution(int A, int B, int C) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        String s  = "";
        backtrack(A,B,C,s);
        //System.out.println(hm.get(longest));
        return hm.get(longest);

    }
}
