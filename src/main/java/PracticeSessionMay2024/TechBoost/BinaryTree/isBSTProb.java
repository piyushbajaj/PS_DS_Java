package PracticeSessionMay2024.TechBoost.BinaryTree;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.BinaryTree
 * <p>
 * User: piyushbajaj
 * Date: 06/07/24
 * Time: 6:21 pm
 */
public class isBSTProb {

    /**
     * TC: O(N)
     * SC: O(height)
     *
     * @param root
     * @return
     */
    public static boolean isBST(BTNode root) {
        return isBST_util(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST_util(BTNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data < min) {
            return false;
        }

        if (root.data > max) {
            return false;
        }

        return isBST_util(root.left, min, root.data) && isBST_util(root.right, root.data, max);
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(5);
        root.right = new BTNode(15);
        root.left.left = new BTNode(1);
        root.left.right = new BTNode(9);
        root.right.left = new BTNode(11);
        root.right.right = new BTNode(14);

        System.out.println(isBST(root));
    }
}
