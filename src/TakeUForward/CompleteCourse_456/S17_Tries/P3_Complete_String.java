package TakeUForward.CompleteCourse_456.S17_Tries;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S17_Tries
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 9:50 am
 */
public class P3_Complete_String {

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public Node() {
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }
    }

    static class Trie {
        private static Node root;

        Trie() {
            root = new Node();
        }

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

        public boolean checkIfPrefixExists(String word) {
            int n = word.length();
            Node node = root;

            for (int i = 0; i < n; i++) {
                if (!node.containsKey(word.charAt(i))) {
                    return false;
                }
                node = node.get(word.charAt(i));
                if (!node.isEnd()) {
                    return false;
                }
            }

            return true;
        }
    }

    public static String completeString(int n, String[] a) {
        Trie obj = new Trie();

        for (int i = 0; i < n; i++) {
            obj.insert(a[i]);
        }

        String longest = "";

        for (int i = 0; i < n; i++) {
            if (obj.checkIfPrefixExists(a[i])) {
                if (a[i].length() > longest.length()) {
                    longest = a[i];
                } else if (a[i].length() == longest.length() && a[i].compareTo(longest) < 0) {
                    longest = a[i];
                }
            }
        }
        return longest.length() > 0 ? longest : "None";
    }

    public static void main(String[] args) {
        P3_Complete_String p3_complete_string = new P3_Complete_String();
        System.out.println(p3_complete_string.completeString(6,
            new String[] {"n", "ni", "nin", "ninj", "ninja", "ninga"}));
    }
}
