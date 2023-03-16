package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P4_Postorder_Itr_Traversal {

    /**
     * Post Order Traversal
     * Left -> Right -> Root
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> postOrder_iterative(TreeNode curr) {
        if (curr == null) {
            return null;
        }

        // Store previous node
        TreeNode prevNode = null;
        // Store current node
        TreeNode currNode = null;

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> postOrderStack = new Stack<>();
        postOrderStack.push(curr);

        while (!postOrderStack.isEmpty()) {
            currNode = postOrderStack.peek();

            // This check ensures that node will keep checking left and right node while traversing generally
            if (prevNode == null || prevNode.left == currNode || prevNode.right == currNode) {
                if (currNode.left != null) {
                    postOrderStack.push(currNode.left);
                } else if (currNode.right != null) {
                    postOrderStack.push(currNode.right);
                } else {
                    postOrderStack.pop();
                    result.add(currNode.data);
                }
            } else if (currNode.left == prevNode) {
                if (currNode.right != null) {
                    postOrderStack.push(currNode.right);
                }
            } else {
                postOrderStack.pop();
                result.add(currNode.data);
            }

            prevNode = currNode;
        }

        return result;
    }

    public static void main(String[] args) {
        P4_Postorder_Itr_Traversal p4_postorder_itr_traversal = new P4_Postorder_Itr_Traversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p4_postorder_itr_traversal.postOrder_iterative(root));
    }
}
