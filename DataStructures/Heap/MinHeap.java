public class MinHeap {
  private int[] arr;
  private int capacity;
  private int size;

  MinHeap(int capacity) {
    this.capacity = capacity;
    size = 0;
    arr = new int[capacity];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getMin() {
    if (isEmpty()) {
      throw new HeapException("Heap is empty");
    } else {
      return arr[0];
    }
  }

  public int extractMin() {
    if (isEmpty()) {
      throw new HeapException("Heap is empty");
    } else {
      int min = arr[0];
      arr[0] = arr[size - 1];
      size--;
      swimdown(0);
      return min;
    }
  }

  public void insert(int val) {
    if (size == capacity) {
      resize();
    }
    arr[size] = val;
    swimup(size);
    size++;
  }

  private void resize() {
    int doubleSize = 2 * size;
    int[] tempArr = new int[doubleSize];
    for (int i = 0; i < size; i++) {
      tempArr[i] = arr[i];
    }
    capacity = doubleSize;
    arr = tempArr;
  }

  private void swimup(int nodeIndex) {
    if (size == 0) {
      return;
    }
    int nodeValue = arr[nodeIndex];
    int parentIndex = getParentIndex(nodeIndex);
    int parentValue = arr[parentIndex];
    if (nodeValue < parentValue) {
      arr[parentIndex] = nodeValue;
      arr[nodeIndex] = parentValue;
      swimup(parentIndex);
    }
  }

  private void swimdown(int nodeIndex) {
    if (size > 0) {
      int leftChildIndex = getLeftChildIndex(nodeIndex);
      int rightChildIndex = getRightChildIndex(nodeIndex);
      int minChildIndex;
      if (rightChildIndex >= size) {
        if (leftChildIndex >= size) { // no children
          return;
        } else {
          minChildIndex = leftChildIndex;
        }
      } else {

        if (arr[leftChildIndex] < arr[rightChildIndex]) {
          minChildIndex = leftChildIndex;
        } else {
          minChildIndex = rightChildIndex;
        }
      }

      if (arr[nodeIndex] > arr[minChildIndex]) {
        int temp = arr[nodeIndex];
        arr[nodeIndex] = arr[minChildIndex];
        arr[minChildIndex] = temp;
        swimdown(minChildIndex);
      }
    }
  }

  private int getLeftChildIndex(int nodeIndex) {
    return 2 * nodeIndex + 1;
  }

  private int getRightChildIndex(int nodeIndex) {
    return 2 * nodeIndex + 2;
  }

  private int getParentIndex(int nodeIndex) {
    if (nodeIndex == 0) {
      return 0;
    }
    return (nodeIndex - 1) / 2;
  }

  public class HeapException extends RuntimeException {
    public HeapException(String message) {
      super(message);
    }
  }

  public static void main(String[] args) {
    MinHeap heap = new MinHeap(10);
    heap.insert(10);
    heap.insert(5);
    heap.insert(2);
    System.out.println(heap.getMin());
    System.out.println(heap.extractMin());
    System.out.println(heap.getMin());
    heap.insert(0);
    System.out.println(heap.getMin());
  }
}
