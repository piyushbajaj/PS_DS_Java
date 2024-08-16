package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 16/09/17.
 * Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary tree where every node has either 0 or 2
 * children. One more array ‘preLN[]’ is given which has only two possible values ‘L’ and ‘N’.
 * The value ‘L’ in ‘preLN[]’ indicates that the corresponding node in Binary Tree is a leaf node and
 * value ‘N’ indicates that the corresponding node is non-leaf node.
 * Write a function to construct the tree from the given two arrays
 */
public class constructSpecialTree {
    Node root;
    //Time Complexity: O(n)
    int index = 0;

    constructSpecialTree() {
        root = null;
    }

    constructSpecialTree(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            new Node(data);
        }
    }

    public static void main(String[] args) {
        constructSpecialTree ct = new constructSpecialTree();

        int[] pre = {10, 30, 20, 5, 15};

        char preLN[] = {'N', 'N', 'L', 'L', 'L'};

        ct.root = ct.constructTree(pre, preLN, pre.length);

        ct.printTree(ct.root);
    }

    public Node constructTree(int[] pre, char[] preLN, int end) {
        if (index == end) {
            return null;
        }

        Node key = new Node(pre[index]);
        int old_index = index;
        index++;

        if (preLN[old_index] == 'N') {
            key.left = constructTree(pre, preLN, end);
            key.right = constructTree(pre, preLN, end);
        }

        return key;

    }

    public void printTree(Node key) {
        if (key == null) {
            return;
        }

        printTree(key.left);
        System.out.print(key.data + " ");
        printTree(key.right);
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
