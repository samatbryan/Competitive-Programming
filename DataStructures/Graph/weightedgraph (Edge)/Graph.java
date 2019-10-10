import java.util.ArrayList;
import java.util.Iterator;

public class Graph{

  static class G{
    ArrayList<Edge>[] adj;
    int V;

    G(int n){
      V = n;
      adj = new ArrayList[n];
      for(int i=0; i<n; i++){
        adj[i] = new ArrayList<Edge>();
      }
    }
    public void addEdge(int source, int dest, int dist){
      Edge e = new Edge(source, dest, dist);
      adj[source].add(e);
    }
    public int getDistance(int source, int dest){
      Iterator<Edge> i = adj[source].listIterator();
      while(i.hasNext()){
        Edge e = i.next();
        if(e.dest==dest){
          return e.dist;
        }
      }
      return -1;
    }

  }
  static class Edge{
    int source;
    int dest;
    int dist;
    Edge(int source, int dest, int dist){
      this.source = source;
      this.dest = dest;
      this.dist = dist;
    }
  }
  public static void main(String[] args){
    G g1 = new G(10);
    g1.addEdge(1,2,5);
    g1.addEdge(2,3,10);
    System.out.println(g1.getDistance(2,3));
  }
}
