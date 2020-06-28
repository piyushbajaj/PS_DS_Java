package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 21/10/16.
 */
public class BST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree(int key) {
            root = new Node(key);
        }

        BinaryTree() {
            root = null;
        }


        public Node search(Node root, int key) {
            //root is null, or key is present at root
            if (root == null || root.data == key)
                return root;

            //if value is less than the root
            if (key < root.data)
                return search(root.left, key);
            else
                return search(root.right, key);
        }

        //Insertion of a key

        public void insertrec(int key){
            root = insert(root, key);

        }

        public Node insert(Node root, int key){
            if(root==null){
                root = new Node(key);
                System.out.println("Node inserted in the tree with value: " + key);
                return root;
            }

            if(key< root.data)
                return insert(root.left, key);
            else if( key > root.data)
                return insert(root.right, key);

            System.out.println("Same node is already present in the tree once");
            return root;
        }

        public void printTree(Node key){
            if(key == null)
                return;

            printTree(key.left);
            System.out.print(key.data + " ");
            printTree(key.right);
        }


        public static void main(String args[]) {
            BinaryTree BT = new BinaryTree();
            BT.root = new Node(3);
            System.out.println("Root of a binary tree is: " + BT.root.data);

            BT.root.left = new Node(2);

            BT.root.right = new Node(4);

            System.out.println("Root->left of a binary tree is: " + BT.root.left.data);

            System.out.println("Root->right of a binary tree is: " + BT.root.right.data);

            System.out.println("Root->left->left of a binary tree is: " + BT.root.left.left);

            System.out.println("Root->right->right of a binary tree is: " + BT.root.left.right);

            BT.root.left.left = new Node(1);

            BT.root.right.right = new Node(5);

            System.out.println("Root->left->left of a binary tree is: " + BT.root.left.left.data);

            System.out.println("Root->right->right of a binary tree is: " + BT.root.right.right.data);

            System.out.println("Node found using BST is: " + BT.search(BT.root, 6));

            BT.insertrec(6);


        }
    }
}