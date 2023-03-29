package TakeUForward.Blind75.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 1:17 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/invert-binary-tree/description/">...</a>
 */
public class P3_InvertTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(1);

        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(7);
        node1.left.left = new TreeNode(1);
        node1.left.right = new TreeNode(3);
        node1.right.left = new TreeNode(3);
        node1.right.right = new TreeNode(1);

        P3_InvertTree p3_invertTree = new P3_InvertTree();
        p3_invertTree.printTree(node);
        // After inverting the tree
        p3_invertTree.printTree(p3_invertTree.invertTree(node));

        p3_invertTree.printTree(p3_invertTree.invertTree_it(node1));
    }

    // Recursive Way
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        // swap nodes
        root.left = rightNode;
        root.right = leftNode;

        return root;
    }

    // Iterative Way
    public TreeNode invertTree_it(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            // swap nodes
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }

        }
        return root;
    }

    public void printTree(TreeNode node) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        printTree(node, arrayList);
        System.out.println(arrayList);
    }

    public void printTree(TreeNode node, ArrayList<Integer> arrayList) {
        if (node != null) {
            printTree(node.left, arrayList);
            arrayList.add(node.data);
            printTree(node.right, arrayList);
        }
    }
}
