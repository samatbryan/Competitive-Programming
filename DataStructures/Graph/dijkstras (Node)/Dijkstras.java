import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

public class Dijkstras{

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

    public int dijkstras(int src, int dest){
      for(int i=0; i<V; i++){
        dist[i] = Integer.MAX_VALUE;
      }
      dist[src] = 0;
      pq.add(new Node(src, 0));

      while(!pq.isEmpty()){
        Node n = pq.remove();
        popped.add(n.node);
        Iterator<Node> i = adj[n.node].listIterator();
        while(i.hasNext()){
          Node neighbor = i.next();
          if(popped.contains(neighbor.node)){
            continue;
          }
          if(dist[neighbor.node] > dist[n.node] + neighbor.cost){
            dist[neighbor.node] = dist[n.node] + neighbor.cost;
            pq.add(new Node(neighbor.node, dist[neighbor.node]));
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
    g.addEdge(0,1,1);
    g.addEdge(1,2,2);
    g.addEdge(0,2,5);
    g.addEdge(0,3,0);
    g.addEdge(3,2,0);
    System.out.println(g.dijkstras(1,2));
  }

}
