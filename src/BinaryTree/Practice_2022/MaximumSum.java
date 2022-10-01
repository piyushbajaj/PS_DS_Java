package BinaryTree.Practice_2022;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumSum extends CommonUtils {

    /*
    This is the variation of height calculation from Level order traversal using Queue
     */

    public int maximumSumLevel(TreeNode node) {
        if (node == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        queue.offer(null);
        int maxSum = 0;
        int sumAtEachLevel = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr != null) {
                sumAtEachLevel += curr.data;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            } else {
                if (maxSum < sumAtEachLevel) {
                    maxSum = sumAtEachLevel;
                }
                sumAtEachLevel = 0;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSum maximumSum = new MaximumSum();
        maximumSum.insertInBT(23);
        maximumSum.insertInBT(2);
        maximumSum.insertInBT(3);
        maximumSum.insertInBT(4);
        maximumSum.insertInBT(5);
        maximumSum.insertInBT(6);
        maximumSum.insertInBT(7);
        maximumSum.printBinaryTree_levelOrder(maximumSum.root);
        System.out.println();
        System.out.println(maximumSum.maximumSumLevel(maximumSum.root));
    }
}
