/*

Let G = (V, E) be a weighted graph, with nonnegative weights w(v) for each vertex v ∈ V .
A subset of nodes S ⊂ V is an independent set of G if there are no edges between them.
Assuming that G is a tree, find a linear time algorithm for finding the maximum weight
independent set in G, i.e. an independent set S of G such that P
v∈S w(v) is maximized

O(N) DP solution

Base case: if no children, then LIS = 1.
else: LIS(root) = MAX( 1 + grandchilren LIS, direct children LIS)
*/
