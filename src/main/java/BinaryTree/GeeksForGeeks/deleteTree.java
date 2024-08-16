package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 12/09/17.
 */
public class deleteTree {
    Node root;

    deleteTree() {
        root = null;
    }

    deleteTree(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            new Node(data);
        }
    }

    public static void main(String[] args) {
        deleteTree bfs = new deleteTree(1);
        bfs.root.left = new Node(2);
        bfs.root.right = new Node(3);
        bfs.root.left.left = new Node(4);
        bfs.root.left.right = new Node(5);
        bfs.root.right.left = new Node(6);
        bfs.root.right.right = new Node(7);

        bfs.inOrderTraversal_Recur(bfs.root);

        bfs.deleteTree_Recur(bfs.root);

        System.out.println();

        bfs.inOrderTraversal_Recur(bfs.root);

    }

    public Node deleteTree(Node key) {
        if (key == null) {
            return null;
        }

        key.left = deleteTree(key.left);

        key.right = deleteTree(key.right);

        if (key.left == null && key.right == null) {
            return null;
        }

        return key;

    }

    public Node deleteTree_Recur(Node key) {
        if (key == null) {
            return null;
        }

        deleteTree(key);

        if (key != null) {
            root = null;
        }

        return key;
    }

    //InOrder Traversal
    public void inOrderTraversal_Recur(Node key) {
        if (key == null) {
            return;
        }

        inOrderTraversal_Recur(key.left);
        System.out.print(key.data + " ");
        inOrderTraversal_Recur(key.right);
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
