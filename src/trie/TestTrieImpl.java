package trie;

public class TestTrieImpl {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
      //  t.insert("apples");
        t.insert("ape");
      //  t.insert("apes");
      //  t.insert("dad");
      //  t.insert("daddy");
        boolean isfound = t.search("apple");
        System.out.println("apple found? " + isfound);
       // boolean isStartsWith = t.startsWith("mad");
      //  System.out.println("starts with dad? " + isStartsWith);
    }
}
