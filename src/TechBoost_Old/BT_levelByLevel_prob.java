package TechBoost_Old;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 01/05/18.
 * T.C: O(N)
 * S.C: O(N)
 */
public class BT_levelByLevel_prob {
    BTNode root;

    static class BTNode{
        BTNode left, right;
        int data;

        BTNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void print_level_by_level(BTNode key){
        if(key == null)
            return;

        Queue<BTNode> queue1 = new LinkedList<>();
        Queue<BTNode> queue2 = new LinkedList<>();
        BTNode curr = null;

        //int flag = 0;

        queue1.add(key);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                curr = queue1.remove();

                System.out.print(curr.data + " ");


                if (curr.left != null) {
                    queue2.add(curr.left);
                }
                if (curr.right != null) {
                    queue2.add(curr.right);
                }
            }
            System.out.println();
            while (!queue2.isEmpty()) {
                curr = queue2.remove();

                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    queue1.add(curr.left);
                }
                if (curr.right != null) {
                    queue1.add(curr.right);
                }
            }
            System.out.println();
        }

    }

    public void print_level_by_level_better(BTNode key){
        if(key == null)
            return;

        Queue<BTNode> queue1 = new LinkedList<>();
        BTNode curr = null;
        queue1.add(key);
        queue1.add(null);

        while (!queue1.isEmpty()){
            if(queue1.size() == 1 && queue1.peek() == null)
                break;
            curr = queue1.remove();
            if(curr == null){
                queue1.add(null);
                System.out.println();
            }
            else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    queue1.add(curr.left);
                }
                if (curr.right != null) {
                    queue1.add(curr.right);
                }
            }
        }

    }

    public void levelOrder_iterative(BTNode key){
        if(key == null)
            return;

        Queue<BTNode> queue = new LinkedList<BTNode>();
        queue.add(key);

        while (!queue.isEmpty()){
            BTNode temp = queue.remove();
            System.out.print(temp.data + " ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }

    }

    public static void main(String[] args) {
        BT_levelByLevel_prob BT = new BT_levelByLevel_prob();
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

        System.out.print("LevelOrder Traversal using Iterative Approach: ");
        BT.levelOrder_iterative(BT.root);
        System.out.println();
        BT.print_level_by_level(BT.root);

        BT.print_level_by_level_better(BT.root);

    }
}
