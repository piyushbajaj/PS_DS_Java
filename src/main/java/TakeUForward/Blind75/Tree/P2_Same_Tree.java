package TakeUForward.Blind75.Tree;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 12:59 pm
 * lc: <a href="https://takeuforward.org/interviews/blind-75-leetcode-problems-detailed-video-solutions/">...</a>
 */
public class P2_Same_Tree {

    public static void main(String[] args) {
        P2_Same_Tree p2_same_tree = new P2_Same_Tree();

        TreeNode firstNode = new TreeNode(1);
        firstNode.left = new TreeNode(2);
        firstNode.right = new TreeNode(3);
        firstNode.left.left = new TreeNode(4);
        firstNode.left.right = new TreeNode(5);
        firstNode.right.left = new TreeNode(6);
        firstNode.right.right = new TreeNode(7);

        TreeNode secondNode = new TreeNode(1);
        secondNode.left = new TreeNode(2);
        secondNode.right = new TreeNode(3);
        secondNode.left.left = new TreeNode(4);
        secondNode.left.right = new TreeNode(5);
        secondNode.right.left = new TreeNode(6);
        secondNode.right.right = new TreeNode(7);

        System.out.println(p2_same_tree.isSameTree(firstNode, secondNode));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.data != q.data) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
