import java.util.*;

public class balls{
     int x;
     public balls(int x){
          this.x=x;
     }

     public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s.length() < p.length()){
            return res;
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        int uniqueLetters = 0;
        for(int i=0; i<p.length(); i++){
            if(hm.containsKey(p.charAt(i))){
                hm.put(p.charAt(i), hm.get(p.charAt(i)) + 1 );
            }
            else{
                hm.put(p.charAt(i), 1);
                uniqueLetters += 1;
            }
        }

        // first window:
        for(int i=0; i<p.length(); i++){
            char c = s.charAt(i);
            if(!hm.containsKey(c) || hm.get(c) == 0){
                uniqueLetters += 1;
                hm.put(c, 1);
            }
            else{
                hm.put(c,hm.get(c)-1);
                if(hm.get(c) == 0){
                    uniqueLetters -=1;
                }
            }
        }
        if(uniqueLetters = 0){
            res.add(0);
        }

        for(int i=p.length(); i<s.length(); i++){
            char c = s.charAt(i);
            char c_old = s.charAt(i-p.length());
            if(!hm.containsKey(c) || hm.get(c) == 0){
                uniqueLetters +=1;
                hm.put(c,1);
            }
            else{
                hm.put(c,hm.get(c)-1);
                if(hm.get(c) == 0){
                    uniqueLetters -= 1;
                }
            }

            if(!hm.containsKey(c_old) || hm.get(c_old) == 0){
                uniqueLetters +=1;
                hm.put(c_old,1);
            }
            else{
                hm.put(c_old, hm.get(c_old)-1);
                if(hm.get(c_old) == 0){
                    uniqueLetters -=1;
                }
            }

            if(uniqueLetters = 0){
                res.add(i-p.length() + 1);
            }
        }
        return res;


    }

     public static void main(String[] args){
          ArrayList<Integer> alist = findAnagrams("cbaebabacd", "abc");
          for(int i=0; i<alist.size(); i++){
               System.out.print(alist.get(i) + " ");
          }
     }
}
