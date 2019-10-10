import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Cc{
  public static class Graph{
    ArrayList<Integer> adj[];
    int V;
    int[] preorder;
    int[] postorder;
    int[] cc;
    int count;
    int ccCount;
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
      ccCount = 0;
      preorder[source] = 0;
      cc[source] = 0;

      boolean[] visited = new boolean[V];
      visited[source] = true;
      Iterator<Integer> i = adj[source].listIterator();
      while(i.hasNext()){
        //explore from source
        int next = i.next();
        if(!visited[next]){
          explore(next, visited);
          ccCount += 1;
        }

        //explore from other cc
        for(int j=0; j<V; j++){
          if(j!=source && !visited[j]){
            i = adj[j].listIterator();
            if(!i.hasNext()){
              cc[j] = ccCount;
              ccCount +=1;
              continue;
            }
            while(i.hasNext()){
              next = i.next();
              if(!visited[next]){
                //System.out.println("here");
                explore(next,visited);
                ccCount +=1;
              }
            }
          }
        }
      }
      count+=1;
      postorder[source] = count;
    }
    void explore(int curr, boolean[] visited){
      cc[curr] = ccCount;
      count +=1;
      preorder[curr] = count;
      visited[curr] = true;
      //System.out.println(curr);
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
    void printCC(){
      for(int i=0; i<V; i++){
        System.out.println(cc[i]);
      }
    }
  }
  public static void main(String[] args){
    Graph g = new Graph(10);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(0,3);

    g.dfs(0);
    g.printCC();

  }



}
