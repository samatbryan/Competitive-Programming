import java.util.ArrayList;
import java.util.List;
public class Combinations{
  static List< List<Integer>> res = new ArrayList< List<Integer>>();



  public void combinatoricsHelper(int[] set, int subset, int currlength, int index, ArrayList<Integer> c){
    if(currlength == subset){
      List<Integer> clone = new ArrayList<Integer>();
      clone = (ArrayList) c.clone();
      res.add(clone);
      return;
    }
    if(index>set.length){
      return;
    }
    for(int i=index; i<set.length; i++){
      c.add(set[i]);
      combinatoricsHelper(set, subset, currlength+1, i+1, c);
      c.remove(c.size()-1);
    }

  }
  public void combinatorics(int[] set, int subset){
    ArrayList<Integer> c = new ArrayList<Integer>();
    combinatoricsHelper(set,subset,0,0,c);
  }

  public static void main(String[] args){
    Combinations com = new Combinations();
    int[] set  = new int[]{1,2,3,4,5};
    com.combinatorics(set,3);
    for(int i=0; i<res.size(); i++){
      System.out.println(res.get(i));
    }
  }


}
