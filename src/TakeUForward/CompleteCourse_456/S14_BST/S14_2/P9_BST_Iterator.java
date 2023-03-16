package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import java.util.Stack;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 07/10/22
 * Time: 5:04 pm
 * <p>
 * Approach 1:
 * 1. Going via inorder, and determining next and hasNext
 * TC: O(H)
 * SC: O(1)
 */
public class P9_BST_Iterator {
    Stack<TreeNode> stackLeft = new Stack<>();
    Stack<TreeNode> stackRight = new Stack<>();

    public P9_BST_Iterator(TreeNode root) {
        pushAllLeft(root);
        pushAllRight(root);
    }

    public int next() {
        TreeNode currNext = null;
        if (!stackLeft.isEmpty()) {
            currNext = stackLeft.pop();
            pushAllLeft(currNext.right);
        }
        return currNext == null ? -1 : currNext.data;
    }

    // Remove in descending order
    public int before() {
        TreeNode currNext = null;
        if (!stackRight.isEmpty()) {
            currNext = stackRight.pop();
            pushAllRight(currNext.left);
        }
        return currNext == null ? -1 : currNext.data;
    }

    public boolean hasNext() {
        return !stackLeft.isEmpty();
    }

    // Push all the left elements in the stack
    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            stackLeft.push(root);
            root = root.left;
        }
    }

    // Push all the right elements in the stack
    private void pushAllRight(TreeNode root) {
        while (root != null) {
            stackRight.push(root);
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        P9_BST_Iterator p9_bst_iterator = new P9_BST_Iterator(root);
        System.out.println("Current Element: " + p9_bst_iterator.next());
        System.out.println("Current Element: " + p9_bst_iterator.next());
        System.out.println("Current Element: " + p9_bst_iterator.next());
        System.out.println("Current Element: " + p9_bst_iterator.next());
        System.out.println("Current Element: " + p9_bst_iterator.next());
        System.out.println("Current Element: " + p9_bst_iterator.next());
        System.out.println("Current Element: " + p9_bst_iterator.next());
        System.out.println("Current Element: " + p9_bst_iterator.next());
        System.out.println("Current Element from back: " + p9_bst_iterator.before());
        System.out.println(p9_bst_iterator.next());
        System.out.println(p9_bst_iterator.next());
        System.out.println(p9_bst_iterator.next());
        System.out.println(p9_bst_iterator.hasNext());
    }
}
