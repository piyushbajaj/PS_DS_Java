package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_3_Hard;

import java.util.HashMap;
import java.util.Map;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.P5_Levelorder_Itr_Traversal;
import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S13_BinaryTrees.S13_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 02/10/22
 * Time: 6:54 pm
 * <p>
 */
public class P8_BT_Inorder_Preorder {

    /**
     * Approach:
     * 1. Will go one by one index wise in the pre-order order, and the one that matches with in-order will extract
     * that element as root
     * 2. Then will follow pre-order approach to construct binary tree.
     * <p>
     * TC: O(N^2)
     * SC: O(N)
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode constructBT(int[] preOrder, int[] inOrder) {
        int[] index = new int[1];
        int n = preOrder.length;
        return constructBT_util(preOrder, inOrder, 0, n - 1, index);
    }

    public TreeNode constructBT_util(int[] preOrder, int[] inOrder, int start, int end, int[] index) {
        if (start <= end) {
            int i;

            for (i = start; i <= end; i++) {
                if (preOrder[index[0]] == inOrder[i]) {
                    break;
                }
            }

            TreeNode curr = new TreeNode(preOrder[index[0]]);
            index[0]++;
            curr.left = constructBT_util(preOrder, inOrder, start, i - 1, index);
            curr.right = constructBT_util(preOrder, inOrder, i + 1, end, index);

            return curr;
        }
        return null;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode constructBT_map(int[] preOrder, int[] inOrder) {
        if (preOrder.length != inOrder.length) {
            return null;
        }
        int n = preOrder.length;

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        return constructBT_map_util(preOrder, 0, n - 1, inOrder, 0, n - 1, inOrderMap);
    }

    public TreeNode constructBT_map_util(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart,
                                         int inEnd, Map<Integer, Integer> inOrderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode curr = new TreeNode(preOrder[preStart]);
        int inOrderIndex = inOrderMap.get(preOrder[preStart]);
        int inOrderIndexDiff = inOrderIndex - inStart;

        curr.left = constructBT_map_util(preOrder, preStart + 1, preStart + inOrderIndexDiff,
            inOrder, inStart, inStart + inOrderIndex - 1, inOrderMap);
        curr.right = constructBT_map_util(preOrder, preStart + inOrderIndexDiff + 1, preEnd,
            inOrder, inStart + inOrderIndexDiff + 1, inEnd, inOrderMap);

        return curr;
    }

    public static void main(String[] args) {
        P8_BT_Inorder_Preorder p8_bt_inorder_preorder = new P8_BT_Inorder_Preorder();
        P5_Levelorder_Itr_Traversal p5_levelorder_itr_traversal = new P5_Levelorder_Itr_Traversal();

        int[] preOrder = {4, 2, 1, 3, 6, 5, 7};
        int[] inOrder = {1, 2, 3, 4, 5, 6, 7};

//        p8_bt_inorder_preorder.constructBT(preOrder, inOrder);
//        System.out.println(p5_levelorder_itr_traversal.levelOrderTraversal_iterative(
//            p8_bt_inorder_preorder.constructBT(preOrder, inOrder)));

        System.out.println(p5_levelorder_itr_traversal.levelOrderTraversal_iterative(
            p8_bt_inorder_preorder.constructBT_map(preOrder, inOrder)));


    }
}
