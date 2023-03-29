package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 13/09/17.
 */
public class heightBalanced {
    Node root;

    public heightBalanced() {
        root = null;
    }

    public heightBalanced(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        heightBalanced BT = new heightBalanced(1);

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
        BT.root.right.right.right = new Node(8);
        //BT.root.right.right.right.right = new Node(9);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println(BT.height_bal(BT.root));

        System.out.println("Much improved complexity: " + BT.height_bal_improved(BT.root, new Height()));
    }

    public int getHeight(Node key) {
        if (key == null) {
            return 0;
        }

        int lCount = getHeight(key.left);
        int rCount = getHeight(key.right);

        return lCount > rCount ? lCount + 1 : rCount + 1;
    }

    //Time Complexity: O(n*n)
    public boolean height_bal(Node key) {
        if (key == null) {
            return true;
        }

        int left = getHeight(key.left);
        int right = getHeight(key.right);

        int diff = Math.abs(left - right);

        if (diff <= 1 && height_bal(key.left) && height_bal(key.right)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean height_bal_improved(Node key, Height height) {
        if (key == null) {
            height.height = 0;
            return true;
        }

        Height lHeight = new Height();
        Height rHeight = new Height();

        boolean left = height_bal_improved(key.left, lHeight);
        boolean right = height_bal_improved(key.right, rHeight);

        if (lHeight.height > rHeight.height) {
            height.height = lHeight.height + 1;
        } else {
            height.height = rHeight.height + 1;
        }

        int diff = Math.abs(lHeight.height - rHeight.height);

        if (diff >= 2) {
            return false;
        } else {
            return left && right;
        }

    }


    //Time Complexity: O(n)

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Height {
        int height = 0;
    }
}
