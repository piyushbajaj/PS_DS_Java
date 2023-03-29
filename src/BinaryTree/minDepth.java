package BinaryTree;

/**
 * Created by piyush.bajaj on 23/07/17.
 */
public class minDepth {
    static int count = Integer.MAX_VALUE;
    Node root;

    minDepth(int data) {
        root = new Node(data);
    }

    public static void main(String[] args) {
        minDepth SN = new minDepth(0);
        SN.root.left = new Node(1);
        SN.root.right = new Node(2);
        SN.root.left.left = new Node(3);
        SN.root.left.right = new Node(4);
        SN.root.left.left.right = new Node(6);
        SN.root.left.left.right.right = new Node(8);
        SN.root.right.left = new Node(5);
        SN.root.right.left.right = new Node(7);

        SN.countMinDepth(SN.root, 1);
        System.out.println(count);
    }

    public void countMinDepth(Node key, int depth) {
        if (key == null) {
            return;
        }

        if (key.left == null && key.right == null) {
            if (depth < count) {
                count = depth;
            }
        }
        countMinDepth(key.left, depth + 1);
        countMinDepth(key.right, depth + 1);

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
