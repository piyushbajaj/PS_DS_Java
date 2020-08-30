package TechboostJune2020.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBasicOperations {
    BTNode root;

    static class BTNode {
        BTNode left, right;
        int data;

        public BTNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }


    //DFS, T.C: O(N)
    // S.C: O(N)

    public int heightOfBT(BTNode Nd) {
        if(Nd == null) return 0;

        return Math.max(heightOfBT(Nd.left), heightOfBT(Nd.right)) + 1;
    }

    public int numberOfNodes(BTNode Nd) {
        if (Nd == null) return 0;

        return numberOfNodes(Nd.left) + numberOfNodes(Nd.right) + 1;
    }

    public int numberOfLeafNodes(BTNode Nd) {
        if (Nd == null) return 0;

        // Leaf Node Condition
        if( Nd.left == null && Nd.right == null)
            return 1;

        return numberOfLeafNodes(Nd.left) + numberOfLeafNodes(Nd.right);
    }



    public int maxData(BTNode root) {
        if (root == null) return Integer.MIN_VALUE;

        int maxLeft = maxData(root.left);
        int maxRight = maxData(root.right);

        return Math.max(Math.max(maxLeft, maxRight), root.data);
    }


    public int minData(BTNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int maxLeft = maxData(root.left);
        int maxRight = maxData(root.right);

        return Math.min(Math.min(maxLeft, maxRight), root.data);
    }

    // In-Order Traversal
    public void printTree_inOrder(BTNode Nd) {
        if (Nd == null ) {
            return;
        }
        printTree_inOrder(Nd.left);
        System.out.println(Nd.data + " ");
        printTree_inOrder(Nd.right);
    }

    //T.C: O(N)
    //S.C: O(logN)

    public void levelOrderTraversal_iterative(BTNode node) {
        if(node == null) {
            return;
        }

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BTNode temp = queue.remove();
            System.out.print(temp.data + " ");
            if(temp.left!=null) {
                queue.add(temp.left);
            }
            if(temp.right!=null) {
                queue.add(temp.right);
            }
        }
    }

    // T.C: O(N*N)
    // S.C: Height of Tree + Width of Tree => O(N) + O(logN) => O(N)
    public void printLevelOrder(BTNode node) {
        int height = heightOfBT(node);

        for(int h = 1; h <= height; h++ ) {
            levelOrderTraversal_spiral(node, h);
        }
    }


    // T.C: O(N)
    // S.C: O(Width of BT)
    public void levelOrderTraversal(BTNode node, int level) {
        // Base Check
        if (node == null)
            return;

        // Printing Current Data
        if (level == 1) {
            System.out.print(node.data + " ");
        }
        else {
            levelOrderTraversal(node.left, level -1);
            levelOrderTraversal(node.right, level -1);
        }
    }

    // T.C: O(N)
    // S.C: O(Width of BT)
    public void levelOrderTraversal_spiral(BTNode node, int level) {
        // Base Check
        if (node == null)
            return;

        // Printing Current Data
        if (level == 1) {
            System.out.print(node.data + " ");
        }
        else if (level % 2 == 0) {
            levelOrderTraversal_spiral(node.left, level -1);
            levelOrderTraversal_spiral(node.right, level -1);
        }
        else if (level % 2 != 0) {
            levelOrderTraversal_spiral(node.right, level -1);
            levelOrderTraversal_spiral(node.left, level -1);
        }
    }






    public static void main(String[] args) {
        TreeBasicOperations treeBasicOperations = new TreeBasicOperations();
        treeBasicOperations.root = new BTNode(1);
        treeBasicOperations.root.left = new BTNode(2);
        treeBasicOperations.root.right = new BTNode(3);
        treeBasicOperations.root.left.left = new BTNode(4);
        treeBasicOperations.root.left.right = new BTNode(5);
        treeBasicOperations.root.right.left = new BTNode(6);
        treeBasicOperations.root.right.right = new BTNode(7);

        treeBasicOperations.printTree_inOrder(treeBasicOperations.root);

        System.out.println("Height of Binary Tree: " + treeBasicOperations.heightOfBT(treeBasicOperations.root));

        System.out.println("Number of Nodes in Binary Tree: " + treeBasicOperations.numberOfNodes(treeBasicOperations.root));

        System.out.println("Number of Leaf Nodes in Binary Tree: " +
            treeBasicOperations.numberOfLeafNodes((treeBasicOperations.root)));

        System.out.println("Maximum data in Binary Tree: " +
            treeBasicOperations.maxData((treeBasicOperations.root)));

        System.out.println("Minimum data in Binary Tree: " +
            treeBasicOperations.minData((treeBasicOperations.root)));

        System.out.println("Level Order Traversal (Recursive) in Binary Tree: ");
        treeBasicOperations.printLevelOrder((treeBasicOperations.root));
        System.out.println();

        System.out.println("Level Order Traversal (Iterative) in Binary Tree: ");
        treeBasicOperations.levelOrderTraversal_iterative((treeBasicOperations.root));

    }
}
