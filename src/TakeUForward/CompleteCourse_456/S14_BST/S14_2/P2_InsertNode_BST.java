package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.P1_BT_Recur_Traversals;
import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 06/10/22
 * Time: 8:50 am
 * <p>
 */
public class P2_InsertNode_BST {

    /**
     * TC: O(logN)
     *
     * @param root
     * @param value
     * @return
     */
    public static TreeNode insertNode(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value > root.data) {
            root.right = insertNode(root.right, value);
        } else if (value < root.data) {
            root.left = insertNode(root.left, value);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        insertNode(root, 10);

        System.out.println(P1_BT_Recur_Traversals.levelOrderTraversal_recur(root));
    }
}
