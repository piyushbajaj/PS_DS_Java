package BinaryTree.Practice_2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by bajajp on 04 Jun, 2022
 */
public class LeftViewTree extends CommonUtils {
    public List<Integer> leftView_iterative(TreeNode node) {
        List<Integer> result = new ArrayList<Integer>();
        if (node == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.remove();

                if (i == 0) {
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

    public List<Integer> leftView_recursive(TreeNode node) {
        List<Integer> result = new ArrayList<Integer>();


        leftView_recursive_util(node, 1, result);
        return result;
    }

    int maxLevel = 0;
    public void leftView_recursive_util(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        if (maxLevel < level) {
            result.add(node.data);
            maxLevel = level;
        }

        leftView_recursive_util(node.left, level+1, result);
        leftView_recursive_util(node.right, level+1, result);
    }

    public static void main(String[] args) {
        LeftViewTree leftViewTree = new LeftViewTree();
        leftViewTree.insertInBT(1);
        leftViewTree.insertInBT(2);
        leftViewTree.insertInBT(3);
        leftViewTree.insertInBT(4);
        leftViewTree.insertInBT(5);
        leftViewTree.insertInBT(6);
        leftViewTree.insertInBT(7);
        leftViewTree.printBinaryTree_inOrder(leftViewTree.root);
        System.out.println();
        System.out.println(leftViewTree.leftView_iterative(leftViewTree.root));
        System.out.println(leftViewTree.leftView_recursive(leftViewTree.root));

    }
}
