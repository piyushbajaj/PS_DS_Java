package BinaryTree.Practice_2022;

public class BST_Delete extends CommonUtils {
    public static void main(String[] args) {
        BST_Delete bst_delete = new BST_Delete();
        bst_delete.insertInBST(1);
        bst_delete.insertInBST(2);
        bst_delete.insertInBST(3);
        bst_delete.insertInBST(4);
        bst_delete.insertInBST(5);
        bst_delete.insertInBST(6);
        bst_delete.insertInBST(7);
        bst_delete.printBinaryTree_inOrder(bst_delete.root);
        System.out.println();
        bst_delete.deleteInBST(bst_delete.root, 4);
        bst_delete.printBinaryTree_inOrder(bst_delete.root);
    }

    public TreeNode deleteInBST(TreeNode node, int data) {
        if (node == null) {
            return null;
        }
        int temp;

        if (data < node.data) {
            node.left = deleteInBST(node.left, data);
        } else if (data > node.data) {
            node.right = deleteInBST(node.right, data);
        } else {
            // two children of a node
            if (node.left != null && node.right != null) {
                temp = largestElementIterative(node.left);
                node.data = temp;
                deleteInBST(node.left, data);
            } else {
                //Node with 1 or no child
                if (node.left == null) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
        return node;
    }
}
