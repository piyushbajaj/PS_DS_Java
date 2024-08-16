package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 08/10/22
 * Time: 7:24 pm
 * <p>
 * Approach 1:
 * 1. Validate BST for each node and keep counting the nodes
 * TC: O(N*N)
 * <p>
 * Approach 2:
 * 1. Lets store maxSize, minNode and maxNode for each node starting from left most bottom in post order fashion.
 * 2. If leftSide max node value is less than current root, and current root is less than right side min node value,
 * then it satisfies BST property
 * 3. Else it doesn't satisfy and return node value with Integer max and min
 * TC: O(N)
 * SC: O(1)
 */
public class P12_LargestBST_IN_BT {
    public static void main(String[] args) {
        P12_LargestBST_IN_BT p12_largestBST_in_bt = new P12_LargestBST_IN_BT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p12_largestBST_in_bt.largestBST(root));
    }

    public int largestBST(TreeNode root) {
        return largestBST_util(root).maxSize;
    }

    /**
     * Following post order approach
     *
     * @param root
     * @return
     */
    public NodeValue largestBST_util(TreeNode root) {
        if (root == null) {
            return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeValue leftLargestBST = largestBST_util(root.left);
        NodeValue rightLargestBST = largestBST_util(root.right);

        // Check if this satisfies BST property
        if (leftLargestBST.maxNode < root.data && root.data < rightLargestBST.minNode) {
            return new NodeValue(leftLargestBST.maxSize + rightLargestBST.maxSize + 1,
                Math.min(leftLargestBST.minNode, root.data), Math.max(rightLargestBST.maxNode, root.data));
        }

        // else return extremes
        return new NodeValue(Math.max(leftLargestBST.maxSize, rightLargestBST.maxSize), Integer.MIN_VALUE,
            Integer.MAX_VALUE);
    }

    static class NodeValue {
        int maxSize;
        int minNode;
        int maxNode;

        NodeValue(int maxSize, int minNode, int maxNode) {
            this.maxSize = maxSize;
            this.minNode = minNode;
            this.maxNode = maxNode;
        }
    }
}
