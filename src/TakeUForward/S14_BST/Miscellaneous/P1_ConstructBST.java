package TakeUForward.S14_BST.Miscellaneous;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.P1_BT_Recur_Traversals;
import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.Miscellaneous
 * <p>
 * User: piyushbajaj
 * Date: 06/10/22
 * Time: 8:35 am
 * <p>
 */
public class P1_ConstructBST {

    /**
     * Input array is inordered sorted
     *
     * @param inOrder
     * @return
     */
    public static TreeNode constructBST(int[] inOrder) {
        return constructBST(inOrder, 0, inOrder.length - 1);
    }

    private static TreeNode constructBST(int[] inOrder, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;

            TreeNode curr = new TreeNode(inOrder[mid]);
            curr.left = constructBST(inOrder, start, mid - 1);
            curr.right = constructBST(inOrder, mid + 1, end);

            return curr;
        }

        return null;
    }

    public static void main(String[] args) {
        int[] inOrder = {1, 2, 3, 4, 5, 6, 7};
        ;
        P1_BT_Recur_Traversals p1_bt_recur_traversals = new P1_BT_Recur_Traversals();
        System.out.println(p1_bt_recur_traversals.levelOrderTraversal_recur(constructBST(inOrder)));


    }
}
