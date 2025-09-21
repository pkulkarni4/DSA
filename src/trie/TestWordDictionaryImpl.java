package trie;

public class TestWordDictionaryImpl {
    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.insert("send");
        w.insert("sent");
        w.insert("seen");
        w.insert("been");
        w.insert("beat");
        w.insert("berry");
        w.insert("meet");
        w.insert("seat");

        //w.print();
        System.out.println("search for sen." + w.searchWithWildCards("sen."));
        System.out.println("search for beat." + w.searchWithWildCards("beat."));
        System.out.println("search for abcd." + w.searchWithWildCards("abcd."));
    }
}
