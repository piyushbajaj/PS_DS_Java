package TakeUForward.CompleteCourse_456.S17_Tries;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S17_Tries.S17_1_Theory
 * <p>
 * User: piyushbajaj
 * Date: 12/01/23
 * Time: 2:17 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/implement-trie-prefix-tree/description/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/trie-insert-and-search0651/1">...</a>
 */
public class P1_Trie {
    private static Node root;

    P1_Trie() {
        root = new Node();
    }

    public static void main(String[] args) {
        P1_Trie p1_trie = new P1_Trie();
        p1_trie.insert("apple");
        p1_trie.insert("apps");
        p1_trie.insert("apxl");
        p1_trie.insert("bac");
        p1_trie.insert("bat");

        System.out.println("Search 'apps': " + p1_trie.search("apps"));
        System.out.println("Search 'appl': " + p1_trie.search("appl"));

        System.out.println("Starts With 'ba': " + p1_trie.startsWith("ba"));
        System.out.println("Starts With 'apd': " + p1_trie.startsWith("apd"));
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
