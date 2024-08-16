package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_3_Hard;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S13_BinaryTrees.S13_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 02/10/22
 * Time: 6:20 pm
 * <p>
 */
public class P6_CountTotalNodesInCompeleteBT {

    public static void main(String[] args) {
        P6_CountTotalNodesInCompeleteBT p6_countTotalNodesInCompeleteBT = new P6_CountTotalNodesInCompeleteBT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p6_countTotalNodesInCompeleteBT.countNodes(root));
    }

    public int countNodes(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int lMax = countNodes(curr.left);
        int rMax = countNodes(curr.right);

        return lMax + rMax + 1;
    }
}
