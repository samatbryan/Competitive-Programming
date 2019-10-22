import java.util.Arrays;

public class Mergesort{

  public static int[] mergesort(int[] a){
    int n = a.length;
    if(n==1){
      return a;
    }
    int[] left = Arrays.copyOfRange(a,0,n/2);
    int[] right = Arrays.copyOfRange(a,n/2, n);

    return merge(mergesort(left), mergesort(right));
  }
  public static int[] merge(int[] a, int[] b){
    int m = a.length;
    int n = b.length;
    int[] c = new int[m+n];
    int i=0, j=0;
    int k = 0;
    while(i<m && j<n){
      if(a[i] < b[j]){
        c[k] = a[i];
        i++;
      }
      else if(a[i] > b[j]){
        c[k] = b[j];
        j++;
      }

      else{
        c[k] = a[i];
        i++;
      }
      k++;
    }
    for(int r = i; r<m; r++){
      c[k] = a[r];
      k++;
    }
    for(int r = j; r<n; r++){
      c[k] = b[r];
      k++;
    }
    return c;

  }

  public static void main(String[] args){
    int[] a = new int[]{5,5,5,5};
    a = mergesort(a);
    for(int i=0; i<a.length; i++){
      System.out.print(a[i]);
      System.out.print(" ");
    }
  }

}
