import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Dfs{

  public static class Graph{
    ArrayList<Integer> adj[];
    int V;
    int[] preorder;
    int[] postorder;
    int[] cc;
    int count;
    public Graph(int n){
      V = n;
      adj = new ArrayList[n];
      for(int i=0; i<n; i++){
        adj[i] = new ArrayList<Integer>();
      }
      preorder = new int[V];
      postorder = new int[V];
      cc = new int[V];

    }
    void addEdge(int u, int v){
      adj[u].add(v);
      adj[v].add(u);
    }
    void dfs(int source){
      count = 0;
      boolean[] visited = new boolean[V];
      preorder[source] = 0;
      visited[source] = true;
      Iterator<Integer> i = adj[source].listIterator();
      while(i.hasNext()){
        int next = i.next();
        if(!visited[next]){
          explore(next, visited);
        }
      }
      count+=1;
      postorder[source] = count;
    }
    void explore(int curr, boolean[] visited){
      count +=1;
      preorder[curr] = count;
      visited[curr] = true;
      System.out.println(curr);
      Iterator<Integer> i = adj[curr].listIterator();
      while(i.hasNext()){
        int next = i.next();
        if(!visited[next]){
          explore(next,visited);
        }
      }
      count+=1;
      postorder[curr] = count;
    }
  }
  public static void main(String[] args){
    Graph g = new Graph(10);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(2,3);
    g.dfs(0);
    for(int i=0; i<=3; i++){
      System.out.println(g.preorder[i]);
    }
    for(int i=0; i<=3; i++){
      System.out.println(g.postorder[i]);
    }
  }


}
