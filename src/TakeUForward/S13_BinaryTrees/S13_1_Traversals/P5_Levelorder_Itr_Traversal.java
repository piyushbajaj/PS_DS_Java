package TakeUForward.S13_BinaryTrees.S13_1_Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by bajajp on 29 Sep, 2022
 */
public class P5_Levelorder_Itr_Traversal {

    /**
     * Level by level print from root to leaf
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> levelOrderTraversal_iterative(TreeNode curr) {
        if (curr == null) return null;

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(curr);

        while (!levelOrderQueue.isEmpty()) {
            TreeNode currNode = levelOrderQueue.poll();
            result.add(currNode.data);

            if (currNode.left != null) {
                levelOrderQueue.add(currNode.left);
            }
            if (currNode.right != null) {
                levelOrderQueue.add(currNode.right);
            }
        }
        return result;
    }

    /**
     * Using 2 Stacks for Spiral, one for inserting in the left and right separately
     *
     * @param curr
     * @return
     */
    public List<Integer> levelOrderTraversal_spiral_iterative(TreeNode curr) {
        if (curr == null) return null;

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> levelOrderStack1 = new Stack<>();
        Stack<TreeNode> levelOrderStack2 = new Stack<>();

        levelOrderStack1.push(curr);

        while (!levelOrderStack1.isEmpty() || !levelOrderStack2.isEmpty()) {

            while (!levelOrderStack1.isEmpty()) {
                TreeNode currNode = levelOrderStack1.pop();
                result.add(currNode.data);

                if (currNode.right != null) {
                    levelOrderStack2.push(currNode.right);
                }
                if (currNode.left != null) {
                    levelOrderStack2.push(currNode.left);
                }
            }

            while (!levelOrderStack2.isEmpty()) {
                TreeNode currNode = levelOrderStack2.pop();
                result.add(currNode.data);

                if (currNode.left != null) {
                    levelOrderStack1.push(currNode.left);
                }
                if (currNode.right != null) {
                    levelOrderStack1.push(currNode.right);
                }
            }
        }
        return result;
    }

    /**
     * Level Order Traversal in Reverse
     * TC:
     *
     * @param curr
     * @return
     */
    public List<List<Integer>> levelOrderTraversal_reverse_iterative(TreeNode curr) {
        if (curr == null) return null;

        List<List<Integer>> result = new ArrayList<>();

        // To store the normal traversal
        Queue<TreeNode> levelOrderReverseQueue = new LinkedList<>();

        // To store the results
        Stack<List<Integer>> levelOrderStack = new Stack<>();
        levelOrderReverseQueue.add(curr);

        while (!levelOrderReverseQueue.isEmpty()) {
            int currQueueSize = levelOrderReverseQueue.size();
            List<Integer> subResult = new ArrayList<>();

            for (int i = 1; i <= currQueueSize; i++) {
                TreeNode currNode = levelOrderReverseQueue.remove();

                if (currNode.left != null) {
                    levelOrderReverseQueue.add(currNode.left);
                }
                if (currNode.right != null) {
                    levelOrderReverseQueue.add(currNode.right);
                }
                subResult.add(currNode.data);
            }
            levelOrderStack.push(subResult);
        }

        while (!levelOrderStack.isEmpty()) {
            result.add(levelOrderStack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        P5_Levelorder_Itr_Traversal p5_levelorder_itr_traversal = new P5_Levelorder_Itr_Traversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("Level Order Traversal: " + p5_levelorder_itr_traversal.levelOrderTraversal_iterative(root));

        System.out.println("Spiral Level Order Traversal: " + p5_levelorder_itr_traversal.levelOrderTraversal_spiral_iterative(root));

        System.out.println("Reversal Level Order Traversal: " + p5_levelorder_itr_traversal.levelOrderTraversal_reverse_iterative(root));
    }
}
