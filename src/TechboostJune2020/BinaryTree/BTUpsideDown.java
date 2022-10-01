package TechboostJune2020.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTUpsideDown {
    TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderTraverse(TreeNode key) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        if (key == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(key);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                current.add(tmp.data);
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            } else {
                ArrayList<Integer> c_curr = new ArrayList<Integer>(current);
                res.add(c_curr);
                current.clear();
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
        return res;
    }


    TreeNode newRoot = null;

    private TreeNode upsideDownBinaryTreeRecur(TreeNode root) {
        if (root == null) {
            return null;
        }

        // left child
        TreeNode lc = upsideDownBinaryTreeRecur(root.left);
        // right child
        TreeNode rc = upsideDownBinaryTreeRecur(root.right);

        // Save the whole tree, new root.
        if (newRoot == null) {
            newRoot = root;
        }

        // if leaf node, return root itself.
        if (root.left == null && root.right == null) {
            return root;
        }

        // Avoid cycle.
        root.left = null;
        root.right = null;

        //3. The original right child becomes the new left child.
        lc.left = rc;
        //2. The original root becomes the new right child.
        lc.right = root;

        // Recursively propagate same operations to original tree parents.
        return root;

    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        upsideDownBinaryTreeRecur(root);
        return newRoot;
    }

    public static void main(String[] args) {
        BTUpsideDown btUpsideDown = new BTUpsideDown();
        btUpsideDown.root = new TreeNode(1);
        btUpsideDown.root.left = new TreeNode(2);
        btUpsideDown.root.right = new TreeNode(3);
        btUpsideDown.root.left.left = new TreeNode(4);
        btUpsideDown.root.left.right = new TreeNode(5);
        btUpsideDown.upsideDownBinaryTree(btUpsideDown.root);

        System.out.println(btUpsideDown.levelOrderTraverse(btUpsideDown.upsideDownBinaryTree(btUpsideDown.root)));
    }
}
