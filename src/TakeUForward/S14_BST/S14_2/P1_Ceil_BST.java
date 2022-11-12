package TakeUForward.S14_BST.S14_2;

import java.util.Arrays;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 05/10/22
 * Time: 2:00 pm
 * <p>
 * Ceil(X) is a number that is either equal to X or is immediately greater than X.
 */
public class P1_Ceil_BST {

    static class Value {
        int floor = -1;
        int ceil = -1;
    }

    /**
     * TC: O(logN)
     * SC: O(logN)
     *
     * @param root
     * @param key
     * @return
     */
    public int[] findCeilFloor(TreeNode root, int key) {
        Value value = new Value();

        findCeilFloor_util(root, key, Integer.MIN_VALUE, Integer.MAX_VALUE, value);

        return new int[] {value.ceil, value.floor};
    }

    public void findCeilFloor_util(TreeNode root, int key, int min, int max, Value value) {
        if (root == null) {
            return;
        }

        if (root.data == key) {
            value.ceil = root.data;
            value.floor = root.data;
        }

        if (root.data < key) {
            value.floor = root.data;
            findCeilFloor_util(root.right, key, root.data, max, value);
        } else {
            value.ceil = root.data;
            findCeilFloor_util(root.left, key, min, root.data, value);
        }
    }

    public static void main(String[] args) {
        P1_Ceil_BST p1_ceil_bst = new P1_Ceil_BST();

        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

        System.out.println(Arrays.toString(p1_ceil_bst.findCeilFloor(root, 45)));
    }
}
