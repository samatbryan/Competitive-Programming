/*
Given a string, a partitioning of the string is a palindrome partitioning
if every substring of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba”
 is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for
  palindrome partitioning of a given string. For example, minimum 3 cuts are needed for
   “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. If a string is palindrome,
   then minimum 0 cuts are needed. If a string of length n containing all different characters,
    then minimum n-1 cuts are needed.



    // try dp on dp[i][j].
    i = first index;
    j = second index
    value = minimum number of partitions

    Do by length, return dp[0][n-1];
    base case, every one letter needs 0 cuts.
              every 2 letter needs 0 cuts

    recursive: dp[i][j]. suppose we have all less than j-i, between i and j.
                        then, if dp[i+1][j-1] is 0 and a[i] == a[j], then dp[i][j] = 0;
                              else{
                                  we try every splitpoint between it.
                            }


*/
