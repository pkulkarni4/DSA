package trie;

public class TestTrieImpl {
    public static void main(String[] args) {
        TriePrefixTree t = new Trie();
        t.insert("seen");
        t.insert("been");
        t.insert("beat");
        t.insert("berry");
        t.insert("meet");
        t.insert("seat");

        System.out.println("search seen: " + t.search("seen"));
        System.out.println("search been: " + t.search("been"));
        System.out.println("starts with be? " + t.startsWith("be"));
        System.out.println("starts with se? " + t.startsWith("se"));

       // t.print();
    }
}
