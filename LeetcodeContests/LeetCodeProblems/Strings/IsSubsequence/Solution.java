/*

Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in
 both s and t. t is potentially a very long (length ~= 500,000) string,
 and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the
original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters.
(ie, "ace" is a subsequence of "abcde" while "aec" is not).



*/
class Solution {
   // O(n) solution. uses two pointers, if s.charAt(i) matches t.charAt(j), then res +=1 and move up both pointers
   // if res == s.length() , return true;
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m==0){
            return true;
        }
        if(n==0){
            return false;
        }
        int res = 0;
        int index = 0;
        for(int i=0; i<n; i++){
            if(res == m){
                return true;
            }

            if(s.charAt(index) == t.charAt(i)){
                res +=1;
                index +=1;
            }
        }

        return res == m;

    }
}
