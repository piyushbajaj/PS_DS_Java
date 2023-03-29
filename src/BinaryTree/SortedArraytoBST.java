package BinaryTree;

/**
 * Created by piyush.bajaj on 25/12/16.
 * In sorted array it will use the algorithm of PreOrder
 */
public class SortedArraytoBST {
    Node root;

    public SortedArraytoBST() {
        root = null;
    }

    public SortedArraytoBST(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        SortedArraytoBST tree = new SortedArraytoBST();

        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;

        Node root = tree.SortedArraytoBST_Recur(arr, 0, n - 1);

        System.out.println("Root: " + root.data);
        System.out.println("Root (" + root.data + ") -> Left: " + root.left.data);
        System.out.println("Root (" + root.data + ") -> Right: " + root.right.data);
        System.out.println("Root (" + root.data + ") -> Left (" + root.left.data + ") -> Left: " + root.left.left.data);
        System.out.println(
            "Root (" + root.data + ") -> Left (" + root.left.data + ") -> Right: " + root.left.right.data);
        System.out.println(
            "Root (" + root.data + ") -> Right (" + root.right.data + ")-> Left: " + root.right.left.data);
        System.out.println(
            "Root (" + root.data + ") -> Right (" + root.right.data + ") -> Right: " + root.right.right.data);

        System.out.print("Using InOrder Traversal: ");
        tree.inOrderTraversal(root);

    }

    public Node SortedArraytoBST_Recur(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        Node root = new Node(arr[mid]);

        //Processleft subtree

        root.left = SortedArraytoBST_Recur(arr, start, mid - 1);

        root.right = SortedArraytoBST_Recur(arr, mid + 1, end);

        return root;
    }

    public void inOrderTraversal(Node key) {
        if (key == null) {
            return;
        }

        inOrderTraversal(key.left);
        System.out.print(key.data + " ");
        inOrderTraversal(key.right);
    }

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
