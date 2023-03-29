package BinaryTree;

/**
 * Created by piyush.bajaj on 27/07/17.
 * Given preorder traversal array for a binary search tree(BST),
 * without actually building the tree check if all internal nodes of BST have only one child.
 * <p>
 * For example, for the preorder array - {9, 8, 5, 7, 6} the BST would like the tree on the left hand side in below diagram.
 * All its internal nodes have only one child. But for the preorder array - {8, 5, 4, 7, 6} the BST would be the tree
 * shown on the right hand side in below diagram and as you can see node 5 has two children and
 * for this case output returned should be 'false'.
 */
public class BSTOneChild {
    Node root;

    BSTOneChild(int data) {
        if (root == null) {
            root = new Node(data);
        }
    }

    BSTOneChild() {

    }

    public static void main(String[] args) {
        BSTOneChild SN = new BSTOneChild();
        int[] arr = {8, 5, 4, 7, 6};
//        SN.root.left = new Node(1);
//        SN.root.right = new Node(2);
//        SN.root.left.left = new Node(3);
//        SN.root.left.right = new Node(4);
//        SN.root.left.left.right = new Node(6);
//        //SN.root.left.left.right.right = new Node(8);
//        SN.root.right.left = new Node(5);
//        SN.root.right.left.right = new Node(7);

        //SN.odd_deepest_depth(SN.root, 1);
        //System.out.println(count);

        System.out.println(SN.checkBSTOneChild(arr, arr.length));


    }

    public boolean checkBSTOneChild(int[] arr, int n) {
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] > arr[0]) {
                return false;
            }
            if (arr[i + 1] < arr[i] && arr[i + 2] > arr[i]) {
                return false;
            } else if (arr[i + 1] > arr[i] && arr[i + 2] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
