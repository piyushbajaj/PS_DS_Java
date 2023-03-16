package TakeUForward.Blind75.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 1:47 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/description/">...</a>
 */
public class P5_LevelOrderTraversal {
    /**
     * Iterative Way
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();

        // Add the root
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int currSize = treeNodeQueue.size();
            List<Integer> subResult = new ArrayList<>();

            while (currSize-- > 0) {
                TreeNode curr = treeNodeQueue.remove();
                subResult.add(curr.data);

                if (curr.left != null) {
                    treeNodeQueue.offer(curr.left);
                }

                if (curr.right != null) {
                    treeNodeQueue.offer(curr.right);
                }
            }

            result.add(subResult);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        P5_LevelOrderTraversal p5_levelOrderTraversal = new P5_LevelOrderTraversal();
        System.out.println(p5_levelOrderTraversal.levelOrder(root));
    }
}
