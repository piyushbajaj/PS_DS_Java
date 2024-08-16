package TakeUForward.Blind75.Tree;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 24/01/23
 * Time: 12:52 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">...</a>
 */
public class P10_Kth_Smallest_Element {
    public static void main(String[] args) {
        P10_Kth_Smallest_Element p10_kth_smallest_element = new P10_Kth_Smallest_Element();

        // Inserting into tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p10_kth_smallest_element.kthSmallest(root, 2));

    }

    public int kthSmallest(TreeNode root, int k) {
        // Initializing with k, so we can keep reducing this
        TreeNode result = kthSmallest_util(root, new int[] {k});
        return result != null ? result.data : -1;
    }

    // Following In Order way, reducing k
    public TreeNode kthSmallest_util(TreeNode root, int[] kthSection) {
        if (root == null) {
            return null;
        }

        TreeNode leftSide = kthSmallest_util(root.left, kthSection);
        if (leftSide != null) {
            return leftSide;
        }

        kthSection[0]--;

        if (kthSection[0] == 0) {
            return root;
        }

        return kthSmallest_util(root.right, kthSection);
    }
}
