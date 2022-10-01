package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by piyush.bajaj on 22/01/17.
 */
public class Trie {
    public class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public ArrayList<String> al;

    public Trie(){
        root = new TrieNode();
    }

    //Iterative implementation of insert into TRIE

    public void insert(String word){
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            System.out.print(current.children.keySet() + "->");
            current = node;

        }
        System.out.println("TRUE");
        current.endOfWord = true;
    }

    public boolean search(String word){
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    public void delete(String word){
        TrieNode current = root;
//        int index =0;
//        while (index < word.length()){
//
//        }

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                System.out.println("The word is not found");
                return;
            }
            current = node;
            //System.out.println(ch + "->");
            if(current.children.size() == 0) {
                current.children.remove(ch);
                return;
            }
            //System.out.println(current.children.keySet() + "->");
            System.out.println(ch + "->");
        }
        if(current.children.size() != 0)
            current.endOfWord = false;

    }


//    public String toString(){
//        al = new ArrayList<String>();
//
//        traverse(root, "");
//
//        return "\nTernary Search Tree : "+ al;
//    }
//
//    public void traverse(TrieNode key, String str){
//        if(key!=null){
//            traverse(key.children., str);
//
//            str = str + key.data;
//
//            if(key.is_End_Of_String)
//                al.add(str);
//
//            traverse(key.middle, str);
//
//            traverse(key.right, str);
//
//        }
//    }

    public void printTrie(Trie T){
        Set<Entry<Character,TrieNode>> hashSet= T.root.children.entrySet();

        for(Entry entry:hashSet ) {

            System.out.println("Key="+entry.getKey()+", Value="+entry.getValue());
        }

//        while (T.root!=null){
//            System.out.println(T.root.children.keySet());
//        }

    }

    public void insert_prac(String str){

    }

    public static void main(String[] args) {
        Trie T = new Trie();
        T.insert("abc");
        T.insert("abgl");
        T.insert("cdf");
        T.insert("abcd");
        T.insert("lmn");

        String search = "abcd";
        System.out.println("Can you find word: " + search + "? " + T.search(search));

        //System.out.println(T.root.children);

        //T.printTrie(T);

       T.delete(search);

        System.out.println("Can you find word: " + search + "? " + T.search(search));
    }


}
