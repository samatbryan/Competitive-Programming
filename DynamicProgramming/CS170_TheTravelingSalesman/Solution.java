/*
Goal:
Starting at city 1,  you want to make a tour around every single city once
and given pairwise distances, what is the best order to visit to minimize
overall distance


Brute Force : n^n

Dynamic Programming: O(n2^n)

DP[S, i]: length of the shortest path visiting each node in S exactly
          once, starting at 1 and ending at j

Return min of i.. DP{entire set, i} + d.i,1
Compute and save possible subsets of the graph.

Base case: DP[{all subsets including one}, 1] = infinity. cant start and end there.
           DP[{1}, 1] = 0; already there.


FOR all subsets including one
for Length 2 subsets to length n subsets containing 1:
  for all j in S != 1:
      DP(S, j) = min(  DP{S-j, i} + dij: for i in S)

Return min of i.. DP{entire set, i} + d.i,1

*/
