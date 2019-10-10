import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Pair{

  static class P{
    int x;
    int y;
    P(int x, int y){
      this.x = x;
      this.y = y;
    }
    @Override
    public boolean equals(Object obj){
      if(this == obj){
        return true;
      }
      if(obj == null || getClass() != obj.getClass()){
        return false;
      }
      P other = (P) obj;
      if(x!=other.x || y!=other.y){
        return false;
      }
      return true;
    }
    @Override
    public int hashCode(){
      final int prime = 31;
      int result = 1;
      result = prime*result + x;
      result = prime*result + y;
      return result;
    }
  }
  public static void main(String[] args){
    P a = new P(1,2);
    P b = new P(3,4);
    P c = new P(1,2);

    Set<P> s = new HashSet<P>();
    s.add(a);
    s.add(b);
    System.out.println(s.contains(c));
    s.add(c);
    Iterator<P> i = s.iterator();
    while(i.hasNext()){
      P nxt = i.next();
      System.out.println(nxt.x);
      System.out.println(nxt.y);
    }

  }

}
