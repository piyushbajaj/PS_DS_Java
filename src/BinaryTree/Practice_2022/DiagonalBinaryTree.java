package BinaryTree.Practice_2022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by bajajp on 06 Jun, 2022
 */
public class DiagonalBinaryTree extends CommonUtils {
    public static void main(String[] args) {
        DiagonalBinaryTree diagonalBinaryTree = new DiagonalBinaryTree();
        diagonalBinaryTree.root = new TreeNode(1);
        diagonalBinaryTree.root.left = new TreeNode(2);
        diagonalBinaryTree.root.right = new TreeNode(3);
        diagonalBinaryTree.root.left.left = new TreeNode(4);
        diagonalBinaryTree.root.left.right = new TreeNode(5);
        diagonalBinaryTree.root.left.right.left = new TreeNode(7);
        diagonalBinaryTree.root.left.right.right = new TreeNode(8);
        diagonalBinaryTree.root.right.left = new TreeNode(6);
        diagonalBinaryTree.root.right.left.left = new TreeNode(9);
        diagonalBinaryTree.root.right.left.right = new TreeNode(10);

        diagonalBinaryTree.diagonal_preOrder_recursive(diagonalBinaryTree.root);
        diagonalBinaryTree.diagonal_iterative(diagonalBinaryTree.root);
    }

    public void diagonal_preOrder_recursive(TreeNode node) {
        Map<Integer, ArrayList<Integer>> result = new HashMap<>();

        // WIll follow preOrder approach

        diagonal_preOrder_recursive_util(node, 0, result);

        result.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }

    // Level Order Traversal Approach

    public void diagonal_preOrder_recursive_util(TreeNode node, int diagonal, Map<Integer, ArrayList<Integer>> result) {
        if (node != null) {
            result.putIfAbsent(diagonal, new ArrayList<>());
            result.get(diagonal).add(node.data);

            diagonal_preOrder_recursive_util(node.left, diagonal + 1, result);

            diagonal_preOrder_recursive_util(node.right, diagonal, result);
        }

    }

    /**
     * Algo:
     * 1. Create Queue for storing nodes in diagonal fashion
     * 2. Transition to another diagonal means adding null
     * 3. First add all nodes values from the left before even starting the while loop
     * 4. Then extract node values and add their
     *
     * @param node
     */
    public void diagonal_iterative(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        //dummy node to mark the end of diagonal level
        TreeNode dummy = new TreeNode(-1);

        // Add all the nodes in the right
        while (node != null) {
            queue.add(node);
            node = node.right;
        }
        queue.add(dummy);

        while (queue.size() != 1) {
            TreeNode curr = queue.poll();

            if (curr != dummy) {
                assert curr != null;
                System.out.print(curr.data + " ");
                //If the left exists of curr then add that to queue
                TreeNode currLeft = curr.left;

                // Add all the right nodes to the queue
                while (currLeft != null) {
                    queue.add(currLeft);
                    currLeft = currLeft.right;
                }
            } else {
                queue.add(dummy);
                System.out.println();
            }

        }

        //
    }
}
