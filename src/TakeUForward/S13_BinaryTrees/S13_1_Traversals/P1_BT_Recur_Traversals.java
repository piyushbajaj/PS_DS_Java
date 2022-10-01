package TakeUForward.S13_BinaryTrees.S13_1_Traversals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P1_BT_Recur_Traversals {

    /**
     * Level-Order Traversal
     * TC: O(N)
     * SC: O(N)
     * <p>
     * Applications of Level-Order Traversal
     * <p>
     * - Level order traversal is actually Breadth First Search.
     * - Finding connected components in graph data structure.
     *
     * @param curr
     * @return
     */
    public List<Integer> levelOrderTraversal_recur(TreeNode curr) {
        List<Integer> arrList = new ArrayList<>();

        int heightOfBT = BaseTreeNode.heightOfTree_recur(curr);

        for (int i = 1; i <= heightOfBT; i++) {
            levelOrderTraversal_recur_util(curr, i, arrList);
        }

        return arrList;
    }

    private void levelOrderTraversal_recur_util(TreeNode curr, int level, List<Integer> arrList) {
        if (curr != null) {
            if (level == 1) {
                arrList.add(curr.data);
            } else {
                levelOrderTraversal_recur_util(curr.left, level - 1, arrList);
                levelOrderTraversal_recur_util(curr.right, level - 1, arrList);
            }
        }
    }

    /**
     * PreOrder Traversal
     * TC: O(N)
     * SC: O(N)
     * <p>
     * Applications of Preorder Traversal
     * <p>
     * - The main use of Preorder is to get copy of Tree.
     * - Other use is to generate Prefix expression.
     *
     * @param curr
     * @return
     */
    public List<Integer> preOrder_recur(TreeNode curr) {
        List<Integer> arrList = new ArrayList<>();
        preOrder_recur_util(curr, arrList);
        return arrList;
    }

    private void preOrder_recur_util(TreeNode curr, List<Integer> arrList) {
        if (curr != null) {
            arrList.add(curr.data);
            preOrder_recur_util(curr.left, arrList);
            preOrder_recur_util(curr.right, arrList);
        }
    }

    /**
     * In-Order Traversal
     * TC: O(N)
     * SC: O(N)
     * <p>
     * Applications of Inorder Traversal
     * <p>
     * - If inorder traversal of Binary Search Tree (BST) is done , we get increasing order.
     * - We can get reversed order / Decreasing order by doing inorder traversal in reverse order ( where right
     * subtree is called first and then left subtree is called)
     *
     * @param curr
     * @return
     */
    public List<Integer> inOrder_recur(TreeNode curr) {
        List<Integer> arrList = new ArrayList<>();
        inOrder_recur_util(curr, arrList);
        return arrList;
    }

    private void inOrder_recur_util(TreeNode curr, List<Integer> arrList) {
        if (curr != null) {
            inOrder_recur_util(curr.left, arrList);
            arrList.add(curr.data);
            inOrder_recur_util(curr.right, arrList);
        }
    }

    /**
     * Post-Order Traversal
     * TC: O(N)
     * SC: O(N)
     * <p>
     * Applications of Postorder Traversal
     * <p>
     * - The main use of Postorder is to delete the tree ( Before deleting the parent, we should delete children
     * first ).
     * - Other use is to generate Postfix expression.
     *
     * @param curr
     * @return
     */
    public List<Integer> postOrder_recur(TreeNode curr) {
        List<Integer> arrList = new ArrayList<>();
        postOrder_recur_util(curr, arrList);
        return arrList;
    }

    private void postOrder_recur_util(TreeNode curr, List<Integer> arrList) {
        if (curr != null) {
            postOrder_recur_util(curr.left, arrList);
            postOrder_recur_util(curr.right, arrList);
            arrList.add(curr.data);
        }
    }

    public static void main(String[] args) {
        P1_BT_Recur_Traversals p1_bt_traversals = new P1_BT_Recur_Traversals();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("Pre-Order traversal: " + p1_bt_traversals.preOrder_recur(root));

        System.out.println("In-Order traversal: " + p1_bt_traversals.inOrder_recur(root));

        System.out.println("Post-Order traversal: " + p1_bt_traversals.postOrder_recur(root));

        System.out.println("Level-Order traversal: " + p1_bt_traversals.levelOrderTraversal_recur(root));

    }
}
