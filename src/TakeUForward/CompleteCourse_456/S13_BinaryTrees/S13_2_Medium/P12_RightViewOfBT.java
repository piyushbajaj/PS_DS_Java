package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_2_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Created by bajajp on 30 Sep, 2022
 * <p>
 * lc: <a href="https://leetcode.com/problems/binary-tree-right-side-view/solutions/">...</a>
 */
public class P12_RightViewOfBT {
    /**
     * Right View Iterative way
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> rightViewOfBT_iterative(TreeNode curr) {
        if (curr == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(curr);

        while (!treeNodeQueue.isEmpty()) {
            int countOfNodesByLevel = treeNodeQueue.size();

            for (int i = 0; i < countOfNodesByLevel; i++) {
                TreeNode currNode = treeNodeQueue.poll();
                if (currNode != null) {
                    if (i == 0) {
                        result.add(currNode.data);
                    }

                    if (currNode.right != null) {
                        treeNodeQueue.offer(currNode.right);
                    }

                    if (currNode.left != null) {
                        treeNodeQueue.offer(currNode.left);
                    }
                }
            }
        }

        return result;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> rightViewOfBT_recursive(TreeNode curr) {
        if (curr == null) {
            return Collections.emptyList();
        }

        List<Integer> arr = new ArrayList<>();
        rightViewOfBT_util_recursive(curr, arr, 0);
        return arr;
    }

    public void rightViewOfBT_util_recursive(TreeNode curr, List<Integer> arrList, int count) {
        if (curr != null) {
            if (arrList.size() == count) {
                arrList.add(curr.data);
            }
            rightViewOfBT_util_recursive(curr.right, arrList, count + 1);
            rightViewOfBT_util_recursive(curr.left, arrList, count + 1);
        }
    }

    public static void main(String[] args) {
        P12_RightViewOfBT p12_rightViewOfBT = new P12_RightViewOfBT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p12_rightViewOfBT.rightViewOfBT_iterative(root));

        System.out.println(p12_rightViewOfBT.rightViewOfBT_recursive(root));
    }
}
