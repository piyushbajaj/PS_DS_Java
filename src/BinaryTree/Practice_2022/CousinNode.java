package BinaryTree.Practice_2022;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bajajp on 04 Jun, 2022
 */
public class CousinNode extends CommonUtils {

    public static void main(String[] args) {
        CousinNode cousinNode = new CousinNode();
        cousinNode.insertInBT(1);
        cousinNode.insertInBT(2);
        cousinNode.insertInBT(3);
        cousinNode.insertInBT(4);
        cousinNode.insertInBT(5);
        cousinNode.insertInBT(6);
        cousinNode.insertInBT(7);
        cousinNode.printBinaryTree_inOrder(cousinNode.root);
        System.out.println();
        System.out.println(cousinNode.isCousin(cousinNode.root, 4, 7));
    }

    public boolean isCousin(TreeNode root, int a, int b) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return false;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean isSibbling = false;
            boolean isCousin = false;

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.remove();
                if (curr == null) {
                    isSibbling = false;
                } else {
                    if (curr.data == a || curr.data == b) {
                        // For the first node matched
                        if (!isCousin) {
                            isCousin = true;
                            isSibbling = true;
                        } else {
                            return !isSibbling;
                        }
                    }
                    if (curr.left != null || curr.right != null) {
                        if (curr.left != null) {
                            queue.add(curr.left);
                        }
                        if (curr.right != null) {
                            queue.add(curr.right);
                        }
                        // Null marker to show the end
                        queue.add(null);
                    }
                }
            }

            if (isCousin) {
                return false;
            }
        }
        return false;
    }
}
