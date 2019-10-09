import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;
// undirected graph
public class Graph{

  ArrayList<Integer>[] adj;
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
  
  boolean hasEdge(int u, int v){
    int size = adj[u].size();
    for(int i=0; i<size; i++){
      if(adj[u].get(i) == v){
        return true;
      }
    }
    return false;
  }

  void bfs(int source){
    //FIFO first in first out
    boolean visited[] = new boolean[V];
    visited[source] = true;
    Queue<Integer> q = new ArrayDeque<Integer>();
    // add to end
    q.add(source);
    while(!q.isEmpty()){
      int curr = q.poll();
      System.out.println(curr);

      int size = adj[curr].size();

      for(int i=0; i<size; i++){
        int next = adj[curr].get(i);
        if(!visited[next]){
          visited[next] = true;
          q.add(next);
        }
      }
    }
  }
  void dfs(int source){
    boolean visited[] = new boolean[V];
    visited[source] = true;
    Iterator<Integer> i = adj[source].listIterator();

    while(i.hasNext()){
      int next = i.next();
      if(!visited[next]){
        explore(next, visited);
      }
    }
  }
  void explore(int v, boolean[] visited){
    System.out.println(v);
    visited[v] = true;
    Iterator<Integer> i = adj[v].listIterator();
    while(i.hasNext()){
      int next = i.next();
      if(!visited[next]){
        explore(next,visited);
      }
    }
  }

  //dijkstras (greedy algorithm)
  public static void main(String[] args){
    Graph g = new Graph(10);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,3);
    g.addEdge(2,4);
    g.addEdge(3,5);
    g.addEdge(4,6);
    g.dfs(0);
  }
}
