package Session.May2024.TechBoost.BinaryTree;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.BinaryTree
 * <p>
 * User: piyushbajaj
 * Date: 09/07/24
 * Time: 8:21 am
 */
public class BSTOperations {

    /**
     * Steps:
     * 1. Here we keep going left and right and following BST properties
     * TC: O(N)
     * SC: O(logN)
     *
     * @param root
     * @param a
     * @param b
     * @return
     */
    public BTNode LCA_BST(BTNode root, int a, int b) {
        // base condition
        if (root == null) {
            return null;
        }

        if (a < root.data && b < root.data) {
            return LCA_BST(root.left, a, b);
        } else if (a > root.data && b > root.data) {
            return LCA_BST(root.right, a, b);
        }

        return root;

    }

    public static void main(String[] args) {
        BTNode root = new BTNode(40);
        root.left = new BTNode(20);
        root.right = new BTNode(60);
        root.left.left = new BTNode(10);
        root.left.right = new BTNode(30);
        root.right.left = new BTNode(50);
        root.right.right = new BTNode(70);
        BSTOperations bstOperations = new BSTOperations();

        System.out.println(bstOperations.LCA_BST(root, 10, 50).data);

    }
}
