package BinaryTree;

/**
 * Created by piyush.bajaj on 24/09/16.
 */
public class BTreeIntro {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree{
        Node root;

        BinaryTree(int key){
            root = new Node(key);
        }

        BinaryTree(){
            root = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        BT.root = new Node(1);
        System.out.println("Root of a binary tree is: " + BT.root.data);

        System.out.println("Root->left of a binary tree is: " + BT.root.left);

        System.out.println("Root->right of a binary tree is: " + BT.root.right);

        BT.root.left = new Node(2);

        BT.root.right = new Node(3);

        System.out.println("Root->left of a binary tree is: " + BT.root.left.data);

        System.out.println("Root->right of a binary tree is: " + BT.root.right.data);

        System.out.println("Root->left->left of a binary tree is: " + BT.root.left.left);

        System.out.println("Root->left->right of a binary tree is: " + BT.root.left.right);

        BT.root.left.left = new Node(4);

        BT.root.left.right = new Node(5);

        System.out.println("Root->left->left of a binary tree is: " + BT.root.left.left.data);

        System.out.println("Root->left->right of a binary tree is: " + BT.root.left.right.data);


    }

}
