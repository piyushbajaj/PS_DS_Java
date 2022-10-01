package TakeUForward.S13_BinaryTrees.S13_2_Medium;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bajajp on 30 Sep, 2022
 */
public class P7_BoundaryTraversal {
    /**
     * Approach:
     * 1. Boundary traversal of left side without root and leaf
     * 2. Boundary traversal of leaf from left node
     * 3. Boundary traversal of leaf from right node
     * 4. Boundary traversal of right side without root and leaf
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> boundaryTraversal(TreeNode curr) {
        if (curr == null) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        // Adding the root node in the result
        result.add(curr.data);

        // Left Boundary
        boundaryTraversalLeft(curr.left, result);
        // Leaf Nodes on the left node
        boundaryTraversalLeaf(curr.left, result);
        // Leaf Nodes on the right node
        boundaryTraversalLeaf(curr.right, result);
        // Right Boundary
        boundaryTraversalRight(curr.right, result);

        return result;
    }

    public void boundaryTraversalLeft(TreeNode curr, List<Integer> arrList) {
        if (curr != null) {
            if (curr.left != null) {
                arrList.add(curr.data);
                boundaryTraversalLeft(curr.left, arrList);
            } else if (curr.right != null) {
                arrList.add(curr.data);
                boundaryTraversalLeft(curr.right, arrList);
            }
        }
    }

    public void boundaryTraversalLeaf(TreeNode curr, List<Integer> arrList) {
        if (curr != null) {
            if (curr.left == null && curr.right == null) {
                arrList.add(curr.data);
            }
            boundaryTraversalLeaf(curr.left, arrList);
            boundaryTraversalLeaf(curr.right, arrList);
        }
    }

    public void boundaryTraversalRight(TreeNode curr, List<Integer> arrList) {
        if (curr != null) {
            if (curr.right != null) {
                boundaryTraversalRight(curr.right, arrList);
                arrList.add(curr.data);
            } else if (curr.left != null) {
                boundaryTraversalRight(curr.left, arrList);
                arrList.add(curr.data);
            }
        }
    }


    public static void main(String[] args) {
        P7_BoundaryTraversal p7_boundaryTraversal = new P7_BoundaryTraversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p7_boundaryTraversal.boundaryTraversal(root));
    }
}
