package TechboostJune2020.BinaryTree;

public class RecursiveTraversal {

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

    //T.C: O(N)
    //S.C: O(N)
    // InOrder Traversal Using Recursive Approach
    public void inOrderTraversal_recursive (TreeNode node) {
        if (node == null) return;

        inOrderTraversal_recursive(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal_recursive(node.right);
    }

    // PreOrder Traversal Using Recursive Approach
    public void preOrderTraversal_recursive (TreeNode node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        preOrderTraversal_recursive(node.left);
        preOrderTraversal_recursive(node.right);
    }

    public void postOrderTraversal_recursive (TreeNode node) {
        if(node == null) return;

        postOrderTraversal_recursive(node.left);
        postOrderTraversal_recursive(node.right);
        System.out.print(node.data + " ");
    }


    public static void main(String[] args) {
        RecursiveTraversal recursiveTraversal = new RecursiveTraversal();
        recursiveTraversal.root = new TreeNode(1);
        recursiveTraversal.root.left = new TreeNode(2);
        recursiveTraversal.root.right = new TreeNode(3);
        recursiveTraversal.root.left.left = new TreeNode(4);
        recursiveTraversal.root.left.right = new TreeNode(5);
        recursiveTraversal.root.right.left = new TreeNode(6);
        recursiveTraversal.root.right.right = new TreeNode(7);

        System.out.print("InOrder Traversal: ");
        recursiveTraversal.inOrderTraversal_recursive(recursiveTraversal.root);

        System.out.println();
        System.out.print("PreOrder Traversal: ");
        recursiveTraversal.preOrderTraversal_recursive(recursiveTraversal.root);

        System.out.println();
        System.out.print("PostOrder Traversal: ");
        recursiveTraversal.postOrderTraversal_recursive(recursiveTraversal.root);
    }

}
