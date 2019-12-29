public class FenwickTree{

    int[] arr;
    int[] fenwickTree;
    int n;
    public FenwickTree(int[] arr){
        this.arr = arr;
        n = arr.length;
        fenwickTree = new int[n+1];
        constructTree();
    }

    public void init(int index, int val){
        index = index + 1;

        while(index<=n){
            fenwickTree[index] += val;
            index += index&(-index);
        }
    }

    public void update(int index, int val){
        int diff = val - nums[index];
        nums[index]  = val;
        init(index, diff);
    }

    // gets the sum from 0 to element j
    public int getSum(int index){
        index = index + 1;
        int sum = 0;
        while(index > 0){
            sum += fenwickTree[index];
            // goes down left. Remember the diagram from the youtube video
            index -= index&(-index);
        }
        return sum;
    }

    public int getRange(int i, int j){
        return getSum(j) - getSum(i-1);
    }

    public void constructTree(){
        for(int i=0; i<n; i++){
            update(i,arr[i]);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};

        FenwickTree ft = new FenwickTree(arr);
        System.out.println(ft.getSum(9));
        System.out.println(ft.getRange(0,5));
        System.out.println(ft.getRange(5,9));
        System.out.println(ft.getRange(0,1));
    }
}
