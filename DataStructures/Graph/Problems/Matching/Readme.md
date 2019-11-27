Given an undirected graph, a matching is a set of edges, such that no two edges share the same vertex. In other words, matching of a graph is a subgraph where each node of the subgraph has either zero or one edge incident to it.
A vertex is said to be matched if an edge is incident to it, free otherwise.
Possible matchings of K_4, here the red edges denote the matching


Maximal Matching – A matching M of graph G is said to be maximal if on adding an edge which is in G but not in M, makes M not a matching.
In other words, a maximal matching M is not a proper subset of any other matching of G. For example, the following graphs are maximal matchings –

Adding any edge to any of the above graphs would result in them no longer being a matching.

Maximum Matching – A matching M of graph G is said to be maximum if it is maximal and has the maximum number of edges.
There may be many possible maximum matchings of a graph.
Every maximum matching is a maximal matching but not every maximal matching is a maximum matching.
For example, in the first figure G_3 is a maximum matching and in the second figure, the second and third graphs are maximum matchings.

Perfect Matching – A matching M of graph G is said to be perfect if every vertex is connected to exactly one edge. Every perfect matching is a maximum matching but not every maximum matching is a perfect matching.
Since every vertex has to be included in a perfect matching, the number of edges in the matching must be \frac{|V|}{2} where V is the number of vertices. Therefore, a perfect matching only exists if the number of vertices is even.
For example in the first figure, G_3 is a perfect matching.
A matching is said to be near perfect if the number of vertices in the original graph is odd, it is a maximum matching and it leaves out only one vertex. For example in the second figure, the third graph is a near perfect matching.
