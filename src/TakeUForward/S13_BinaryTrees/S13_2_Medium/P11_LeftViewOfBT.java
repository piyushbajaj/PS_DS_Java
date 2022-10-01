package TakeUForward.S13_BinaryTrees.S13_2_Medium;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by bajajp on 30 Sep, 2022
 */
public class P11_LeftViewOfBT {

    /**
     * Left View Iterative way
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> leftViewOfBT_iterative(TreeNode curr) {
        if (curr == null) return Collections.emptyList();

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

                    if (currNode.left != null) {
                        treeNodeQueue.offer(currNode.left);
                    }

                    if (currNode.right != null) {
                        treeNodeQueue.offer(currNode.right);
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
    public List<Integer> leftViewOfBT_recursive(TreeNode curr) {
        if (curr == null) return Collections.emptyList();

        List<Integer> arr = new ArrayList<>();
        leftViewOfBT_util_recursive(curr, arr, 0);
        return arr;
    }

    public void leftViewOfBT_util_recursive(TreeNode curr, List<Integer> arrList, int count) {
        if (curr != null) {
            if (arrList.size() == count) {
                arrList.add(curr.data);
            }
            leftViewOfBT_util_recursive(curr.left, arrList, count + 1);
            leftViewOfBT_util_recursive(curr.right, arrList, count + 1);
        }
    }

    public static void main(String[] args) {
        P11_LeftViewOfBT p11_leftViewOfBT = new P11_LeftViewOfBT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p11_leftViewOfBT.leftViewOfBT_iterative(root));

        System.out.println(p11_leftViewOfBT.leftViewOfBT_recursive(root));
    }
}
