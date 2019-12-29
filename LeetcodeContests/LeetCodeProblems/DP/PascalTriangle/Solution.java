
/*
118. Pascal's Triangle
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0){
            return res;
        }
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        res.add(first);

        for(int k=2; k<=numRows; k++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);

            for(int i=2; i<=k-1; i++){
                temp.add(res.get(k-2).get(i-1) + res.get(k-2).get(i-2));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;

    }
}
