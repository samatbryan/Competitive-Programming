public class DisjointSets{


  static class mySet{
    int value;
    int parent;

    mySet(int value, int parent){
      this.value = value;
      this.parent = parent;
    }
  }

  static void union(mySet a, mySet b){
    int bParent = findParent(b);
    a.parent = bParent;
  }

  static int findParent(mySet a){
    if(a.parent == a.value){
      return a.parent;
    }
    return findParent(a.parent);
  }
}
