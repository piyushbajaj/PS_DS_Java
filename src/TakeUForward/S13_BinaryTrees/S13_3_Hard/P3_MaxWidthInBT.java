package TakeUForward.S13_BinaryTrees.S13_3_Hard;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S13_BinaryTrees.S13_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 02/10/22
 * Time: 9:04 am
 * <p>
 * Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class P3_MaxWidthInBT {

    /**
     * Will follow level order traversal for getting maximum width in a tree:
     * 1.
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public int maxWidth(TreeNode curr) {
        if (curr == null) return 0;

        int maxWidth = 0;
        // We need to store node and also its currentMin

        Queue<Pair<TreeNode, Integer>> treeNodeQueue = new LinkedList<>();

        // First node as default
        treeNodeQueue.offer(new Pair<>(curr, 0));

        while (!treeNodeQueue.isEmpty()) {
            int currQueueSize = treeNodeQueue.size();
            int minIndex = 0;
            if (currQueueSize >= 1) {
                minIndex = treeNodeQueue.peek().getValue();
            }

            int firstElementIndex = 0, lastElementIndex = 0;
            for (int i = 0; i < currQueueSize; i++) {
                Pair<TreeNode, Integer> currentTreeNodePair = treeNodeQueue.remove();

                TreeNode currNode = currentTreeNodePair.getKey();
                int currMinIndex = currentTreeNodePair.getValue() - minIndex;

                if (i == 0) {
                    firstElementIndex = currMinIndex;
                }
                if (i == currQueueSize - 1) {
                    lastElementIndex = currMinIndex;
                }

                if (currNode.left != null) {
                    treeNodeQueue.offer(new Pair<>(currNode.left, 2 * currMinIndex + 1));
                }
                if (currNode.right != null) {
                    treeNodeQueue.offer(new Pair<>(currNode.right, 2 * currMinIndex + 2));
                }
            }
            maxWidth = Math.max(maxWidth, lastElementIndex - firstElementIndex + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        P3_MaxWidthInBT p3_maxWidthInBT = new P3_MaxWidthInBT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p3_maxWidthInBT.maxWidth(root));
    }
}
