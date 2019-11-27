public class Solution{


  // make prefix and suffix table.
  
  int[] prefix_suffix_tabble(String pattern){

    // ABAB
    int[] table = pattern.length;

    int M = pattern.length();
    int i=0;
    int j=1;

    table[0] = 0;

    while(j<M){
      if(pattern.charAt(i) == pattern.charAt(j)){
        table[j] = i+1;
        i++;
        j++;
      }
      else{ // charAt(i) != charAt(j)


        if(i==0){ // cant go to previous, so just set it to 0 and move on. Almost our base case
          table[j] = 0;
          j++;
          continue;
        }

        // set i to the value of the previous and keep doing it
        int valueAtPrevious = table[i-1];
        i = valueAtPrevious;
      }
    }
    return table;
    // ith index indicates a prefix that is also a suffix from 0 including i. Cant be the whole String


  }
}
