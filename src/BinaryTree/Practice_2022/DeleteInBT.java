package BinaryTree.Practice_2022;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteInBT extends CommonUtils {
    /*
    Algorithm:
    1. Find the deepest node in the Binary Tree
    2. Make this as Null reference (delete)
    3. Replace the node to delete data with the node data
     */

    public static void main(String[] args) {
        DeleteInBT deleteInBT = new DeleteInBT();
        deleteInBT.insertInBT(1);
        deleteInBT.insertInBT(2);
        deleteInBT.insertInBT(3);
        deleteInBT.insertInBT(4);
        deleteInBT.insertInBT(5);
        deleteInBT.insertInBT(6);
        deleteInBT.insertInBT(7);
        deleteInBT.printBinaryTree_levelOrder(deleteInBT.root);
        System.out.println();
        deleteInBT.deleteInBT(deleteInBT.root, 3);
        System.out.println();
        deleteInBT.printBinaryTree_levelOrder(deleteInBT.root);
    }

    public void deleteInBT(TreeNode node, int key) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode keyNode = null, temp = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp != null) {
                if (temp.data == key) {
                    keyNode = temp;
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }

        if (keyNode != null && temp != null) {
            int lastElement = temp.data;
            deleteDeepestNode(node, temp);
            keyNode.data = lastElement;
        }
    }

    private void deleteDeepestNode(TreeNode node, TreeNode deleteNode) {
        if (node == null || deleteNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp != null) {
                if (temp.right == deleteNode) {
                    temp.right = null;
                } else {
                    queue.offer(temp.right);
                }

                if (temp.left == deleteNode) {
                    temp.left = null;
                } else {
                    queue.offer(temp.left);
                }
            }
        }
    }
}
