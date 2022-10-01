package BinaryTree;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 18/03/17.
 Algorithm for Post Order Traversal Iterative Approach:
 1. if key == null, then return;
 2. s.push(key)
 3. So consider two variables in PostOrder Traversal: prev and curr
 4. prev = null;
 5. while(!s.isEmpty){
    curr = s.peek();
 6. if(prev==null || prev.left == curr || prev.right == curr){
        if(curr.left!=null)
            s.push(curr.left);
        }
        else if(curr.right!=null)
            s.push(curr.right);
        else{
            System.out.print(s.pop() + " ");
        }
 7. else if(curr.left == prev){
        Node temp = s.peek();
        if(temp.right!=null)
            s.push(temp.right);
         else{
         System.out.print(s.pop() + " ");
         }
    }
 8. else if(curr.right == prev){
        System.out.print(s.pop() + " ");
    }
    prev = curr;
    }

 Time Complexity: O(n)
 */
public class postOrderTraversal {
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

    public void postOrder_recur(Node key){
        if(key == null)
            return;

        postOrder_recur(key.left);
        postOrder_recur(key.right);
        System.out.print(key.data + " ");
    }

    public void postOrder_Iterative(Node key){
        if(key == null)
            return;

        Stack<Node> stk = new Stack<>();
        stk.push(key);
        Node prev = null;

        while (!stk.isEmpty()){
            Node curr = stk.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left!=null)
                    stk.push(curr.left);
                else if(curr.right!=null)
                    stk.push(curr.right);
                else {
                    System.out.print(stk.pop().data + " ");
                }
            }
            else if(curr.left == prev){
                if(curr.right!=null){
                    stk.push(curr.right);
                }
                else {
                    System.out.print(stk.pop().data + " ");
                }
            }
            else if(curr.right==prev){
                  System.out.print(stk.pop().data + " ");
            }
            prev = curr;
        }

    }

    public static void main(String[] args) {
        postOrderTraversal PO = new postOrderTraversal();
        PO.push(6);
        PO.push(4);
        PO.push(9);
        PO.push(3);
        PO.push(5);
        PO.push(8);

        PO.printList(PO.root);
        System.out.println();

        System.out.print("Post-Order using recursive technique is: ");
        PO.postOrder_recur(PO.root);


        System.out.println();
        System.out.print("Post-Order using Iterative technique is: ");
        PO.postOrder_Iterative(PO.root);

    }

}
