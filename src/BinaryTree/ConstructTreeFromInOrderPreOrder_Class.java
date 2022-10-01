package BinaryTree;

/**
 * Created by piyush.bajaj on 29/12/16.
 */
public class ConstructTreeFromInOrderPreOrder_Class {
    Node root;

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public ConstructTreeFromInOrderPreOrder_Class() {
        root = null;
    }

    public ConstructTreeFromInOrderPreOrder_Class(int key) {
        root = new Node(key);
    }

    private int index = 0;

    public Node createTree(int[] inorder, int[] preorder) {
        return createTree(inorder, preorder, 0, inorder.length - 1);
    }

    public Node createTree(int[] inorder, int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[index] == inorder[i]) {
                break;
            }
        }
        Node node = new Node(preorder[index]);
        index++;
        node.left = createTree(inorder, preorder, start, i - 1);
        node.right = createTree(inorder, preorder, i + 1, end);
        return node;
    }

    public static void main(String[] args) {
        ConstructTreeFromInOrderPreOrder_Class BT = new ConstructTreeFromInOrderPreOrder_Class();
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};

        BT.root = BT.createTree(inOrder, preOrder);
        System.out.println("Root: " + BT.root.data);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
    }
}
