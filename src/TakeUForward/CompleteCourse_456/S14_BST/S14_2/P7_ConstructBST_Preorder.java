package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.P1_BT_Recur_Traversals;
import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 06/10/22
 * Time: 7:49 pm
 * <p>
 * Approaches:
 * <p>
 * Approach 1:
 * - If we have to insert each preOrder Item one by one, then TC: O(N*N), SC: O(1)
 * <p>
 * Approach 2:
 * - If we sort the preOrder, then we will get inOrder, and then using preOrder and inOrder, we can construct the
 * tree, so the TC: O(NlogN) + O(N), SC: O(N)
 * <p>
 * Approach 3:
 * - Using Range
 */
public class P7_ConstructBST_Preorder {

    public void insertInBST(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }

        if (root.data <= key) {
            insertInBST(root.right, key);
        } else {
            insertInBST(root.left, key);
        }
    }

    /**
     * TC: O(N)
     *
     * @param preOrder
     * @return
     */
    public TreeNode constructBST_from_BST(int[] preOrder) {
        return constructBST_from_BST_util(preOrder, Integer.MAX_VALUE, new int[] {0});
    }

    public TreeNode constructBST_from_BST_util(int[] preOrder, int max, int[] index) {
        if (index[0] == preOrder.length || preOrder[index[0]] > max) {
            return null;
        }

        TreeNode curr = new TreeNode(preOrder[index[0]++]);
        curr.left = constructBST_from_BST_util(preOrder, curr.data, index);
        curr.right = constructBST_from_BST_util(preOrder, max, index);

        return curr;
    }

    public static void main(String[] args) {
        P7_ConstructBST_Preorder p7_constructBST_preorder = new P7_ConstructBST_Preorder();
        int[] preorder = {4, 2, 1, 3, 6, 5, 7};

        System.out.println(
            P1_BT_Recur_Traversals.levelOrderTraversal_recur(p7_constructBST_preorder.constructBST_from_BST(preorder)));
    }
}
