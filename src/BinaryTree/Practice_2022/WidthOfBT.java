package BinaryTree.Practice_2022;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBT extends CommonUtils {

    /*
    TC: O(N)
     */
    public int widthOfBT(TreeNode node) {
        if (node == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();
            maxWidth = Math.max(count, maxWidth);

            while (count-- > 0) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        WidthOfBT widthOfBT = new WidthOfBT();
        widthOfBT.insertInBT(1);
        widthOfBT.insertInBT(2);
        widthOfBT.insertInBT(3);
        widthOfBT.insertInBT(4);
        widthOfBT.insertInBT(5);
        widthOfBT.insertInBT(6);
        widthOfBT.insertInBT(7);
        widthOfBT.printBinaryTree_levelOrder(widthOfBT.root);
        System.out.println();
        System.out.println(widthOfBT.widthOfBT(widthOfBT.root));
    }
}
