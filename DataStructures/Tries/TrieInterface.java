interface TrieInterface{

  // root TrieNode
  // has children, and we dont represent any letters. We represent letters as if the TrieNode has the ith child = has ith letter
  /*
  static class TrieNode{
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    TrieNode(){
      isEndOfWord = false;
      for(int i=0; i<ALPHABET_SIZE; i++){
        children[i] = null;
      }

    }
  }

  */

  void insert(String word);

  boolean hasWord(String word);

}
