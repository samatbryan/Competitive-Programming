import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

public class Floyd{
  static class Graph{
    int V;
    int[] dist;
    Set<Integer> popped;
    PriorityQueue<Node> pq;
    ArrayList<Node>[] adj;
    int[][] distances;

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
    public void floyd(){
      distances = new int[V][V];

      // set diagonals to 0, and others to infinity
      for(int i=0; i<V; i++){
        for(int j=0; j<V; j++){
          if(i==j){
            distances[i][j] = 0;
          }
          else{
            distances[i][j] = Integer.MAX_VALUE;
          }
        }
      }

      for(int i=0; i<V; i++){
        Iterator<Node> iter = adj[i].listIterator();
        while(iter.hasNext()){
          Node n = iter.next();
          distances[i][n.node] = n.cost;
        }
      }

      for(int i=0; i<V; i++){
        for(int j=0; j<V; j++){
          for(int k=0; k<V; k++){
            if(distances[i][k] == Integer.MAX_VALUE || distances[k][j] == Integer.MAX_VALUE){
              continue;
            }
            if(distances[i][j] > distances[i][k] + distances[k][j]){
              distances[i][j] = distances[i][k] + distances[k][j];
            }
          }
        }
      }




    }
    public int getDistance(int source, int dest){
      return distances[source][dest];
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
    g.floyd();
    System.out.println(g.getDistance(2,1));

  }


}
