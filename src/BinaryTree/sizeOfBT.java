package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 17/12/16.
 */
public class sizeOfBT {
    Node root;

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public sizeOfBT() {
        root = null;
    }

    public sizeOfBT(int key) {
        root = new Node(key);
    }

    public int sizeOfBinaryTree(Node key) {
        //int count =0;
        if (key == null)
            return -1;
        int leftNode = key.left == null ? 0 : sizeOfBinaryTree(key.left);
        int rightNode = key.right == null ? 0 : sizeOfBinaryTree(key.right);

        return 1 + leftNode + rightNode;
    }

    //Using Level Order Traversal

    public int sizeOfBinaryTree_Iterative(Node key) {
        if (key == null)
            return -1;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(key);
        int count = 1;

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp != null) {
                if (temp.left != null) {
                    queue.add(temp.left);
                    count++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    count++;
                }
            }
        }
        return count;
    }

    int leftcount = 0;
    int rightcount = 0;

    public int heightOfBinaryTree(Node key) {


        if (key == null)
            return 0;
        else {
            if (key != null) {
                if (key.left != null) {
                    leftcount++;
                    heightOfBinaryTree(key.left);
                }
                if (key.right != null) {
                    rightcount++;
                    heightOfBinaryTree(key.right);
                }
            }
        }
        if (leftcount > rightcount)
            return leftcount;
        else
            return rightcount;
    }

    //Shortcut way for recursively height calculation
    public int heightOfBinaryTree_Recursive(Node key) {
        if (key == null)
            return 0;
        int leftcount = heightOfBinaryTree_Recursive(key.left);
        int rightcount = heightOfBinaryTree_Recursive(key.right);

        return (leftcount > rightcount) ? leftcount + 1 : rightcount + 1;
    }

    public int heightOfBinaryTree_Using_Stack(Node key) {
        if (key == null)
            return 0;
        int maxDepth = 0;
        Stack<Node> s = new Stack<Node>();
        Node prev = null;
        s.push(key);

        while (!s.empty()) {
            Node current = s.peek();
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    s.push(current.left);
                else if (current.right != null)
                    s.push(current.right);
//                else
//                    s.pop();
            } else if (current.left == prev) {
                if (current.right != null)
                    s.push(current.right);
//                else
//                    s.pop();
            } else
//            else if(current.right==prev)
                s.pop();
            prev = current;

            if (s.size() > maxDepth)
                maxDepth = s.size();
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        sizeOfBT BT = new sizeOfBT(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println("Size of a Binary Tree from Root is: " + BT.sizeOfBinaryTree(BT.root));

        System.out.println("Size of a Binary Tree from Root is: " + BT.sizeOfBinaryTree_Iterative(BT.root));

        System.out.println("Height of a Binary Tree from Root is: " + BT.heightOfBinaryTree(BT.root));

        System.out.println("Height of a Binary Tree from Root using recursive is: " + BT.heightOfBinaryTree_Recursive(BT.root));

        System.out.println("Height of a Binary Tree from Root using stack is: " + BT.heightOfBinaryTree_Using_Stack(BT.root));


    }


}
