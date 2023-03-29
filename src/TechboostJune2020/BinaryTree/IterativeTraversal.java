package TechboostJune2020.BinaryTree;

import java.util.Stack;

public class IterativeTraversal {
    TreeNode root;

    public static void main(String[] args) {
        IterativeTraversal iterativeTraversal = new IterativeTraversal();
        iterativeTraversal.root = new TreeNode(1);
        iterativeTraversal.root.left = new TreeNode(2);
        iterativeTraversal.root.right = new TreeNode(3);
        iterativeTraversal.root.left.left = new TreeNode(4);
        iterativeTraversal.root.left.right = new TreeNode(5);
        iterativeTraversal.root.right.left = new TreeNode(6);
        iterativeTraversal.root.right.right = new TreeNode(7);

        System.out.println("Pre-Order using Iterative Approach: ");
        iterativeTraversal.preOrder_Iterative(iterativeTraversal.root);

    }

    //PreOrder
    // T.C: O(N)
    // S.C: O(logN) --> Comeback again
    public void preOrder_Iterative(TreeNode key) {
        if (key == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(key);

        while (!stk.isEmpty()) {
            TreeNode temp = stk.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stk.push(temp.right);
            }
            if (temp.left != null) {
                stk.push(temp.left);
            }
        }
    }


    //InOrder
    //T.C: O(N)
    //S.C: O(logN)
    public void inOrder_Iterative(TreeNode key) {
        if (key == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        //stk.push(key);

        TreeNode temp = key;
        boolean flag = false;
        while (!flag) {
            if (temp != null) {
                stk.push(temp);
                temp = temp.left;
            } else {
                if (stk.isEmpty()) {
                    flag = true;
                } else {
                    temp = stk.pop();
                    System.out.print(temp.data + " ");
                    temp = temp.right;
                }
            }
        }
    }

    //PostOrder
    //T.C: O(N)
    // S.C: O(logN)
    public void postOrder_Iterative(TreeNode key) {
        if (key == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        stk.push(key);
        TreeNode prev = null;

        while (!stk.isEmpty()) {
            TreeNode curr = stk.peek();
            //Left Side
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stk.push(curr.left);
                } else if (curr.right != null) {
                    stk.push(curr.right);
                } else {
                    System.out.print(stk.pop().data + " ");
                }
            }
            //Right side
            else if (curr.left == prev) {
                if (curr.right != null) {
                    stk.push(curr.right);
                } else {
                    System.out.print(stk.pop().data + " ");
                }
            }
            // Printing Node element
            else if (curr.right == prev) {
                System.out.print(stk.pop().data + " ");
            }
            prev = curr;
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
