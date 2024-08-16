package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.P1_BT_Recur_Traversals;
import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 06/10/22
 * Time: 12:35 pm
 * <p>
 */
public class P3_DeleteNode_BST {

    /**
     * Approach:
     * 1. Find the node in the binary tree
     * 2. As soon as we find, break the loop there, and then call the helper function with either root.left or root
     * .right, so we can replace with the deleted subtree, and we don't lose out the reference
     * 3. If there is no left, return right
     * 4. if there is no right, return left
     * 5. Get the right child node of the tree
     * 6. Get the right most child of the left of the node
     * <p>
     * TC: O(logN)
     * SC: O(H)
     *
     * @param root
     * @param data
     */
    public static void deleteNode(TreeNode root, int data) {
        if (root == null) {
            return;
        }

        if (root.data == data) {
            helper(root);
            return;
        }

        while (root != null) {
            if (root.data < data) {
                if (root.right != null && root.right.data == data) {
                    root.right = helper(root.right);
                    break;
                }
                root = root.right;
            } else {
                if (root.left != null && root.left.data == data) {
                    root.left = helper(root.left);
                    break;
                }
                root = root.left;
            }
        }
    }

    // This is the root to be deleted
    private static TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        TreeNode rightNode = root.right;
        TreeNode leftSideRightMostNode = rightMostNode(root.left);

        leftSideRightMostNode.right = rightNode;

        return root.left;
    }

    // Get the right most node from the left
    private static TreeNode rightMostNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return root;
        }

        return rightMostNode(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(
            "Printing BST in level order traversal: " + P1_BT_Recur_Traversals.levelOrderTraversal_recur(root));

        System.out.print("Printing BST post deletion of node: (" + root.right.data + ") is: ");

        P3_DeleteNode_BST.deleteNode(root, root.right.data);

        System.out.println(P1_BT_Recur_Traversals.levelOrderTraversal_recur(root));
    }
}
