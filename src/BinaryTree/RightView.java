package BinaryTree;

import java.util.LinkedList;

/**
 * Created by piyush.bajaj on 23/07/17.
 */
public class RightView {
    Node root;
    int maxLevelSeenSoFar = -1;

    RightView(int data) {
        if (root == null) {
            root = new Node(data);
        }
    }

    public static void main(String[] args) {
        RightView BT = new RightView(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.root.left.left.left = new Node(8);
        BT.root.left.left.left.right = new Node(10);
        System.out.println("According to InOrder Traversal: ");
        BT.printTree(BT.root);

        System.out.println();

        System.out.println("According to BFS Traversal: ");
        BT.levelOrderTraversal(BT.root);

        System.out.println();

        System.out.println("Right view of the tree is: ");
        BT.levelOrderTraversal_rightView(BT.root);

        System.out.println();

        System.out.println("Right view of the tree using Recursive approach is: ");
        BT.rightView_recursive(BT.root, 0);
    }

    public void levelOrderTraversal(Node key) {
        if (key == null) {
            return;
        }

        int level = height(key);

        for (int i = 0; i < level; i++) {
            levelOrderTraversal_Util(key, i);

        }
    }


    public void levelOrderTraversal_Util(Node key, int level) {
        if (key == null) {
            return;
        }

        if (level == 0) {
            System.out.print(key.data + " ");
            return;
        } else {
            levelOrderTraversal_Util(key.left, level - 1);
            levelOrderTraversal_Util(key.right, level - 1);
        }
    }

    public void levelOrderTraversal_rightView(Node key) {
        int maxLevelSeenSoFar = -1;
        //int level = height(key);
        //for(int i = 0; i < level; i++){
        levelOrderTraversal_rightView_util(key, maxLevelSeenSoFar);

        //}

    }


    public void levelOrderTraversal_rightView_util(Node key, int maxLevelSeenSoFar) {
        if (key == null) {
            return;
        }


        LinkedList<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(key, 0));

        while (!queue.isEmpty()) {
            QueueNode qN = queue.remove();
            if (qN.level > maxLevelSeenSoFar) {
                System.out.print(qN.qnode.data + " ");
                maxLevelSeenSoFar = qN.level;
            }
            if (qN.qnode.right != null) {
                queue.add(new QueueNode(qN.qnode.right, qN.level + 1));
            }
            if (qN.qnode.left != null) {
                queue.add(new QueueNode(qN.qnode.left, qN.level + 1));
            }

        }


    }

    public void rightView_recursive(Node key, int currentLevel) {
        if (key == null) {
            return;
        }

        if (currentLevel > maxLevelSeenSoFar) {
            System.out.print(key.data + " ");
            maxLevelSeenSoFar = currentLevel;
            //return;
        }

        //else {
        //  if(key.right!=null)
        rightView_recursive(key.right, currentLevel + 1);
        //else
        rightView_recursive(key.left, currentLevel + 1);

        //}
    }

    public int height(Node key) {
        if (key == null) {
            return 0;
        }
        int leftcount = height(key.left);
        int rightcount = height(key.right);

        if (leftcount > rightcount) {
            return leftcount + 1;
        } else {
            return rightcount + 1;
        }
    }

    //InOrderTraversal
    public void printTree(Node key) {
        if (key == null) {
            return;
        }

        printTree(key.left);
        System.out.print(key.data + " ");
        printTree(key.right);
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class QueueNode {
        Node qnode;
        int level;

        QueueNode(Node qnode, int level) {
            this.qnode = qnode;
            this.level = level;
        }

    }
}
