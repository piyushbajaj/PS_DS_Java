package BinaryTree.Practice_2022;

public class BST_Check extends CommonUtils {

    public boolean isBST(TreeNode node) {
        return isBST_util(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBST_util(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data >= max) return false;
        if (node.data <= min) return false;
        return isBST_util(node.left, min, node.data) && isBST_util(node.right, node.data, max);
    }

    public static void main(String[] args) {
        BST_Check bst_check = new BST_Check();

        bst_check.insertInBST(4);
        bst_check.insertInBST(2);
        bst_check.insertInBST(6);
        bst_check.insertInBST(1);
        bst_check.insertInBST(3);
        bst_check.insertInBST(5);
        bst_check.insertInBST(7);
//        bst_check.root.left.left.left = new TreeNode(7);
        bst_check.printBinaryTree_inOrder(bst_check.root);
        System.out.println();
        System.out.println(bst_check.isBST(bst_check.root));
    }
}
