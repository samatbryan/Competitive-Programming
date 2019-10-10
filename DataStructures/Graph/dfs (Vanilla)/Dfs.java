import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Dfs{

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
    void dfs(int source){
      boolean[] visited = new boolean[V];
      visited[source] = true;
      Iterator<Integer> i = adj[source].listIterator();
      while(i.hasNext()){
        int next = i.next();
        if(!visited[next]){
          explore(next, visited);
        }
      }
    }
    void explore(int curr, boolean[] visited){
      visited[curr] = true;
      System.out.println(curr);
      Iterator<Integer> i = adj[curr].listIterator();
      while(i.hasNext()){
        int next = i.next();
        if(!visited[next]){
          explore(next,visited);
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
    g.addEdge(1,5);
    g.dfs(0);
  }


}
