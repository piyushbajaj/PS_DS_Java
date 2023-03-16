package TakeUForward.Blind75.Tree;

import java.util.HashMap;
import java.util.Map;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 8:12 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">...</a>
 */
public class P8_Construct_BT_PreOrder_InOrder {

    int preOrderIndex = 0;
    Map<Integer, Integer> inorderHashMap = new HashMap<>();

    /**
     * Using HashMap for storing inorder traversal
     * TC: O(N)
     * SC: O(N)
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;

        if (preOrder.length != inOrder.length) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            inorderHashMap.put(inOrder[i], i);
        }

        return buildTree_util(preOrder, 0, n - 1);
    }

    public TreeNode buildTree_util(int[] preOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart <= inOrderEnd) {
            int preOrderElement = preOrder[preOrderIndex++];
            TreeNode root = new TreeNode(preOrderElement);

            root.left = buildTree_util(preOrder, inOrderStart, inorderHashMap.get(preOrderElement) - 1);
            root.right = buildTree_util(preOrder, inorderHashMap.get(preOrderElement) + 1, inOrderEnd);

            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        P8_Construct_BT_PreOrder_InOrder p8_construct_bt_preOrder_inOrder = new P8_Construct_BT_PreOrder_InOrder();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        Utils.printTree(p8_construct_bt_preOrder_inOrder.buildTree(preOrder, inOrder));
    }
}
