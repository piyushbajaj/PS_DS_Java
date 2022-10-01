package BinaryTree;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 18/03/17.
 */
public class SpiralLevelOrderTraversal {
    Node root;

    static class Node {
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public void push(int val){
        Node new_node = new Node(val);
        if(root==null) {
            root = new_node;
            return;
        }

        Node temp = root;

        while (temp !=null){
            if(val< temp.data) {
                if(temp.left==null) {
                    temp.left = new_node;
                    return;
                }
                else {
                    temp = temp.left;
                }
            }
            else if(val > temp.data) {
                if(temp.right==null) {
                    temp.right = new_node;
                    return;
                }
                else {
                    temp = temp.right;
                }
            }
        }
    }

    //InorderTraversal
    public void printList(Node key){
        if(key==null)
            return;

        printList(key.left);
        System.out.print(key.data + " ");
        printList(key.right);
    }


    public void levelOrder_Iterative(Node key){
        if(key == null)
            return;

        Stack<Node> qll = new Stack<>();
        qll.push(key);

        while (!qll.isEmpty()){
            Node temp = qll.pop();
            System.out.print(temp.data + " ");
            if(temp.right!=null){
                qll.push(temp.right);
            }
            if(temp.left!=null){
                qll.push(temp.left);
            }

        }
    }

    public static void main(String[] args) {
        SpiralLevelOrderTraversal PO = new SpiralLevelOrderTraversal();
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


        System.out.println();
        System.out.print("Spiral Level Order using Iterative technique is: ");
        PO.levelOrder_Iterative(PO.root);

    }

}
