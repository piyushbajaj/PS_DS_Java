package BinaryTree;

/**
 * Created by piyush.bajaj on 19/12/16.
 */
public class existenceOfPathForGivenSum {
    Node root;

    public existenceOfPathForGivenSum() {
        root = null;
    }

    public existenceOfPathForGivenSum(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        existenceOfPathForGivenSum BT = new existenceOfPathForGivenSum(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println("Is the sum of all the nodes equal to the value: " + BT.isPathExist(BT.root, 8));
    }

    public boolean isPathExist(Node key, int val) {
        if (key == null) {
            return false;
        }
        if (key.left == null && key.right == null && key.data == val) {
            return true;
        }
        return (isPathExist(key.left, val - key.data) || isPathExist(key.right, val - key.data));
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
