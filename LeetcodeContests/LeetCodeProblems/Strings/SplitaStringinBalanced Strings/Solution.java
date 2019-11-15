/*
Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.

Greedily cut every part.
*/
class Solution {
    int res = 0;
    public int balancedStringSplit(String s) {
        if(s.length() == 1){
            return 0;
        }
        helper(s);
        return res;
    }
    public void helper(String s){
        if(s.length() == 0 || s.length() == 1){
            return;
        }
        int L=0, R=0;
        if(s.charAt(0) == 'L'){
            L+=1;
        }
        else{
            R+=1;
        }
        for(int i=1; i<s.length(); i++){
            if(L==R){
                res +=1;
                helper(s.substring(i,s.length()));
                return;
            }
            if(s.charAt(i)=='L'){
                L+=1;
            }
            else{
                R+=1;
            }
        }
        if(L == R){
            res +=1;
        }

    }
}
