package TechBoost_Old;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piyush.bajaj on 28/04/18.
 */
public class BT_Sum_Prob {
    BTNode root;
    BTNode root1;

    static class BTNode{
        BTNode left, right;
        int data;

        BTNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void printTree(BTNode key){
        if(key == null)
            return;

        printTree(key.left);
        System.out.print(key.data + " ");
        printTree(key.right);
    }

    public boolean check_sum(BTNode key, int sum, List<Integer> list){
        if(key == null) return false;

        if(key.left == null && key.right == null){
            if(sum - key.data == 0) {
                list.add(key.data);
                return true;
            }
            else
                return false;
        }

        boolean leftSide = check_sum(key.left, sum-key.data, list);
        if(leftSide) {
            list.add(key.data);
            return true;
        }
        boolean rightSide = check_sum(key.right, sum-key.data, list);
        if(rightSide) {
            list.add(key.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        BT_Sum_Prob BT = new BT_Sum_Prob();
        BT.root = new BTNode(10);
        BT.root.left = new BTNode(16);
        BT.root.right = new BTNode(5);
        BT.root.left.right = new BTNode(-3);
        BT.root.right.left = new BTNode(6);
        BT.root.right.right = new BTNode(11);

        BT.printTree(BT.root);
        List<Integer> list = new ArrayList<>();
        System.out.println(BT.check_sum(BT.root, 26, list));
        System.out.println(list);
    }
}
