package TakeUForward.S14_BST.S14_1;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_1
 * <p>
 * User: piyushbajaj
 * Date: 02/10/22
 * Time: 4:44 pm
 * <p>
 * Link: https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class P2_SearchInBST {

    /**
     * TC: O(logN)
     * SC: O(1)
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.data == val) {
            return root;
        }

        if (root.data > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        P2_SearchInBST p2_searchInBST = new P2_SearchInBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p2_searchInBST.searchBST(root, 7) == null ? null :
            p2_searchInBST.searchBST(root, 7).data);
    }

}
