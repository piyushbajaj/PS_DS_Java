package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_2_Medium;

import java.util.LinkedList;
import java.util.Queue;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Created by bajajp on 29 Sep, 2022
 * <p>
 * lc: <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1">...</a>
 */
public class P1_HeightOfTree {

    /**
     * Calculating Height recursively
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public int height_recur(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int lHeight = height_recur(curr.left);
        int rHeight = height_recur(curr.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    /**
     * Calculating Height iteratively, will use queue as this is going level by level
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public int height_iterative(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        Queue<TreeNode> heightQueue = new LinkedList<>();
        int height = 0;

        // default node
        heightQueue.add(curr);

        while (true) {
            int nodeCount = heightQueue.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;

            while (nodeCount > 0) {
                TreeNode currNode = heightQueue.remove();
                if (currNode.left != null) {
                    heightQueue.add(currNode.left);
                }
                if (currNode.right != null) {
                    heightQueue.add(currNode.right);
                }
                nodeCount--;
            }
        }
    }

    public static void main(String[] args) {
        P1_HeightOfTree p1_heightOfTree = new P1_HeightOfTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("Calculating Height of Binary Tree Recursively: " + p1_heightOfTree.height_recur(root));
        System.out.println("Calculating Height of Binary Tree Iteratively: " + p1_heightOfTree.height_iterative(root));
    }
}
