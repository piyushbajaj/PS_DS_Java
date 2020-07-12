package TechboostJune2020.Tree.BinaryTree;

public class Travsersal {

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
        Travsersal travsersal = new Travsersal();
        travsersal.root = new TreeNode(1);
        travsersal.root.left = new TreeNode(2);
        travsersal.root.right = new TreeNode(3);
        travsersal.root.left.left = new TreeNode(4);
        travsersal.root.left.right = new TreeNode(5);

        System.out.print("InOrder Traversal: ");
        travsersal.inOrderTraversal_recursive(travsersal.root);

        System.out.println();
        System.out.print("PreOrder Traversal: ");
        travsersal.preOrderTraversal_recursive(travsersal.root);

        System.out.println();
        System.out.print("PostOrder Traversal: ");
        travsersal.postOrderTraversal_recursive(travsersal.root);
    }

}
