package TakeUForward.S13_BinaryTrees.S13_1_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P3_Inorder_Itr_Traversal {

    /**
     * Left - Root - Right
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> inOrder_iterative(TreeNode curr) {
        if (curr == null) return null;

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> inOrderStack = new Stack<>();
        boolean flag = false;

        while (!flag) {
            if (curr != null) {
                inOrderStack.push(curr);
                curr = curr.left;
            } else {
                if (inOrderStack.isEmpty()) {
                    flag = true;
                } else {
                    curr = inOrderStack.pop();
                    result.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P3_Inorder_Itr_Traversal p3_inorder_itr_traversal = new P3_Inorder_Itr_Traversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p3_inorder_itr_traversal.inOrder_iterative(root));

    }
}
