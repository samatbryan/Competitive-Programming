import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Bfs{

  public static class Graph{
    ArrayList<Integer> adj[];
    int V;
    public Graph(int n){
      V = n;
      adj = new ArrayList[n];
      for(int i=0; i<n; i++){
        adj[i] = new ArrayList<Integer>();
      }
    }
    void addEdge(int u, int v){
      adj[u].add(v);
      adj[v].add(u);
    }
    void bfs(int source){
      boolean[] visited = new boolean[V];
      visited[source] = true;

      Queue<Integer> q = new ArrayDeque<Integer>();
      q.add(source);
      while(!q.isEmpty()){
        int curr = q.poll();
        System.out.println(curr);
        Iterator<Integer> i = adj[curr].listIterator();
        while(i.hasNext()){
          int next = i.next();
          if(!visited[next]){
            q.add(next);
            visited[next] = true;
          }

        }
      }
    }
  }
  public static void main(String[] args){
    Graph g = new Graph(10);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,3);
    g.addEdge(2,4);
    g.bfs(0);
  }


}
