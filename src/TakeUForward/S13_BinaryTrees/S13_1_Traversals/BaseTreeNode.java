package TakeUForward.S13_BinaryTrees.S13_1_Traversals;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class BaseTreeNode {
    TreeNode root;

    public static int heightOfTree_recur(TreeNode node) {
        if (node == null) return 0;

        int lHeight = heightOfTree_recur(node.left);
        int rHeight = heightOfTree_recur(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }
}
