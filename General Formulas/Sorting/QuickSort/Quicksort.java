/*
Pick a partition
Put < at left and > at right using this partition
Do left and do right

In place
*/

public class Quicksort{
  public int[] quicksort(){

  }
  public int partition(int[] arr, int low, int high){
    int pivot = arr[high];
    //place all values less than pivot into the left.
    // i is how many there are.
    // at the end swap i
    int i = 0;
    for(int j=0; j<high; j++){
      if(arr[j] < pivot){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
      }

    arr[high] = arr[i];
    arr[i] = pivot;
    return i;
    }


  }

  public int[] quicksort(int[] arr, int low, int high){
    if(low<high){
      int part = partition(arr, low, high);
      quicksort(arr, low, part-1);
      quicksort(arr,part+1, high);
    }
  }




}
