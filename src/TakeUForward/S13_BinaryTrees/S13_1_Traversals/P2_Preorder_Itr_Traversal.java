package TakeUForward.S13_BinaryTrees.S13_1_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P2_Preorder_Itr_Traversal {

    /**
     * Iterative way of solving DFS problem using Stack
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> preOrder_iterative(TreeNode curr) {
        if (curr == null) return null;

        Stack<TreeNode> preOrderStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        preOrderStack.add(curr);

        while (!preOrderStack.isEmpty()) {
            TreeNode currNode = preOrderStack.pop();
            result.add(currNode.data);

            if (currNode.right != null) {
                preOrderStack.push(currNode.right);
            }
            if (currNode.left != null) {
                preOrderStack.push(currNode.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P2_Preorder_Itr_Traversal p2_preorder_traversal = new P2_Preorder_Itr_Traversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p2_preorder_traversal.preOrder_iterative(root));
    }
}
