package Objects;

public class Trie {

    private final Trie[] tries;
    private boolean isWord;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this(false);
    }

    private Trie(boolean isWord) {
        this.isWord = isWord;
        tries = new Trie[26];
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Yoink");
        trie.search("Yoink");
        trie.startsWith("Yoin");
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }
        char nextChar = word.charAt(0);
        Trie trie = tries[nextChar - 'a'];
        if (trie != null) {
            if (word.length() == 1) {
                trie.isWord = true;
            } else {
                trie.insert(word.substring(1));
            }
            return;
        }
        Trie newTrie = new Trie(word.length() == 1);
        tries[nextChar - 'a'] = newTrie;
        if (word.length() > 1) {
            newTrie.insert(word.substring(1));
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.isEmpty()) {
            return false;
        }
        char nextChar = word.charAt(0);
        Trie trie = tries[nextChar - 'a'];
        if (trie != null) {
            if (word.length() == 1) {
                return trie.isWord;
            } else {
                return trie.search(word.substring(1));
            }
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return false;
        }
        char nextChar = prefix.charAt(0);
        Trie trie = tries[nextChar - 'a'];
        if (trie != null) {
            if (prefix.length() == 1) {
                return true;
            } else {
                return trie.startsWith(prefix.substring(1));
            }
        }
        return false;
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
