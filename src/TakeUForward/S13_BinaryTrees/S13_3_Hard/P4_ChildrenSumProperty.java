package TakeUForward.S13_BinaryTrees.S13_3_Hard;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.P5_Levelorder_Itr_Traversal;
import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S13_BinaryTrees.S13_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 02/10/22
 * Time: 5:11 pm
 * <p>
 */
public class P4_ChildrenSumProperty {

    /**
     * Approach:
     * 1. While going down the tree if curr.data > sum of left and right child, then replace both child with curr.data
     * 2. If curr.data < sum of left and right child, then replace curr.data with sum of left and right child
     * 3. then go to left and right child downwards
     * 4. Update curr.data with the sum of left and right child data
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     */
    public void childrenSumProperty(TreeNode curr) {
        if (curr != null) {
            int child = 0; // left child value + right child value

            if (curr.left != null) {
                child += curr.left.data;
            }

            if (curr.right != null) {
                child += curr.right.data;
            }

            if (curr.data > child) {
                if (curr.left != null) {
                    curr.left.data = curr.data;
                }
                if (curr.right != null) {
                    curr.right.data = curr.data;
                }
            } else {
                curr.data = child;
            }
            childrenSumProperty(curr.left);
            childrenSumProperty(curr.right);

            int total = 0;
            if (curr.left != null) {
                total += curr.left.data;
            }
            if (curr.right != null) {
                total += curr.right.data;
            }

            if (curr.left != null || curr.right != null) {
                curr.data = total;
            }
        }
    }

    public static void main(String[] args) {
        P4_ChildrenSumProperty p4_childrenSumProperty = new P4_ChildrenSumProperty();
        P5_Levelorder_Itr_Traversal p5_levelorder_itr_traversal = new P5_Levelorder_Itr_Traversal();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p5_levelorder_itr_traversal.levelOrderTraversal_iterative(root));
        p4_childrenSumProperty.childrenSumProperty(root);
        System.out.println(p5_levelorder_itr_traversal.levelOrderTraversal_iterative(root));
    }
}
