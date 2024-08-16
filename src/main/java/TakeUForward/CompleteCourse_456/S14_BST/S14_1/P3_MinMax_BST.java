package TakeUForward.CompleteCourse_456.S14_BST.S14_1;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_1
 * <p>
 * User: piyushbajaj
 * Date: 05/10/22
 * Time: 1:52 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1">...</a>
 */
public class P3_MinMax_BST {

    public static void main(String[] args) {
        P3_MinMax_BST p3_minMax_bst = new P3_MinMax_BST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("Max Value: " + p3_minMax_bst.maxValueInBST(root));
        System.out.println("Min Value: " + p3_minMax_bst.minValueInBST(root));
    }

    /**
     * TC: O(logN)
     *
     * @param curr
     * @return
     */
    public int minValueInBST(TreeNode curr) {
        if (curr == null) {
            return -1;
        }

        if (curr.left == null) {
            return curr.data;
        }

        return minValueInBST(curr.left);
    }

    /**
     * TC: O(logN)
     *
     * @param curr
     * @return
     */
    public int maxValueInBST(TreeNode curr) {
        if (curr == null) {
            return -1;
        }

        if (curr.right == null) {
            return curr.data;
        }

        return maxValueInBST(curr.right);
    }
}
