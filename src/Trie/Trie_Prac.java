package Trie;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 23/08/17.
 */
public class Trie_Prac {
    //int size = 0;
    private final TrieNode root;

    public Trie_Prac() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie_Prac tp = new Trie_Prac();
        tp.insert("abc");
        tp.insert("abgl");
        tp.insert("cdf");
        tp.insert("abcd");
        tp.insert("lmn");

        String search = "abcd";
        System.out.println("Can you find word: " + search + "? " + tp.search(search));

        System.out.println(tp.delete_prac(tp.root, search, 0));


        System.out.println("Can you find word: " + search + "? " + tp.search(search));

        System.out.println(tp.search_count("abc"));

    }

    public void insert(String str) {
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {

            TrieNode Node = current.children.get(str.charAt(i));
            if (Node == null) {
                Node = new TrieNode();
                current.children.put(str.charAt(i), Node);
            }
            current.count++;
            current = Node;
        }
        current.endOfWord = true;
    }


    public boolean search(String str) {
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            TrieNode Node = current.children.get(str.charAt(i));
            if (Node == null) {
                return false;
            }
            current = Node;
        }
        if (current.endOfWord == true) {
            return true;
        } else {
            return false;
        }
    }

    public int search_count(String str) {
        TrieNode current = root;

        for (int i = 0; i < str.length(); i++) {
            TrieNode Node = current.children.get(str.charAt(i));
            if (Node == null) {
                return 0;
            }
            current = Node;
        }
        if (current != null && !current.endOfWord) {
            return current.count;
        } else if (current != null && current.endOfWord) {
            return current.count + 1;
        } else {
            return 0;
        }
    }

    public void delete(String str) {
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            TrieNode Node = current.children.get(str.charAt(i));
            if (Node == null) {
                return;
            }
            current = Node;
        }
        if (current.endOfWord == false) {
            current.endOfWord = true;
        }
        //else
        //return false;
    }

    private boolean delete_tushar(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete_tushar(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

    public boolean delete_prac(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;

            return current.children.size() == 0;
        }
        Character ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean should_delete_curr_node = delete_prac(node, word, index + 1);

        if (should_delete_curr_node) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean endOfWord;
        int count;

        TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
            count = 0;
        }
    }
}
