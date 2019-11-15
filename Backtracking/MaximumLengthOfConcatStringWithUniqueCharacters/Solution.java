class Solution {
    int res = 0;


    public int maxLength(List<String> arr) {
        int hs = 0;
        helper(arr, 0 , hs);
        return res;
    }

    public void helper(List<String> arr, int index, int hs){ 
        res = Math.max(res, countSetBits(hs));

        if(res == arr.size()){
            return;
        }
        //System.out.println(hs.toString());

        for(int i = index; i<arr.size(); i++){
            String cur = arr.get(i);

            if(valid(hs, cur) && validString(cur)){
                int newhs = addString(hs, cur);
                helper(arr, index + 1, newhs);
            }

        }
    }

    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    boolean validString(String s){
        int checker = 0;
        for(int i=0; i<s.length(); i++){
            int place = s.charAt(i) - 'a';
            if((checker & 1<< place )> 0) {
                return false;
            }
            checker = checker  | (1<<place);
        }
        return true;
    }

    boolean valid(int hs, String s){
        for(int i=0; i<s.length(); i++){
            int place = s.charAt(i) - 'a';
            if( (hs & 1<<place) > 0 ){
                return false;
            }
        }
        return true;
    }


    int addString(int hs, String s){
        for(int i=0; i<s.length(); i++){
            int place = s.charAt(i) - 'a';
            hs = hs |  (1<<place);
        }
        return hs;
    }

}
