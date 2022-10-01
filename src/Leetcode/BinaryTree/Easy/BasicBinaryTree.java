package Leetcode.BinaryTree.Easy;

import java.util.Stack;

public class BasicBinaryTree {
    TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public int heightOfTree(TreeNode ptr) {
        if (ptr == null)
            return 0;

        int height_L = heightOfTree(ptr.left);
        int height_R = heightOfTree(ptr.right);

        return Math.max(height_L, height_R) + 1;
    }

    public int numberOfNodes(TreeNode ptr) {
        if (ptr == null)
            return 0;

        int max_L = numberOfNodes(ptr.left);
        int max_R = numberOfNodes(ptr.right);

        return max_L + max_R + 1;
    }

    public int maxElement(TreeNode ptr) {
        if (ptr == null)
            return -1;

        int max_L = maxElement(ptr.left);
        int max_R = maxElement(ptr.right);

        return Math.max(ptr.data, Math.max(max_L, max_R));
    }

    public int numberOfLeafNodes(TreeNode ptr) {
        if (ptr == null)
            return 0;

        if (ptr.left == null && ptr.right == null) {
            return 1;
        }

        int max_L = numberOfLeafNodes(ptr.left);
        int max_R = numberOfLeafNodes(ptr.right);

        return max_L + max_R;

    }

    public TreeNode BTreeSearch(TreeNode ptr, int data) {
        if (ptr == null)
            return null;

        if (ptr.data == data) {
            return ptr;
        }

        TreeNode searchLeft = BTreeSearch(ptr.left, data);
        if (searchLeft != null)
            return searchLeft;

        TreeNode searchRight = BTreeSearch(ptr.right, data);
        if (searchRight != null)
            return searchRight;

        return null;
    }

    public void preOrderTraversal_recursive(TreeNode ptr) {
        if (ptr == null)
            return;

        System.out.print(ptr.data + " ");
        preOrderTraversal_recursive(ptr.left);
        preOrderTraversal_recursive(ptr.right);
    }

    public void preOrderTraversal_iterative(TreeNode ptr) {
        if (ptr == null)
            return;

        Stack<TreeNode> s = new Stack();
        s.push(ptr);
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
        }
    }

    public void inOrderTraversal_recursive(TreeNode ptr) {
        if (ptr == null)
            return;

        inOrderTraversal_recursive(ptr.left);
        System.out.print(ptr.data + " ");
        inOrderTraversal_recursive(ptr.right);
    }

    public void inOrderTraversal_iterative(TreeNode ptr) {
        if (ptr == null)
            return;

        Stack<TreeNode> s = new Stack();
        boolean flag = false;

        TreeNode temp = ptr;

        while (!flag) {
            if (temp != null) {
                s.push(temp);
                temp = temp.left;
            } else {
                if (s.isEmpty()) {
                    flag = true;
                } else {
                    temp = s.pop();
                    System.out.print(temp.data + " ");
                    temp = temp.right;
                }
            }
        }
    }

    public void postOrderTraversal_recursive(TreeNode ptr) {
        if (ptr == null)
            return;

        postOrderTraversal_recursive(ptr.left);
        postOrderTraversal_recursive(ptr.right);
        System.out.print(ptr.data + " ");
    }

    public void postOrderTraversal_iterative(TreeNode ptr) {
        if (ptr == null)
            return;

        TreeNode prev = null;
        TreeNode curr = ptr;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);

        while (!stack.isEmpty()) {
            curr = stack.peek();

            // Check if the prev pointer is satisfying the tree condition
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    System.out.print(stack.pop().data + " ");
                }
            } else if (curr.left == prev) {
                TreeNode temp = stack.peek();
                if (temp.right != null) {
                    stack.push(temp.right);
                } else {
                    System.out.print(stack.pop().data + " ");
                }
            } else {
                System.out.print(stack.pop().data + " ");
            }
            prev = curr;
        }
    }

    public void levelOrderTraversal(TreeNode key) {
        if (key == null) return;

        int height = getHeight(key);
        for (int i = 1; i <= height; i++) {
            levelOrderTraversal_util(key, i);
        }

    }

    public void levelOrderTraversal_util(TreeNode key, int level) {
        if (key == null) return;

        if (level == 1) {
            System.out.print(key.data + " ");
        } else if (level > 1) {
            levelOrderTraversal_util(key.left, level - 1);
            levelOrderTraversal_util(key.right, level - 1);
        }
    }

    public int getHeight(TreeNode key) {
        if (key == null)
            return 0;

        int lHeight = getHeight(key.left);
        int rHeight = getHeight(key.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public boolean areIdenticalBT(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null && root2 != null) return false;

        if (root1 != null && root2 == null) return false;

        if (root1.data != root2.data) return false;

        return areIdenticalBT(root1.left, root2.left) && areIdenticalBT(root1.right, root2.right);
    }

    public static void main(String[] args) {
        BasicBinaryTree basicBinaryTree = new BasicBinaryTree();
        basicBinaryTree.root = new TreeNode(4);
        basicBinaryTree.root.left = new TreeNode(2);
        basicBinaryTree.root.left.left = new TreeNode(1);
        basicBinaryTree.root.left.right = new TreeNode(3);
        basicBinaryTree.root.right = new TreeNode(6);
        basicBinaryTree.root.right.left = new TreeNode(5);
        basicBinaryTree.root.right.right = new TreeNode(7);
        basicBinaryTree.root.right.right.right = new TreeNode(8);

        BasicBinaryTree basicBinaryTree2 = new BasicBinaryTree();
        basicBinaryTree2.root = new TreeNode(4);
        basicBinaryTree2.root.left = new TreeNode(2);
        basicBinaryTree2.root.left.left = new TreeNode(1);
        basicBinaryTree2.root.left.right = new TreeNode(3);
        basicBinaryTree2.root.right = new TreeNode(6);
        basicBinaryTree2.root.right.left = new TreeNode(5);
        basicBinaryTree2.root.right.right = new TreeNode(7);
        basicBinaryTree2.root.right.right.right = new TreeNode(9);

        System.out.print("Pre-Order Traversal: ");
        basicBinaryTree.preOrderTraversal_recursive(basicBinaryTree.root);

        System.out.println();
        System.out.print("Pre-Order Traversal Iterative: ");
        basicBinaryTree.preOrderTraversal_iterative(basicBinaryTree.root);

        System.out.println();
        System.out.print("In-Order Traversal: ");
        basicBinaryTree.inOrderTraversal_recursive(basicBinaryTree.root);
        System.out.println();

        System.out.print("In-Order Traversal Iterative: ");
        basicBinaryTree.inOrderTraversal_iterative(basicBinaryTree.root);
        System.out.println();

        System.out.print("Post-Order Traversal: ");
        basicBinaryTree.postOrderTraversal_recursive(basicBinaryTree.root);

        System.out.println();
        System.out.print("Post-Order Traversal Iterative: ");
        basicBinaryTree.postOrderTraversal_iterative(basicBinaryTree.root);

        System.out.println();
        System.out.println("Height of the tree: " + basicBinaryTree.heightOfTree(basicBinaryTree.root));

        System.out.println();
        System.out.println("Maximum number of nodes in the tree: " + basicBinaryTree.numberOfNodes(basicBinaryTree.root));

        System.out.println();
        System.out.println("Maximum element in the tree: " + basicBinaryTree.maxElement(basicBinaryTree.root));

        System.out.println();
        System.out.println("Number of Leaf Nodes in the tree: " + basicBinaryTree.numberOfLeafNodes(basicBinaryTree.root));

        System.out.println();
        if (basicBinaryTree.BTreeSearch(basicBinaryTree.root, 2) != null) {
            System.out.println("Searching this node in the Binary Tree: " + basicBinaryTree.BTreeSearch(basicBinaryTree.root, 2).data);
        } else {
            System.out.println("Searching this node in the Binary Tree: " + basicBinaryTree.BTreeSearch(basicBinaryTree.root, 2));
        }

        System.out.println();
        System.out.print("Level Order Traversal: ");
        basicBinaryTree.levelOrderTraversal(basicBinaryTree.root);

        System.out.print(basicBinaryTree.areIdenticalBT(basicBinaryTree.root, basicBinaryTree2.root));
    }
}
