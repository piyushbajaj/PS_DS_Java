package BinaryTree.Practice_2022;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBT extends CommonUtils {
    public static void main(String[] args) {
        DepthOfBT depthOfBT = new DepthOfBT();
        depthOfBT.insertInBT(1);
        depthOfBT.root.left = new TreeNode(2);
        depthOfBT.root.right = new TreeNode(3);
//        depthOfBT.root.left.left = new TreeNode(4);
//        depthOfBT.root.left.right = new TreeNode(5);
        depthOfBT.root.right.left = new TreeNode(6);
        depthOfBT.root.right.right = new TreeNode(7);

        System.out.println(depthOfBT.minDepthOfBT_recursive(depthOfBT.root));
        System.out.println(depthOfBT.minDepthOfBT_iterative(depthOfBT.root));
        System.out.println(depthOfBT.minDepthOfBT_iterative_other(depthOfBT.root));
    }

    public int minDepthOfBT_recursive(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = minDepthOfBT_recursive(node.left);
        int rightDepth = minDepthOfBT_recursive(node.right);

        if (node.left == null) {
            return rightDepth + 1;
        }

        if (node.right == null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepthOfBT_iterative(TreeNode node) {
        if (node == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(1, node));

        while (!queue.isEmpty()) {
            int tempDepth = queue.peek().depth;
            TreeNode tempNode = queue.peek().node;

            queue.poll();

            if (tempNode.left == null && tempNode.right == null) {
                return tempDepth;
            }

            if (tempNode.left != null) {
                queue.offer(new QueueNode(tempDepth + 1, tempNode.left));
            }
            if (tempNode.right != null) {
                queue.offer(new QueueNode(tempDepth + 1, tempNode.right));
            }
        }
        return 0;
    }

    public int minDepthOfBT_iterative_other(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // End of level is defined with NULL
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        queue.offer(null);
        int count = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr != null) {
                if (curr.left == null && curr.right == null) {
                    return count;
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    count++;
                    queue.offer(null);
                }
            }
        }
        return count;
    }

    static class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
}
