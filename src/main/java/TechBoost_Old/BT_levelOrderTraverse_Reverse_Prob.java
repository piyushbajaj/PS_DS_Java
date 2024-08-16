package TechBoost_Old;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 04/05/18.
 * T.C: O(N)
 * S.C: O(N)
 */
public class BT_levelOrderTraverse_Reverse_Prob {
    BTNode root;

    public static void main(String[] args) {
        BT_levelOrderTraverse_Reverse_Prob BT = new BT_levelOrderTraverse_Reverse_Prob();
        BT.root = new BTNode(1);
        BT.root.left = new BTNode(2);
        BT.root.right = new BTNode(3);
        BT.root.left.left = new BTNode(4);
        BT.root.left.right = new BTNode(5);
        BT.root.right.left = new BTNode(6);
        BT.root.right.right = new BTNode(7);
        BT.root.left.right.left = new BTNode(8);
        BT.root.left.right.right = new BTNode(9);
        BT.root.right.right.left = new BTNode(10);

        BT.printBFS(BT.root);
        System.out.println("Printing Stack in reverse order: ");
        BT.reverse_BFS(BT.root);
    }

    public void printBFS(BTNode key) {
        if (key == null) {
            return;
        }

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(key);

        while (!queue.isEmpty()) {
            BTNode curr = queue.remove();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public void reverse_BFS(BTNode key) {
        if (key == null) {
            return;
        }

        Queue<BTNode> queue = new LinkedList<>();
        Stack<BTNode> stack = new Stack<>();
        queue.add(key);

        while (!queue.isEmpty()) {
            BTNode curr = queue.remove();
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }

            stack.add(curr);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }

    }

    static class BTNode {
        BTNode left, right;
        int data;

        BTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
