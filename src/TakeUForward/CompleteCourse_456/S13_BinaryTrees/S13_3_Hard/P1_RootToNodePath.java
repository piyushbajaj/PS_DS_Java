package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_3_Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S13_BinaryTrees.S13_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 01/10/22
 * Time: 8:31 pm
 * <p>
 * Link: <a href="https://takeuforward.org/data-structure/print-root-to-node-path-in-a-binary-tree/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1">...</a>
 * lc: <a href="https://leetcode.com/problems/binary-tree-paths/">...</a>
 */
public class P1_RootToNodePath {

    public List<Integer> printRootToLeafPath(TreeNode curr, int key) {
        List<Integer> result = new ArrayList<>();
        if (curr == null) {
            return result;
        }

        return printRootToLeafPath_util(curr, result, key) ? result : Collections.emptyList();
    }

    /**
     * Approach:
     * 1. We are following the property of Pre-Order in this.
     * 2. Inserting the current node in the array list every time
     * 3. Checking left node and right node, if the curr node matches with the key provided then, then we have found
     * our path and return
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @param result
     * @param key
     * @return
     */
    public boolean printRootToLeafPath_util(TreeNode curr, List<Integer> result, int key) {
        if (curr == null) {
            return false;
        }

        result.add(curr.data);
        if (curr.data == key) {
            return true;
        }

        if (printRootToLeafPath_util(curr.left, result, key) || printRootToLeafPath_util(curr.right, result, key)) {
            return true;
        }

        result.remove(result.size() - 1);

        return false;
    }

    /**
     * @param curr
     * @return
     */
    public ArrayList<ArrayList<Integer>> printRootToLeafPath_better(TreeNode curr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (curr == null) {
            return result;
        }

        printRootToLeafPath_better_util(curr, result, new ArrayList<>());
        return result;
    }

    /**
     * @param curr
     * @param result
     * @param subResult
     */
    public void printRootToLeafPath_better_util(TreeNode curr, ArrayList<ArrayList<Integer>> result,
                                                ArrayList<Integer> subResult) {
        if (curr == null) {
            return;
        }

        subResult.add(curr.data);

        if (curr.left == null && curr.right == null) {
            result.add(subResult);
            return;
        }

        printRootToLeafPath_better_util(curr.left, result, new ArrayList<>(subResult));
        printRootToLeafPath_better_util(curr.right, result, new ArrayList<>(subResult));
    }

    public static void main(String[] args) {
        P1_RootToNodePath p1_rootToNodePath = new P1_RootToNodePath();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p1_rootToNodePath.printRootToLeafPath(root, 7));

        System.out.println(p1_rootToNodePath.printRootToLeafPath_better(root));

    }
}
