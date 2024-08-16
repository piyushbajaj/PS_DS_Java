package TechBoost_Old;

/**
 * Created by piyush.bajaj on 28/04/18.
 */
public class BT_Same_Tree_Prob {
    BTNode root;
    BTNode root1;

    public static void main(String[] args) {
        BT_Same_Tree_Prob BT = new BT_Same_Tree_Prob();
        BT.root = new BTNode(2);
        BT.root.left = new BTNode(3);
        BT.root.right = new BTNode(4);
        BT.root.left.left = new BTNode(5);
        BT.root.left.right = new BTNode(6);

        BT.root1 = new BTNode(2);
        BT.root1.left = new BTNode(3);
        BT.root1.right = new BTNode(4);
        BT.root1.left.left = new BTNode(5);
        //BT.root1.left.right = new BTNode(6);

        BT.printTree(BT.root);
        System.out.println();
        BT.printTree(BT.root1);
        System.out.println();

        System.out.println("Check if two BT's are same: " + BT.check_sameTree(BT.root, BT.root1));
    }

    public boolean check_sameTree(BTNode N1, BTNode N2) {
        if (N1 == null && N2 == null) {
            return true;
        } else if (N1 != null && N2 == null) {
            return false;
        } else if (N1 == null && N2 != null) {
            return false;
        } else {
            if (N1.data != N2.data) {
                return false;
            }
        }


        return check_sameTree(N1.left, N2.left) && check_sameTree(N1.right, N2.right);
    }

    public void printTree(BTNode key) {
        if (key == null) {
            return;
        }

        printTree(key.left);
        System.out.print(key.data + " ");
        printTree(key.right);
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
