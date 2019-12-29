import java.util.*;

public class isomorphic_groups {

  public static ArrayList<ArrayList<String>> solve(ArrayList<String> arr) {
    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    HashMap<ArrayList<Integer>, ArrayList<String>> hm =
        new HashMap<ArrayList<Integer>, ArrayList<String>>();
    for (String str : arr) {
      ArrayList<Integer> aList = StringToIntArray(str);
      if (hm.containsKey(aList)) {
        hm.get(aList).add(str);
      } else {
        hm.put(aList, new ArrayList<String>());
        hm.get(aList).add(str);
        res.add(hm.get(aList));
      }
    }
    return res;
  }

  public static ArrayList<Integer> StringToIntArray(String s) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    int[] seen = new int[26];
    for (int i = 0; i < 26; i++) {
      seen[i] = -1;
    }
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (seen[c - 'a'] == -1) { // unseen character
        res.add(count);
        seen[c - 'a'] = count;
        count += 1;
      } else {
        res.add(seen[c - 'a']);
      }
    }
    return res;
  }

  public static void printList(ArrayList<Integer> al) {
    for (Integer i : al) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void printThis(ArrayList<String> al) {
    for (String i : al) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void printAnswer(ArrayList<ArrayList<String>> input) {
    for (ArrayList<String> a : input) {
      printThis(a);
    }
  }

  public static void main(String[] args) {
    String y0 = "xyz";
    String y1 = "abc";
    String y2 = "def";
    String y3 = "xyx";
    String y4 = "aab";
    String y5 = "xxy";

    ArrayList<String> input = new ArrayList<String>();
    input.add(y0);
    input.add(y1);
    input.add(y2);
    input.add(y3);
    input.add(y4);
    input.add(y5);

    ArrayList<ArrayList<String>> output = solve(input);
    printAnswer(output);
  }
}
