package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 07/10/22
 * Time: 2:21 pm
 * <p>
 * Approach 1:
 * 1. Sort the BT using Inorder, then the value next to the key, will be successor, and the value previous will be
 * predecessor.
 * TC: O(N)
 * SC: O(N)
 * <p>
 * Approach 2:
 * 1. While finding the inorder, lets find the just bigger value than key.
 * TC: O(N)
 * SC: O(1)
 * <p>
 * Approach 3:
 * 1. Going in the BST pattern
 * TC: O(logN)
 * SC: O(1)
 */
public class P8_Inorder_Successor_Predecessor {
    public static void main(String[] args) {
        P8_Inorder_Successor_Predecessor p8_inorder_successor_predecessor = new P8_Inorder_Successor_Predecessor();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p8_inorder_successor_predecessor.inorderSuccessor(root, root).data);

        System.out.println(p8_inorder_successor_predecessor.inorderSuccessor_improved(root, root).data);

        System.out.println(p8_inorder_successor_predecessor.inorderPredecessor_improved(root, root).data);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        TreeNode[] pred = new TreeNode[1], succ = new TreeNode[1];

        inorderSuccessor_util(root, p, pred, succ);

        return succ[0];
    }

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        TreeNode[] pred = new TreeNode[1], succ = new TreeNode[1];

        inorderSuccessor_util(root, p, pred, succ);

        return succ[0];
    }

    public void inorderSuccessor_util(TreeNode root, TreeNode p, TreeNode[] pred, TreeNode[] succ) {
        if (root == null || p == null) {
            return;
        }

        if (root.data == p.data) {
            if (root.left != null) {
                TreeNode curr = root.left;
                while (curr.right != null) {
                    curr = curr.right;
                }
                pred[0] = curr;
            }
            if (root.right != null) {
                TreeNode curr = root.right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                succ[0] = curr;
            }
            return;
        }

        if (root.data < p.data) {
            pred[0] = root;
            inorderSuccessor_util(root.right, p, pred, succ);
        } else {
            succ[0] = root;
            inorderSuccessor_util(root.left, p, pred, succ);
        }
    }

    public TreeNode inorderSuccessor_improved(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    public TreeNode inorderPredecessor_improved(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;

        while (root != null) {
            if (p.data > root.data) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return predecessor;
    }
}
