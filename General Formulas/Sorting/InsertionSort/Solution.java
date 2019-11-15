/*
works the way we sort playing cards in our hands.
……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]




// 2 4 3
*/
public class Solution{
  public static int[] sort(int[] arr){
    int n = arr.length;
    for(int i=0; i<n; i++){
      int j = i;
      while(j>=0){
        if(arr[j] < arr[i]){
          j++;
          break;
        }
        j--;
      }
      j = Math.max(j,0);
      System.out.print(j);
      swap(arr, i, j);
    }
    return arr;
  }


  // correct?
  public static int[] newsort(int[] arr){
    int n = arr.length;
    for(int i=0; i<n; i++){
      int j;
      int temp = i;
      for(j=i; j>=0; j--){

        if(arr[temp] < arr[j]){
          // /System.out.print("hi");
          swap(arr, temp, j);
          temp = j;
        }
      }
    }
    return arr;
  }



  public static void swap(int[] arr, int l, int r){
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }

  //3 4 2
  public static void main(String[] args){
    int[] arr = new int[]{5,6,1,2,7,4,2,1,6,8,1,0};
    arr = newsort(arr);
    for(int i=0; i<arr.length; i++){
      System.out.print(arr[i]);
      System.out.print(" ");
    }
  }
}
