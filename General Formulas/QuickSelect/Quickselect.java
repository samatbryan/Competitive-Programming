/*
Find the kth largest element in an unsorted array. Note that it is the
kth largest element in the sorted order, not the kth distinct element.
*/

public class Quickselect{
  public static int solve(int[] arr, int k){

    return solve(arr, k, 0, arr.length-1);

  }

  public static Pair partition(int[] arr, int l, int r){
    if(l==r){
        Pair p = new Pair(arr[l], 0,1,0,0);
    }
    int i = l;
    int pivot = arr[r];
    int less =0;
    int equal = 1;
    int greater = 0;
    for(int j=l; j<r; j++){
      int curr = arr[j];
      if(curr<pivot){
        less+=1;
      }
      if(curr==pivot){
        equal +=1;
      }
      if(curr>pivot){
        greater+=1;
      }
      if(arr[j]<=pivot){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
      }
    }

    arr[r] = arr[i];
    arr[i] = pivot;
    Pair p = new Pair(pivot, less, equal, greater, less);
    for(int ii=l; ii<=r; ii++){
      System.out.print(arr[ii]);
      System.out.print(" ");
    }
    System.out.print("uhm");
    System.out.print(" pivot: ");
    System.out.print(pivot);
    System.out.println();
    return p;

  }

  public static int solve(int[] arr, int k, int l, int r){
    Pair p = partition(arr, l, r);
    if(l==r){
      return arr[l];
    }
    if(k<p.less){
      //System.out.print(p.less);
      return solve(arr, k, l, p.partition-1);
    }
    else if(k< p.equal + p.less){
      return p.value;
    }
    else{
      return solve(arr, k - p.equal - p.less, p.partition, r);
    }

  }


  static class Pair{
    int value;
    int less;
    int equal;
    int greater;
    int partition;

    Pair(int value, int less, int equal, int greater, int partition){
      this.value = value;
      this.less = less;
      this.equal = equal;
      this.greater = greater;
      this.partition = partition;
    }

  }

  public static void main(String[] args){
    int[] arr = new int[]{3,2,1,4,5,6};

                              //1,2,2,3,3,4,5,5,6
                              //4th largest =
    //int[] arr1 = new int[]{3,2,1,5,6,4};

    //System.out.print(solve(arr1,2));

    System.out.print(solve(arr, 5));
  }
}
