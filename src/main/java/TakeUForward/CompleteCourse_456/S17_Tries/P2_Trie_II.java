package TakeUForward.CompleteCourse_456.S17_Tries;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S17_Tries
 * <p>
 * User: piyushbajaj
 * Date: 12/01/23
 * Time: 5:26 pm
 */
public class P2_Trie_II {
    private static Node root;

    P2_Trie_II() {
        root = new Node();
    }

    public static void main(String[] args) {
        P2_Trie_II p2_trie_ii = new P2_Trie_II();
        p2_trie_ii.insert("apple");
        p2_trie_ii.insert("apple");
        p2_trie_ii.insert("apps");
        p2_trie_ii.insert("apps");
        System.out.println(p2_trie_ii.countWordsEqualTo("apps"));
        System.out.println(p2_trie_ii.countWordsEqualTo("abc"));

        System.out.println(p2_trie_ii.countWordsStartingWith("ap"));
        System.out.println(p2_trie_ii.countWordsStartingWith("appl"));

        System.out.println(p2_trie_ii.countWordsEqualTo("apps"));
        p2_trie_ii.erase("apps");
        System.out.println(p2_trie_ii.countWordsEqualTo("apps"));
    }

    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.countPrefix++;
        }
        node.countEndWith++;
    }

    public int countWordsEqualTo(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return;
            }
            node = node.get(word.charAt(i));
            node.reducePrefix();
        }
        node.deleteEnd();
    }

    static class Node {
        Node[] links = new Node[26];
        int countEndWith = 0;
        int countPrefix = 0;

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void increaseEnd() {
            countEndWith++;
        }

        public void increasePrefix() {
            countPrefix++;
        }

        public void deleteEnd() {
            countEndWith--;
        }

        public void reducePrefix() {
            countPrefix--;
        }

        public int getEnd() {
            return countEndWith;
        }

        public int getPrefix() {
            return countPrefix;
        }
    }
}
