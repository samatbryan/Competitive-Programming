/*
https://leetcode.com/problems/string-transforms-into-another-string
https://leetcode.com/discuss/interview-question/340493/Google-or-Onsite-or-String-Conversion
Given 2 strings s and t, determine if you can convert s into t. The rules are:

You can change 1 letter at a time.
Once you changed a letter you have to change all occurrences of that letter.
Example 1:

Input: s = "abca", t = "dced"
Output: true
Explanation: abca ('a' to 'd') -> dbcd ('c' to 'e') -> dbed ('b' to 'c') -> dced
Example 2:

Input: s = "ab", t = "ba"
Output: true
Explanation: ab -> ac -> bc -> ba
Example 3:

Input: s = "abcdefghijklmnopqrstuvwxyz", t = "bcdefghijklmnopqrstuvwxyza"
Output: false
Example 4:

Input: s = "aa", t = "cd"
Output: false
Example 5:

Input: s = "ab", t = "aa"
Output: true
Example 6:

Input: s = "abcdefghijklmnopqrstuvwxyz", t = "bbcdefghijklmnopqrstuvwxyz"
Output: true
Both strings contain only lowercase English letters.
*/

public class Solution{
  static boolean isHomomorphicII(String s, String t) {
    int length = s.length();
    if (length != t.length()) return false;

    int mapping[26];
    bool visited[26];
    int uniq_count = 0;
    for (int i = 0; i < 26; i++) {
        mapping[i] = -1;
        visited[i] = false;
    }

    // build mapping
    for (int i = 0; i < s.length(); i++) {
        int sc = s[i] - 'a';
        int tc = t[i] - 'a';
        if (mapping[sc] == -1) {
            mapping[sc] = tc;
        } else if (mapping[sc] != tc) {
            // this character maps to more than one character,
            // so it is not homomorphic
            return false;
        }
        // track how many unique characters appear in 't'
        if (!visited[tc]) {
            visited[tc] = true;
            uniq_count++;
        }
    }

    // if we have at least one swap character available then we can always transform the strings
    if (uniq_count < 26) return true;

    // at this point we don't have any characters available for swap space
    // so if even a single circular dependency exists then the strings
    // cannot be converted from one to the other using the global replaceAll

    for (int i = 0; i < 26; i++) {
        visited[i] = false;
    }
    for (int i = 0; i < length; i++) {
        int sc = s[i] - 'a';
        if (!visited[sc]) {
            visited[sc] = true;
            // use fast and slow pointers
            int slow = sc, fast = sc;
            while (true) {
                slow = mapping[slow];
                if ((fast = mapping[fast]) == -1) break;
                visited[fast] = true;
                if ((fast = mapping[fast]) == -1) break;
                visited[fast] = true;
                // if fast == slow then a cycle was detected, and there aren't any swap characters available so fail
                if (fast == slow) return false;
            }
        }
    }

    // if we made it this far, they are homomorphic and s can be transformed to t
    return true;
}
}
