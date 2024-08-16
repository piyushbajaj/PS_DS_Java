package TechBoost_Old;

/**
 * Created by piyush.bajaj on 28/04/18.
 */
public class BT_isBST_prob {
    BTNode root;
    BTNode root1;

    public static void main(String[] args) {
        BT_isBST_prob BT = new BT_isBST_prob();
//        BT.insert_BST(BT.root,4);
//        BT.insert_BST(BT.root,1);
//        BT.insert_BST(BT.root,2);
//        BT.insert_BST(BT.root,3);
//        BT.insert_BST(BT.root,5);
//        BT.insert_BST(BT.root,6);
//        BT.insert_BST(BT.root,7);

        BT.root = new BTNode(2);
        BT.root.left = new BTNode(3);
        BT.root.right = new BTNode(4);
        BT.root.left.left = new BTNode(5);
        BT.root.left.right = new BTNode(6);

        BT.printTree(BT.root);
        System.out.println(BT.isBST(BT.root));
    }

    public void printTree(BTNode key) {
        if (key == null) {
            return;
        }

        printTree(key.left);
        System.out.print(key.data + " ");
        printTree(key.right);
    }

    public BTNode insert_BST(BTNode key, int value) {
        BTNode temp = new BTNode(value);
        //BTNode key = root;

        if (key == null) {
            if (root == null) {
                root = temp;
                return root;
            }

            key = temp;
            return key;
        } else {
            if (value < key.data) {
                key.left = insert_BST(key.left, value);
            } else {
                key.right = insert_BST(key.right, value);
            }
        }
        return key;
    }

    public boolean isBST(BTNode key) {
        if (key == null) {
            return true;
        }

        return isBSTUtil(key, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean isBSTUtil(BTNode key, int max, int min) {
        if (key == null) {
            return true;
        }

        if (key.data < min || key.data > max) {
            return false;
        }

        return isBSTUtil(key.left, key.data, Integer.MIN_VALUE) && isBSTUtil(key.right, Integer.MAX_VALUE, key.data);
    }

    static class BTNode {
        BTNode left, right;
        int data;

        BTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
