package BinaryTree;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 18/03/17.
 * <p>
 * Algorithm for Iterative Approach:
 * 1. if(key==null) return;
 * 2. s.push(key);
 * 3. while(!s.isEmpty){
 * temp = s.pop();
 * System.out.print(temp + " ");
 * 4. if(temp.right!=null)
 * s.push(temp.right);
 * 5. if(temp.left!=null)
 * s.push(temp.left)
 * }
 * <p>
 * Time Complexity: O(n)
 */
public class preOrderTraversal {
    Node root;

    public static void main(String[] args) {
        preOrderTraversal PO = new preOrderTraversal();
        PO.push(6);
        PO.push(4);
        PO.push(9);
        PO.push(3);
        PO.push(5);
        PO.push(8);

        PO.printList(PO.root);
        System.out.println();

        System.out.print("Pre-Order using recursive technique is: ");
        PO.preOrder_recur(PO.root);


        System.out.println();
        System.out.print("Pre-Order using Iterative technique is: ");
        PO.preOrder_Iterative(PO.root);

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

    public void preOrder_recur(Node key) {
        if (key == null) {
            return;
        }

        System.out.print(key.data + " ");
        preOrder_recur(key.left);
        preOrder_recur(key.right);
    }

    public void preOrder_Iterative(Node key) {
        if (key == null) {
            return;
        }

        Stack<Node> stk = new Stack<>();
        stk.push(key);

        while (!stk.isEmpty()) {
            Node temp = stk.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stk.push(temp.right);
            }
            if (temp.left != null) {
                stk.push(temp.left);
            }
        }
    }

//    @Override
//    public String toString(){
//        return
//    }

    //InorderTraversal
    public void printList(Node key) {
        if (key == null) {
            return;
        }

        printList(key.left);
        System.out.print(key.data + " ");
        printList(key.right);
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
