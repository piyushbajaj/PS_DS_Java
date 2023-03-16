package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import TakeUForward.CompleteCourse_456.S14_BST.Miscellaneous.P1_ConstructBST;
import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.P1_BT_Recur_Traversals;
import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 06/10/22
 * Time: 4:04 pm
 * <p>
 */
public class P4_KthLargestSmallestElement_BST {

    /**
     * Approach:
     * 1. Will follow In order approach here in reverse.
     * 2. Will going to the right, and if this is null, will keep reducing k, till
     * <p>
     * TC: O(min(K, N))
     *
     * @param root
     * @param k
     * @return
     */

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        // Initialize with k, so we can decrease it to 0 and get the answer
        TreeNode result = kthLargestElement(root, new int[] {k});
        if (result == null) {
            return -1;
        } else {
            return result.data;
        }
    }

    private TreeNode kthLargestElement(TreeNode root, int[] k) {
        if (root == null) {
            return null;
        }

        TreeNode right = kthLargestElement(root.right, k);
        if (right != null) {
            return right;
        }

        k[0]--;

        if (k[0] == 0) {
            return root;
        }

        return kthLargestElement(root.left, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        TreeNode result = kthSmallestElement(root, new int[] {k});
        if (result == null) {
            return -1;
        } else {
            return result.data;
        }
    }

    private TreeNode kthSmallestElement(TreeNode root, int[] k) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallestElement(root.left, k);
        if (left != null) {
            return left;
        }

        k[0]--;

        if (k[0] == 0) {
            return root;
        }

        return kthSmallestElement(root.right, k);
    }

    public static void main(String[] args) {
        P4_KthLargestSmallestElement_BST p4_kthLargestSmallestElement_bst = new P4_KthLargestSmallestElement_BST();

        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        TreeNode constructBST_root = P1_ConstructBST.constructBST(arr);
        System.out.println(P1_BT_Recur_Traversals.levelOrderTraversal_list_recur(constructBST_root));
        System.out.println(P1_BT_Recur_Traversals.inOrder_recur(constructBST_root));
        int k = 3;
        System.out.println("kthLargestElement for k: " + k + " is: " +
            p4_kthLargestSmallestElement_bst.kthLargest(constructBST_root, k));

        System.out.println("kthSmallestElement for k: " + k + " is: " +
            p4_kthLargestSmallestElement_bst.kthSmallest(constructBST_root, k));
    }
}
