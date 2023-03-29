package BinaryTree.Practice_2022;

public class BST_LCA extends CommonUtils {
    public static void main(String[] args) {
        BST_LCA bst_lca = new BST_LCA();

        bst_lca.insertInBST(4);
        bst_lca.insertInBST(2);
        bst_lca.insertInBST(6);
        bst_lca.insertInBST(1);
        bst_lca.insertInBST(3);
        bst_lca.insertInBST(5);
        bst_lca.insertInBST(7);
        bst_lca.printBinaryTree_inOrder(bst_lca.root);
        System.out.println();
        System.out.println(bst_lca.LCA(bst_lca.root, 5, 7).data);
    }

    public TreeNode LCA(TreeNode node, int data1, int data2) {
        if (node == null) {
            return null;
        }

        if (node.data > data1 && node.data > data2) {
            return LCA(node.left, data1, data2);
        } else if (node.data < data1 && node.data < data2) {
            return LCA(node.right, data1, data2);
        } else {
            return node;
        }
    }
}
