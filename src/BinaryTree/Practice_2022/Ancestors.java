package BinaryTree.Practice_2022;

public class Ancestors extends CommonUtils {

    public boolean printAncestors(TreeNode node, int target) {
        if (node == null) return false;

        if (node.data == target) {
            return true;
        }

        if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Ancestors ancestors = new Ancestors();
        ancestors.insertInBT(1);
        ancestors.insertInBT(2);
        ancestors.insertInBT(3);
        ancestors.insertInBT(4);
        ancestors.insertInBT(5);
        ancestors.insertInBT(6);
        ancestors.insertInBT(7);
        ancestors.printBinaryTree_levelOrder(ancestors.root);
        System.out.println();
        ancestors.printAncestors(ancestors.root, 5);
    }
}
