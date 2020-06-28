package BinaryTreeExample.GeeksForGeeks;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 06/10/17.
 */
public class Convert_BT_Circular_DLL {
    Node root, head;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public Convert_BT_Circular_DLL(){
        root = null;
    }

    public Convert_BT_Circular_DLL(int key){
        root = new Node(key);
    }

    public void convert(Node key){
        if(key == null)
            return;

        boolean flag = true;
        Stack<Node> stack = new Stack<>();

        Stack<Node> stack1 = new Stack<>();
        stack.push(key);

        while (flag){
            if(key.left!=null) {
                stack.push(key.left);
                key = key.left;
            }
            else {
                if(stack.isEmpty()){
                    flag = false;
                }
                else {
                    key = stack.pop();
                    //System.out.print(key.data + " ");
                    stack1.push(key);
                    if(key.right!=null) {
                        stack.push(key.right);
                        key = key.right;
                    }
                }
            }
        }

        while (!stack1.isEmpty()){
            push(stack1.pop());
        }

        Node temp = head;

        while (temp.right!=null){
            temp = temp.right;
        }
        temp.right = head;
        head.left = temp;

        printList(head);

    }

    public void push(Node key){
        if(key == null)
            return;

        key.right = head;
        key.left = null;

        if(head!=null){
            head.left = key;
        }
        else
            head = key;

        head = key;
    }

    public void printList(Node key){
        if(key == null)
            return;

        System.out.print(key.data + " ");
        Node temp = key.right;
        while (key!=temp){
            System.out.print(temp.data + " ");
            temp = temp.right;

        }
    }

    public static void main(String[] args) {
        Convert_BT_Circular_DLL BT = new Convert_BT_Circular_DLL();

        BT.root= new Node(1);
        BT.root.left= new Node(2);
        BT.root.right= new Node(3);
        BT.root.left.left= new Node(4);
        BT.root.left.right= new Node(5);
        BT.root.right.left= new Node(6);
        BT.root.right.right= new Node(7);

        System.out.println("Circular Linked List is: ");
        BT.convert(BT.root);


        //BT.printList(BT.head);
    }


}
