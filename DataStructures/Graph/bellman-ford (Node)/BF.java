import java.util.*;

public class BF{
  static class Graph{
    int V;
    int[] dist;
    Set<Integer> popped;
    PriorityQueue<Node> pq;
    ArrayList<Node>[] adj;

    Graph(int n){
      V = n;
      dist = new int[V];
      popped = new HashSet<Integer>();
      pq = new PriorityQueue<Node>(V, new Node());
      adj = new ArrayList[V];
      for(int i=0; i<V; i++){
        adj[i] = new ArrayList<Node>();
      }

    }
    public void addEdge(int u, int v, int weight){
      // directed
      Node n = new Node(v, weight);
      adj[u].add(n);
      // undirected
      //Node l = new Node(u, weight);
      //adj[v].add(l);
    }

    public int bellmanford(int src, int dest){
      for(int i=0; i<V; i++){
        dist[i] = Integer.MAX_VALUE;
      }
      dist[src] = 0;
      for(int i=1; i<=V-1; i++){
        for(int j=0; j<V; j++){
          Iterator<Node> iter = adj[j].listIterator();
          while(iter.hasNext()){
            Node n = iter.next();
            if(dist[j]!= Integer.MAX_VALUE && dist[n.node]>dist[j]+n.cost){
              dist[n.node] = dist[j] + n.cost;
            }
          }
        }
      }
      return dist[dest];
    }
  }


  static class Node implements Comparator<Node>{
    int node;
    int cost;

    Node(){

    }
    Node(int node, int cost){
      this.node = node;
      this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2){
      if(node1.cost<node2.cost){
        return -1;
      }
      if(node2.cost>node1.cost){
        return 1;
      }
      return 0;
    }
  }

  public static void main(String[] args){
    Graph g = new Graph(10);
    g.addEdge(0,1,10);
    g.addEdge(1,2,20);
    g.addEdge(0,2,5);
    g.addEdge(1,3,30);
    g.addEdge(3,2,-39);
    System.out.println(g.bellmanford(0,2));
  }
}
