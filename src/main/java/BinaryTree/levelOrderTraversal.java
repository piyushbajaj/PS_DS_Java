package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 18/03/17.
 * <p>
 * Algorithm for Level Order Traversal are:
 * 1. This has been implemented using Queues.
 * 2. Add an empty Queue:
 */
public class levelOrderTraversal {
    Node root;

    public static void main(String[] args) {
        levelOrderTraversal PO = new levelOrderTraversal();
        PO.push(6);
        PO.push(4);
        PO.push(9);
        PO.push(3);
        PO.push(5);
        PO.push(8);

        PO.printList(PO.root);
        System.out.println();

        //System.out.print("Post-Order using recursive technique is: ");
        //PO.inOrder_recur(PO.root);

        int ht = PO.height(PO.root);

        System.out.println();
        System.out.print("Level Order using Iterative technique is: ");
        PO.levelOrder_Iterative(PO.root);

        System.out.println();
        System.out.print("Level Order using Recursive technique is: ");
        PO.printBFS(PO.root);


        System.out.println();
        System.out.print("Spiral Order traversal using Recursive technique is: ");
        PO.printBFS_Spiral(PO.root);
    }

    public void push(int val) {
        Node new_node = new Node(val);
        if (root == null) {
            root = new_node;
            return;
        }

        Node temp = root;

        while (temp != null) {
            if (val < temp.data) {
                if (temp.left == null) {
                    temp.left = new_node;
                    return;
                } else {
                    temp = temp.left;
                }
            } else if (val > temp.data) {
                if (temp.right == null) {
                    temp.right = new_node;
                    return;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    //InorderTraversal
    public void printList(Node key) {
        if (key == null) {
            return;
        }

        printList(key.left);
        System.out.print(key.data + " ");
        printList(key.right);
    }


    public void levelOrder_Iterative(Node key) {
        if (key == null) {
            return;
        }

        Queue<Node> qll = new LinkedList<>();
        qll.add(key);

        while (!qll.isEmpty()) {
            Node temp = qll.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                qll.add(temp.left);
            }
            if (temp.right != null) {
                qll.add(temp.right);
            }
        }
    }

    ///Alternative way to take out BFS
    //Take out height of a tree
    public int height(Node key) {
        if (key == null) {
            return 0;
        }

        int lheight = height(key.left);
        int rheight = height(key.right);

        if (lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

    public void printBFS(Node key) {
        int height = height(key);

        for (int i = 1; i <= height; i++) {
            printSameLevel(key, i);
        }
    }

    public void printBFS_Spiral(Node key) {
        int height = height(key);

        for (int i = 1; i <= height; i++) {
            if (i % 2 == 0) {
                printSameLevel(key, i);
            } else if (i % 2 == 1) {
                printSameLevel_Spiral(key, i);
            }
        }
    }

    public void printSameLevel(Node key, int level) {
        if (key == null) {
            return;
        }

        if (level == 1) {
            System.out.print(key.data + " ");
            return;
        } else if (level > 1) {
            printSameLevel(key.left, level - 1);
            printSameLevel(key.right, level - 1);
        }
    }

    public void printSameLevel_Spiral(Node key, int level) {
        if (key == null) {
            return;
        }

        if (level == 1) {
            System.out.print(key.data + " ");
            return;
        } else if (level > 1 && (level % 2 == 0) || level % 2 == 1) {

            printSameLevel_Spiral(key.right, level - 1);
            printSameLevel_Spiral(key.left, level - 1);
        }
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

}
