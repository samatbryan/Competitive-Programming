/*
Easy
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.


*/
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length/2;
        int[] diffs = new int[costs.length];
        HashMap<Integer, ArrayList<pair>> hm = new HashMap<Integer, ArrayList<pair>>();
        for(int i=0; i<costs.length; i++){
            int[] arr = costs[i];
            pair p = new pair(arr[0],arr[1]);
            int diff = Math.abs(arr[0]-arr[1]);
            diffs[i] = diff;
            if(hm.containsKey(diff)){
                hm.get(diff).add(p);
            }
            else{
                ArrayList<pair> a = new ArrayList<pair>();
                a.add(p);
                hm.put(diff,a);
            }
        }
        Arrays.sort(diffs);
        int abucket = 0;
        int bbucket = 0;
        int sum = 0;
        Set<Integer> s = new HashSet<Integer>();
        for(int i=diffs.length-1; i>=0; i--){
            if(s.contains(diffs[i])){
                continue;
            }
            s.add(diffs[i]);
            ArrayList<pair> aList = hm.get(diffs[i]);
            for(int j=0; j<aList.size(); j++){
                pair currPair = aList.get(j);
                if(currPair.x < currPair.y){
                    if(abucket>=N){
                        sum+=currPair.y;
                        bbucket +=1;
                    }
                    else{

                        abucket+=1;
                        sum+=currPair.x;
                    }
                }
                else{
                    if(bbucket>=N){

                        sum+=currPair.x;
                        abucket +=1;
                    }
                    else{

                        bbucket+=1;
                        sum+=currPair.y;
                    }

                }

            }
        }
        return sum;
    }

    static class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
