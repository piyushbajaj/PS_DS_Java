package BinaryTree.Practice_2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by bajajp on 04 Jun, 2022
 */
public class RightViewTree extends CommonUtils {
    public static void main(String[] args) {
        RightViewTree rightViewTree = new RightViewTree();
        rightViewTree.insertInBT(1);
        rightViewTree.insertInBT(2);
        rightViewTree.insertInBT(3);
        rightViewTree.insertInBT(4);
        rightViewTree.insertInBT(5);
        rightViewTree.insertInBT(6);
        rightViewTree.insertInBT(7);
        rightViewTree.printBinaryTree_levelOrder(rightViewTree.root);
        System.out.println();
        System.out.println(rightViewTree.rightView_iterative(rightViewTree.root));
        System.out.println(rightViewTree.rightView_recursive(rightViewTree.root));

    }

    public List<Integer> rightView_iterative(TreeNode node) {
        List<Integer> result = new ArrayList<Integer>();
        if (node == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.remove();

                if (i == n - 1) {
                    result.add(curr.data);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return result;
    }

    public List<Integer> rightView_recursive(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        rightView_recursive_util(node, 0, result);
        return result;
    }

    // Recursive DFS
    public void rightView_recursive_util(TreeNode node, int level, List<Integer> result) {
        if (node != null) {
            if (level == result.size()) {
                result.add(node.data);
            }
            if (node.right != null) {
                rightView_recursive_util(node.right, level + 1, result);
            }
            if (node.left != null) {
                rightView_recursive_util(node.left, level + 1, result);
            }
        }
    }
}
