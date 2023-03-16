package TakeUForward.Blind75.Tree;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 12:55 pm
 * lc: <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">...</a>
 */
public class P1_Max_Depth {
    public int maxDepth(TreeNode node) {
        // base here
        if (node == null) {
            return 0;
        }

        int lHeight = maxDepth(node.left);
        int rHeight = maxDepth(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        P1_Max_Depth p1_max_depth = new P1_Max_Depth();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(p1_max_depth.maxDepth(node));
    }
}
