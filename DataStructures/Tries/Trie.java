public class Trie implements TrieInterface{
  public static final int ALPHABET_SIZE = 26;

  TrieNode root;

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

  Trie(){
    root = new TrieNode();
  }

  @Override
  public void insert(String word){
    int level, letter;
    int length = word.length();

    TrieNode pointer = root;
    for(level=0; level<length; level++){
      letter = word.charAt(level) - 'a';
      if(pointer.children[letter] == null){
        pointer.children[letter] = new TrieNode();
      }
      pointer = pointer.children[letter];
    }
    pointer.isEndOfWord = true;
  }

  @Override
  public boolean hasWord(String word){
    int level, letter = 0;
    int length = word.length();
    TrieNode pointer = root;

    for(level=0; level<length; level++){
      letter = word.charAt(level) - 'a';
      if(pointer.children[letter] == null){
        return false;
      }
      pointer = pointer.children[letter];
    }

    if(pointer != null && pointer.isEndOfWord){
      return true;
    }
    return false;

  }


  public static void main(String[] args){
    Trie t = new Trie();
    t.insert("word");
    t.insert("wording");
    System.out.println(t.hasWord("word"));
    System.out.println(    t.hasWord("wording"));
    System.out.println(    t.hasWord("wordd"));
    System.out.println(    t.hasWord("wor"));
    System.out.println(    t.hasWord("a"));


  }
}
