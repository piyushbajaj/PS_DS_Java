package BinaryTreeExample;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 18/03/17.
 Algorithm for InOrder Traversal (Recursive Approach):
 1.  Let the function be InOrder(Node key)
 2. if key == null then return;
 3. InOrder(key.left);
 4. InOrder(key.right);
 5. return;

 Algorithm for InOrder Traversal (Iterative Approach):
 1. First we need to check if root is only null, then return.
 2. Always remember in case of Inorder Traversal we have to define FLAG boolean = false.
 2. Define Stack as Node type.
 3. Push the first node into Stack.
 4. While (!flag){
 5. Node temp = key;
 6. Check if(temp!=null){
 Stk.push(temp);
 temp = temp.left;
 }
 7. Else{
 if(stk.isEmpty){
 flag = true;
 }
 else{
 temp = stk.pop();
 System.out.print(temp.data + " ");
 temp = temp.right;
 }
 }
 }

 Time Complexity: O(n)
 */
public class inOrderTraversal {
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

    //Flag is the key here
    public void inOrder_Iterative(Node key){
        if(key == null)
            return;

        Stack<Node> stk = new Stack<>();
        //stk.push(key);

        Node temp = key;
        boolean flag = false;
        while (!flag){
            if(temp!=null){
                stk.push(temp);
                temp = temp.left;
            }
            else {
                if(stk.isEmpty())
                    flag = true;
                else {
                    temp = stk.pop();
                    System.out.print(temp.data + " ");
                    temp = temp.right;
                    //if(temp)
                }
            }
        }
    }

    public static void main(String[] args) {
        inOrderTraversal PO = new inOrderTraversal();
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
        System.out.print("In-Order using Iterative technique is: ");
        PO.inOrder_Iterative(PO.root);

    }
}
