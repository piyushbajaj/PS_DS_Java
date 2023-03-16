package TakeUForward.Blind75.Tree;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 24/01/23
 * Time: 8:28 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/description/">...</a>
 */
public class P13_Design_Add_Search_Words {
    private static Node root;

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void setFlag() {
            flag = true;
        }
    }

    public P13_Design_Add_Search_Words() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new Node());
            }
            node = node.get(currentChar);
        }
        node.setFlag();
    }

    public boolean search(String word) {
        return search_dfs(word, root, 0);
    }

    public boolean search_dfs(String word, Node currNode, int startIndex) {
        for (int i = startIndex; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentChar == '.') {
                for (Node child : currNode.links) {
                    if (child != null && search_dfs(word, child, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!currNode.containsKey(currentChar)) {
                    return false;
                }
                currNode = currNode.get(currentChar);
            }
        }
        return currNode.flag;
    }

    public static void main(String[] args) {
        P13_Design_Add_Search_Words p13_design_add_search_words = new P13_Design_Add_Search_Words();
        p13_design_add_search_words.addWord("bad");
        p13_design_add_search_words.addWord("dad");
        p13_design_add_search_words.addWord("mad");
        System.out.println(p13_design_add_search_words.search("pad"));
        System.out.println(p13_design_add_search_words.search("bad"));
        System.out.println(p13_design_add_search_words.search(".ad"));
        System.out.println(p13_design_add_search_words.search("b.."));

//        p13_design_add_search_words.addWord("a");
//        p13_design_add_search_words.addWord("a");
//        System.out.println(p13_design_add_search_words.search("."));
//        System.out.println(p13_design_add_search_words.search("a"));
//        System.out.println(p13_design_add_search_words.search("aa"));
//        System.out.println(p13_design_add_search_words.search("a"));
//        System.out.println(p13_design_add_search_words.search(".a"));
//        System.out.println(p13_design_add_search_words.search("a."));
    }
}
