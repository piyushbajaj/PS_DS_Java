package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.P1_BT_Recur_Traversals;
import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 08/10/22
 * Time: 4:30 pm
 * <p>
 * Approach 1:
 * 1. Get the inorder from the BST
 * 2. Sort the inorder
 * 3. While doing inorder traversal, compare node's value with the one in sorted order, and the one that doesnt match
 * change to that.
 * <p>
 * TC: O(N) + O(nlogN) + O(N) -> O(2N+NlogN)
 * SC: O(N)
 * <p>
 * Approach 2:
 * 1. Do the inorder traversal, and keep checking the data, store the first non-increasing and store the second
 * non-increasing
 * TC: O(N)
 * SC: O(1)
 */
public class P11_RecoverBST {
    public TreeNode swapNodes(TreeNode root) {
        TreeNode[] node1 = new TreeNode[1];
        TreeNode[] node2 = new TreeNode[1];
        swapNodes_util(root, new TreeNode[1], node1, node2);

        int temp = node1[0].data;
        node1[0].data = node2[0].data;
        node2[0].data = temp;

        return root;
    }

    public TreeNode swapNodes_util(TreeNode root, TreeNode[] prevNode, TreeNode[] node1, TreeNode[] node2) {
        if (root == null) {
            return null;
        }

        swapNodes_util(root.left, prevNode, node1, node2);
        if (prevNode[0] != null) {
            if (prevNode[0].data > root.data && node1[0] == null) {
                node1[0] = prevNode[0];
                node2[0] = root;
            } else if (prevNode[0].data > root.data) {
                node2[0] = root;
            }
        }
        prevNode[0] = root;
        swapNodes_util(root.right, prevNode, node1, node2);

        return root;
    }

    public static void main(String[] args) {
        P11_RecoverBST p11_recoverBST = new P11_RecoverBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(P1_BT_Recur_Traversals.levelOrderTraversal_recur(p11_recoverBST.swapNodes(root)));
    }
}
