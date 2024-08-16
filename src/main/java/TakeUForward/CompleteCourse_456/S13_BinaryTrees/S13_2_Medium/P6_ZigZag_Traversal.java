package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_2_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Created by bajajp on 29 Sep, 2022
 * Link: <a href="https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1">...</a>
 * lc: <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">...</a>
 */
public class P6_ZigZag_Traversal {

    public static void main(String[] args) {
        P6_ZigZag_Traversal p6_zigZag_traversal = new P6_ZigZag_Traversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p6_zigZag_traversal.levelOrderTraversal_spiral_iterative(root));
        System.out.println(p6_zigZag_traversal.levelOrderTraversal_spiral_iterative_better(root));
    }

    /**
     * Using 2 Stacks for Spiral, one for inserting in the left and right separately
     *
     * @param curr
     * @return
     */
    public List<List<Integer>> levelOrderTraversal_spiral_iterative(TreeNode curr) {
        if (curr == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        Stack<TreeNode> levelOrderStack1 = new Stack<>();
        Stack<TreeNode> levelOrderStack2 = new Stack<>();

        levelOrderStack1.push(curr);

        while (!levelOrderStack1.isEmpty() || !levelOrderStack2.isEmpty()) {

            List<Integer> subResult = new ArrayList<>();
            while (!levelOrderStack1.isEmpty()) {
                TreeNode currNode = levelOrderStack1.pop();
                subResult.add(currNode.data);

                if (currNode.left != null) {
                    levelOrderStack2.push(currNode.left);
                }
                if (currNode.right != null) {
                    levelOrderStack2.push(currNode.right);
                }
            }
            if (!subResult.isEmpty()) {
                result.add(subResult);
            }

            subResult = new ArrayList<>();
            while (!levelOrderStack2.isEmpty()) {
                TreeNode currNode = levelOrderStack2.pop();
                subResult.add(currNode.data);

                if (currNode.right != null) {
                    levelOrderStack1.push(currNode.right);
                }
                if (currNode.left != null) {
                    levelOrderStack1.push(currNode.left);
                }
            }
            if (!subResult.isEmpty()) {
                result.add(subResult);
            }
        }
        return result;
    }

    /**
     * Better with one queue approach than previous
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<List<Integer>> levelOrderTraversal_spiral_iterative_better(TreeNode curr) {
        if (curr == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> levelOrderQueue = new LinkedList<>();
        // Default node
        levelOrderQueue.offer(curr);
        boolean levelSwitchFlag = true;

        while (!levelOrderQueue.isEmpty()) {
            int countOfNodeByLevel = levelOrderQueue.size();

            List<Integer> subResult = new ArrayList<>(countOfNodeByLevel);
            // false means level 0th, 2nd, 4th..
            // true means level 1st, 3rd, 5th..


            for (int i = 0; i < countOfNodeByLevel; i++) {
                TreeNode currNode = levelOrderQueue.remove();

                if (currNode.left != null) {
                    levelOrderQueue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    levelOrderQueue.offer(currNode.right);
                }

                if (levelSwitchFlag) {
                    subResult.add(currNode.data);
                } else {
                    subResult.add(0, currNode.data);
                }
            }
            levelSwitchFlag = !levelSwitchFlag;
            result.add(subResult);
        }

        return result;
    }
}
