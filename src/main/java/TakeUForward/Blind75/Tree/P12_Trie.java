package TakeUForward.Blind75.Tree;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 24/01/23
 * Time: 2:13 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">...</a>
 */
public class P12_Trie {
    private static Node root;

    P12_Trie() {
        root = new Node();
    }

    public static void main(String[] args) {
        P12_Trie p12_trie = new P12_Trie();
        p12_trie.insert("apple");
        p12_trie.insert("apps");
        p12_trie.insert("apxl");
        p12_trie.insert("bac");
        p12_trie.insert("bat");

        System.out.println("Search 'apps': " + p12_trie.search("apps"));
        System.out.println("Search 'appl': " + p12_trie.search("appl"));

        System.out.println("Starts With 'ba': " + p12_trie.startsWith("ba"));
        System.out.println("Starts With 'apd': " + p12_trie.startsWith("apd"));
    }

    // TC: O(word length)
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    /**
     * TC: O(len)
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    /**
     * TC: O(len)
     *
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        Node node = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }
    }
}
