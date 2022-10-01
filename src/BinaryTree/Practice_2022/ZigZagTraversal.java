package BinaryTree.Practice_2022;


import java.util.Stack;

public class ZigZagTraversal extends CommonUtils {
    public void zigZag(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stackLeftToRight = new Stack<>();
        Stack<TreeNode> stackRightToLeft = new Stack<>();

        stackLeftToRight.add(node);
        while (!stackLeftToRight.isEmpty() || !stackRightToLeft.isEmpty()) {
            while (!stackLeftToRight.isEmpty()) {
                TreeNode temp = stackLeftToRight.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    stackRightToLeft.add(temp.left);
                }
                if (temp.right != null) {
                    stackRightToLeft.add(temp.right);
                }
            }

            while (!stackRightToLeft.isEmpty()) {
                TreeNode temp = stackRightToLeft.pop();
                System.out.print(temp.data + " ");
                if (temp.right != null) {
                    stackLeftToRight.add(temp.right);
                }
                if (temp.left != null) {
                    stackLeftToRight.add(temp.left);
                }
            }
        }
    }

    public static void main(String[] args) {
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        zigZagTraversal.insertInBT(1);
        zigZagTraversal.insertInBT(2);
        zigZagTraversal.insertInBT(3);
        zigZagTraversal.insertInBT(4);
        zigZagTraversal.insertInBT(5);
        zigZagTraversal.insertInBT(6);
        zigZagTraversal.insertInBT(7);
        zigZagTraversal.printBinaryTree_levelOrder(zigZagTraversal.root);
        System.out.println();
        zigZagTraversal.zigZag(zigZagTraversal.root);
//        System.out.println(lcabt.getLCA(lcabt.root, lcabt.root.left.left, lcabt.root.right.right).data);
    }
}
