package BinaryTree.Practice_2022;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFSTraversal extends CommonUtils {
    /*
    TC: O(N)
    SC: O(N)
     */

    public static void main(String[] args) {
        BFSTraversal bfsTraversal = new BFSTraversal();
        bfsTraversal.root = new TreeNode(1);
        bfsTraversal.root.left = new TreeNode(2);
        bfsTraversal.root.right = new TreeNode(3);
        bfsTraversal.root.left.left = new TreeNode(4);
        bfsTraversal.root.left.right = new TreeNode(5);
        bfsTraversal.root.right.left = new TreeNode(6);
        bfsTraversal.root.right.right = new TreeNode(7);
        bfsTraversal.root.left.left.left = new TreeNode(8);
        bfsTraversal.root.right.right.right = new TreeNode(9);

        bfsTraversal.levelOrderIterative(bfsTraversal.root);
        System.out.println();
        bfsTraversal.levelOrderReverse(bfsTraversal.root);
        System.out.println();
        bfsTraversal.levelOrder_recursive(bfsTraversal.root);
        System.out.println();

        System.out.println(bfsTraversal.levelOrderIterativeArrayList(bfsTraversal.root));

        System.out.println(bfsTraversal.levelOrderIterativeArrayList_reverse(bfsTraversal.root));
    }

    public void levelOrderIterative(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public List<List<Integer>> levelOrderIterativeArrayList(TreeNode node) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (node == null) {
            return result;
        }

        queue.offer(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> subResult = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                    subResult.add(temp.data);
                }
            }
            result.add(subResult);
        }
        return result;
    }

    public List<List<Integer>> levelOrderIterativeArrayList_reverse(TreeNode node) {
        List<List<Integer>> result = new LinkedList<>();

        Stack<List<Integer>> stackResult = new Stack<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (node == null) {
            return result;
        }

        queue.offer(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> subResult = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                    subResult.add(temp.data);
                }
            }
            stackResult.add(subResult);
        }

        while (!stackResult.isEmpty()) {
            result.add(stackResult.pop());
        }
        return result;
    }

    public void levelOrder_recursive(TreeNode node) {
        int height = heightBinaryTree(node);

        for (int i = 1; i <= height; i++) {
            levelOrder_recursive_util(node, i);
        }
    }

    public void levelOrder_recursive_util(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.print(node.data + " ");
        } else {
            levelOrder_recursive_util(node.left, level - 1);
            levelOrder_recursive_util(node.right, level - 1);
        }
    }

    public void levelOrderReverse(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            stack.add(temp);
            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }
}
