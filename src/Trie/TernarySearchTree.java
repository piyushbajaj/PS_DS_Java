package Trie;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyush.bajaj on 20/01/17.
 */
public class TernarySearchTree {

    private TSTNode root;
    private ArrayList<String> al;
    public TernarySearchTree() {
        root = null;
    }

    public static void main(String[] args) {
        TernarySearchTree tst = new TernarySearchTree();

        //TST.InsertInTST(TST, word);


        System.out.println("Ternary Search Tree Test\n");

        char ch;
        /*  Perform tree operations  */
        do {
            System.out.println("\nTernary Search Tree Operations\n");
            System.out.println("1. insert word");
            System.out.println("2. search word");
            System.out.println("3. delete word");
            System.out.println("4. check empty");
            System.out.println("5. make empty");
            System.out.println("6. Find length of largest word");

            //Scanner n = new Scanner(System.in);
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter word to insert");
                    tst.insert(new Scanner(System.in).next());
                    break;
                case 2:
                    System.out.println("Enter word to search");
                    System.out.println("Search result : " + tst.search(new Scanner(System.in).next()));
                    break;
                case 3:
                    System.out.println("Enter word to delete");
                    tst.delete(new Scanner(System.in).next());
                    break;
                case 4:
                    System.out.println("Empty Status : " + tst.isEmpty());
                    break;
                case 5:
                    System.out.println("Ternary Search Tree cleared");
                    tst.makeEmpty();
                    break;
                case 6:
                    System.out.println("Length of the largest word");
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            System.out.println(tst);

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = new Scanner(System.in).next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public void insert(String word) {
        root = insert(root, word.toCharArray(), 0);
    }

    public TSTNode insert(TSTNode key, char[] word, int pos) {
        if (key == null) {
            key = new TSTNode(word[pos]);
        }

        if (word[pos] < key.data) {
            key.left = insert(key.left, word, pos);
        } else if (word[pos] > key.data) {
            key.right = insert(key.right, word, pos);
        } else {
            if (pos + 1 < word.length) {
                key.middle = insert(key.middle, word, pos + 1);
            } else {
                key.is_End_Of_String = true;
            }
        }
        return key;
    }

    public void delete(String word) {
        delete(root, word.toCharArray(), 0);
    }

    public void delete(TSTNode key, char[] word, int pos) {
        if (key == null) {
            return;
        }

        if (word[pos] < key.data) {
            delete(key.left, word, pos);
        } else if (word[pos] > key.data) {
            delete(key.right, word, pos);
        } else {
            if (pos + 1 == word.length && key.is_End_Of_String) {
                key.is_End_Of_String = false;
            } else if (pos + 1 < word.length) {
                delete(key.middle, word, pos + 1);
            }
        }
    }

    /**
     * function to search for a word
     **/

    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    public boolean search(TSTNode key, char[] word, int pos) {
        if (key == null) {
            return false;
        }
        if (word[pos] < key.data) {
            return search(key.left, word, pos);
        } else if (word[pos] > key.data) {
            return search(key.right, word, pos);
        } else {
            if (pos + 1 == word.length && key.is_End_Of_String) {
                return true;
            } else if (pos + 1 == word.length) {
                return false;
            } else {
                return search(key.middle, word, pos + 1);
            }
        }
    }


    /**
     * function to print tree
     **/
    public String toString() {
        al = new ArrayList<String>();

        traverse(root, "");

        return "\nTernary Search Tree : " + al;
    }

    public void traverse(TSTNode key, String str) {
        if (key != null) {
            traverse(key.left, str);

            str = str + key.data;

            if (key.is_End_Of_String) {
                al.add(str);
            }

            traverse(key.middle, str);

            traverse(key.right, str);

        }
    }


//    public TSTNode InsertInTST(TSTNode root, String word){
//
//        root.data = word.charAt(0);
//        root.left = null;
//        root.eq = null;
//        root.right = null;
//        root.is_End_Of_String = false;
//
//        root = new TSTNode(root.data, root.is_End_Of_String, root.left, root.eq, root.right);
//
//        if(word.length() == 1)
//            root.is_End_Of_String = true;
//        else
//            root.eq = InsertInTST(root, word.substring(1));
//
//        return root;
//    }

//    public TSTNode searchPosition(TSTNode root, String word){
//        if(root == null)
//            return InsertInTST(root, word);
//
//        if(word.charAt(0) > root.data)
//            root.right = searchPosition(root.right, word);
//        else if(word.charAt(0) < root.data)
//            root.left = searchPosition(root.left, word);
//
//        else {
//
//        }
//    }

//    public void printTST(TSTNode key){
//        while (key!=null){
//            System.out.println("Data: " + key.data + "\tEnd of the String: " + key.is_End_Of_String + "\tLeft data: " + key.left
//            + "\tMiddle Data: " + key.eq + "\tRight Data: " + key.right);
//            //key = key.
//        }
//    }

    public static class TSTNode {

        char data;
        boolean is_End_Of_String;
        TSTNode left;
        TSTNode middle;
        TSTNode right;

        public TSTNode(char data) {
            this.data = data;
            this.is_End_Of_String = false;
            this.left = null;
            this.middle = null;
            this.right = null;
        }

    }
}
