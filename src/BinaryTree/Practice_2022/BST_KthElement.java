package BinaryTree.Practice_2022;

public class BST_KthElement extends CommonUtils {

    int countSmallest = 0;
    public TreeNode kthSmallestElement(TreeNode node, int k) {
        if (node == null) return null;

        TreeNode left = kthSmallestElement(node.left, k);

        if (left != null) {
            return left;
        }
        if (++countSmallest == k) {
            return node;
        }

        return kthSmallestElement(node.right, k);
    }

    int countLargest = 0;
    public TreeNode kthLargestElement(TreeNode node, int k) {
        if (node == null) return null;

        TreeNode right = kthLargestElement(node.right, k);

        if (right != null) {
            return right;
        }
        if (++countLargest == k) {
            return node;
        }

        return kthLargestElement(node.left, k);
    }

    public static void main(String[] args) {
        BST_KthElement bst_kthElement = new BST_KthElement();
        bst_kthElement.insertInBST(4);
        bst_kthElement.insertInBST(2);
        bst_kthElement.insertInBST(6);
        bst_kthElement.insertInBST(1);
        bst_kthElement.insertInBST(3);
        bst_kthElement.insertInBST(5);
        bst_kthElement.insertInBST(7);
        bst_kthElement.printBinaryTree_inOrder(bst_kthElement.root);
        System.out.println();


        System.out.println(bst_kthElement.kthSmallestElement(bst_kthElement.root, 2).data);
        System.out.println(bst_kthElement.kthLargestElement(bst_kthElement.root, 2).data);
    }
}
