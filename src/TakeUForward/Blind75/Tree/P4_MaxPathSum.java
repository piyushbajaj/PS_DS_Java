package TakeUForward.Blind75.Tree;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 1:44 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">...</a>
 */
public class P4_MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMaxSum_util(root, max);
        return max[0];
    }

    public int findMaxSum_util(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, findMaxSum_util(node.left, max));
        int right = Math.max(0, findMaxSum_util(node.right, max));

        max[0] = Math.max(max[0], node.data + left + right);

        return Math.max(left, right) + node.data;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        P4_MaxPathSum p4_maxPathSum = new P4_MaxPathSum();
        System.out.println(p4_maxPathSum.maxPathSum(root));

    }
}
