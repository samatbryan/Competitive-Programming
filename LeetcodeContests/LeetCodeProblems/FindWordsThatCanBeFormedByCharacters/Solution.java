/*
Easy
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

*/
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] a = new int[26];
        for(int i=0; i<chars.length(); i++){
            a[chars.charAt(i) - 'a'] +=1;
        }
        int res = 0;
        for(int i=0; i<words.length; i++){
            int[] b = Arrays.copyOfRange(a,0,26);
            String s = words[i];
            boolean possible = true;
            for(int j=0; j<s.length(); j++){
                int val = s.charAt(j) - 'a';
                if(b[val]<=0){
                    possible = false;
                    continue;
                }
                else{
                    b[val] -=1;
                }
            }
            if(possible){
                res += s.length();
            }
        }
        return res;
    }
}
