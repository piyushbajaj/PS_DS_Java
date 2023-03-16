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
 * Date: 04/10/22
 * Time: 7:21 pm
 * <p>
 */
public class P9_BT_Inorder_Postorder {
    public TreeNode constructBT(int[] postOrder, int[] inOrder) {
        int n = postOrder.length;
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        return constructBT_util(postOrder, 0, n - 1, inOrder, 0, n - 1, inOrderMap);

    }

    public TreeNode constructBT_util(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd,
                                     Map<Integer, Integer> inOrderMap) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode curr = new TreeNode(postOrder[postEnd]);
        int indexInorder = inOrderMap.get(postOrder[postEnd]);

        curr.right = constructBT_util(postOrder, postStart + indexInorder - inStart, postEnd - 1,
            inOrder, indexInorder + 1, inEnd, inOrderMap);
        curr.left = constructBT_util(postOrder, postStart, postStart + indexInorder - inStart - 1,
            inOrder, inStart, indexInorder - 1, inOrderMap);

        return curr;
    }

    public static void main(String[] args) {
        P9_BT_Inorder_Postorder p9_bt_inorder_postorder = new P9_BT_Inorder_Postorder();
        P5_Levelorder_Itr_Traversal p5_levelorder_itr_traversal = new P5_Levelorder_Itr_Traversal();

        int[] postOrder = {1, 3, 2, 5, 7, 6, 4};
        int[] inOrder = {1, 2, 3, 4, 5, 6, 7};

//        p8_bt_inorder_preorder.constructBT(preOrder, inOrder);
//        System.out.println(p5_levelorder_itr_traversal.levelOrderTraversal_iterative(
//            p8_bt_inorder_preorder.constructBT(preOrder, inOrder)));

        System.out.println(p5_levelorder_itr_traversal.levelOrderTraversal_iterative(
            p9_bt_inorder_postorder.constructBT(postOrder, inOrder)));
    }
}
