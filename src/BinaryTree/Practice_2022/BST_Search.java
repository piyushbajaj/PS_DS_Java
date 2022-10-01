package BinaryTree.Practice_2022;

public class BST_Search extends CommonUtils {

    /*
    TC: O(N)
    SC: O(N)
     */
    public TreeNode search_recur(TreeNode node, int data) {
        if (node == null) return null;

        if (data < node.data) {
            return search_recur(node.left, data);
        } else if (data > node.data) {
            return search_recur(node.right, data);
        }

        return node;
    }

    public TreeNode search_iterative(TreeNode node, int data) {
        if (node == null) return null;

        while (node != null) {
            if (data < node.data) {
                node = node.left;
            } else if (data > node.data) {
                node = node.right;
            } else {
                return node;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        BST_Search bst_search = new BST_Search();
//        bst_search.insertInBT(4);
//        bst_search.insertInBT(2);
//        bst_search.insertInBT(6);
//        bst_search.insertInBT(1);
//        bst_search.insertInBT(3);
//        bst_search.insertInBT(5);
//        bst_search.insertInBT(7);
        bst_search.insertInBST(1);
        bst_search.insertInBST(2);
        bst_search.insertInBST(3);
        bst_search.insertInBST(4);
        bst_search.insertInBST(5);
        bst_search.insertInBST(6);
        bst_search.insertInBST(7);
        bst_search.printBinaryTree_inOrder(bst_search.root);
        System.out.println();
        System.out.println(bst_search.search_recur(bst_search.root, 5).data);
        System.out.println(bst_search.search_iterative(bst_search.root, 5).data);
    }
}
