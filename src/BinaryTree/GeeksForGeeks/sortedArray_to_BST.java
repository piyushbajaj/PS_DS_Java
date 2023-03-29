package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 27/09/17.
 */
public class sortedArray_to_BST {
    Node root;

    sortedArray_to_BST() {
        root = null;
    }

    sortedArray_to_BST(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            new Node(data);
        }
    }

    public static void main(String[] args) {
        sortedArray_to_BST sb = new sortedArray_to_BST();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        sb.root = sb.convert_to_bst(arr, 0, arr.length - 1);

        sb.inOrderTraversal_Recur(sb.root);
    }

    public Node convert_to_bst(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int mid = (start + end) / 2;
            Node key = new Node(arr[mid]);
            key.left = convert_to_bst(arr, start, mid - 1);
            key.right = convert_to_bst(arr, mid + 1, end);

            return key;
        }

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
        boolean isThreaded;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
