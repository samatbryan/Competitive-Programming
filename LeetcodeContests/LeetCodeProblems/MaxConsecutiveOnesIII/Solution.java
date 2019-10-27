/*
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.
*/





class Solution {
    public int longestOnes(int[] A, int K) {
// sliding window until we have k zeros. once we have more, start from our left pointer and move it up until we find enough zeros to remove.
        int z = 0;
        int res = 0;
        int left = 0;
        int max = 0;
        for(int i=0;i<A.length; i++){
            if(A[i] == 1){
                res +=1;
            }
            else{
                res+=1;
                z+=1;
                while(z>K){
                    if(A[left] == 0){
                        res -=1;
                        left +=1;
                        z-=1;
                    }
                    else{
                        res-=1;
                        left+=1;
                    }
                }
            }
            max = Math.max(res,max);
        }
        return max;
    }
}
