package BinaryTree.Practice_2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajajp on 06 Jun, 2022
 */
public class BoundaryTraversal extends CommonUtils {
    // Traversing the left subtree without leaf

    public static void main(String[] args) {
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        boundaryTraversal.root = new TreeNode(1);
        boundaryTraversal.root.left = new TreeNode(2);
        boundaryTraversal.root.right = new TreeNode(3);
        boundaryTraversal.root.left.left = new TreeNode(4);
        boundaryTraversal.root.left.right = new TreeNode(5);
        boundaryTraversal.root.left.right.left = new TreeNode(7);
        boundaryTraversal.root.left.right.right = new TreeNode(8);
        boundaryTraversal.root.right.left = new TreeNode(6);
        boundaryTraversal.root.right.left.left = new TreeNode(9);
        boundaryTraversal.root.right.left.right = new TreeNode(10);
//        boundaryTraversal.root.right.right = new TreeNode(7);

        boundaryTraversal.printBinaryTree_levelOrder(boundaryTraversal.root);
        System.out.println();

        System.out.println(boundaryTraversal.boundaryTraversal(boundaryTraversal.root));
    }

    /**
     * 1. Traversing the left subtree without leaf and adding to the list
     * 2. Traversing the leaf nodes and adding to the list
     * 3. Traversing the right subtree without leaf and adding to the list
     */

    public List<Integer> boundaryTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result.add(node.data);

            getBoundaryLeft(node.left, result);

            getBoundaryLeaves(node.left, result);
            getBoundaryLeaves(node.right, result);

            getBoundaryRight(node.right, result);
        }
        return result;
    }

    private void getBoundaryLeft(TreeNode node, List<Integer> result) {
        if (node != null) {
            if (node.left != null) {
                result.add(node.data);
                getBoundaryLeft(node.left, result);
            } else if (node.right != null) {
                result.add(node.data);
                getBoundaryLeft(node.right, result);
            }
        }
    }

    private void getBoundaryRight(TreeNode node, List<Integer> result) {
        if (node != null) {
            if (node.right != null) {
                getBoundaryRight(node.right, result);
                result.add(node.data);
            } else if (node.left != null) {
                getBoundaryRight(node.left, result);
                result.add(node.data);
            }
        }
    }

    private void getBoundaryLeaves(TreeNode node, List<Integer> result) {
        if (node != null) {
            getBoundaryLeaves(node.left, result);
            if (node.left == null && node.right == null) {
                result.add(node.data);
            }
            getBoundaryLeaves(node.right, result);
        }
    }
}
