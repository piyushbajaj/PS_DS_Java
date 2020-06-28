package BinaryTreeExample.GeeksForGeeks;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 29/08/17.
 */
public class DFS {
    Node root;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    DFS(){
        root = null;
    }

    DFS(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }

    public void push(int data){
        if(root == null)
            root = new Node(data);
        else{

        }
    }

    //PreOrder Traversal

    //Using Recursion First
    public void preOrder_Recursion(Node key){
        if(key == null)
            return;

        System.out.print(key.data + " ");
        preOrder_Recursion(key.left);
        preOrder_Recursion(key.right);
    }

    //Using Stacks
    public void preOrder_Iterative(Node key){
        if(key == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(key);

        while (!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);
        }

    }

    //InOrder Traversal
    public void inOrderTraversal_Recur(Node key){
        if(key == null)
            return;

        inOrderTraversal_Recur(key.left);
        System.out.print(key.data + " ");
        inOrderTraversal_Recur(key.right);
    }

    public void inOrderTraversal_Iterative(Node key){
        if(key == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node temp = key;

        boolean flag = true;

        while (flag){
            if(temp!=null) {
                stack.push(temp);
                temp = temp.left;
            }
            else if(stack.isEmpty())
                flag = false;
            else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    //PostOrder Traversal
    public void postOrderTraversal_Recur(Node key){
        if(key == null)
            return;

        postOrderTraversal_Recur(key.left);
        postOrderTraversal_Recur(key.right);
        System.out.print(key.data + " ");
    }

    public void postOrder_Iterative(Node key){
        if(key == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.add(key);
        Node prev = null;

        while (!stack.isEmpty()){
            Node curr = stack.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left!=null){
                    stack.push(curr.left);
                }
                else if(curr.right!=null)
                    stack.push(curr.right);
                else {
                    System.out.print(stack.pop().data + " ");
                }
            }
            else if(curr.left == prev){
                if(curr.right!=null)
                    stack.push(curr.right);
                else
                    System.out.print(stack.pop().data + " ");
            }
            else if(curr.right == prev) {
                System.out.print(stack.pop().data + " ");
                }
            prev = curr;
        }
    }

    /*
    * Inorder Tree Traversal without recursion and without stack!
    * */

    public void inOrderTraversal_Without_Stacks(Node key){
        if(key == null)
            return;

        Node curr = key;
        Node pred = null;

        while (curr!=null){
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else {
                //We have to find the predecessor of Current Node
                pred = curr.left;

                while (pred.right!=null && pred.right != curr)
                    pred = pred.right;

                //Now we have to link predecessor to Current Node
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }

                //In cases where we have utilized the use of thread connection, and now want to restore it back.
                else {
                    pred.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }
        }
    }

    //Pre Order Traversal Without Stacks
    public void preOrderTraversal_without_stacks(Node key){
        if(key == null)
            return;

        Node curr = key;
        Node pred = null;

        while (curr!=null){
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else {
                //We have to find the predecessor of Current Node
                pred = curr.left;

                while (pred.right!=null && pred.right != curr)
                    pred = pred.right;

                //Now we have to link predecessor to Current Node
                if(pred.right==null){
                    System.out.print(curr.data + " ");
                    pred.right = curr;
                    curr = curr.left;
                }

                //In cases where we have utilized the use of thread connection, and now want to restore it back.
                else {
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(1);
        dfs.root.left = new Node(2);
        dfs.root.right = new Node(3);
        dfs.root.left.left = new Node(4);
        dfs.root.left.right = new Node(5);
        dfs.root.right.left = new Node(6);
        dfs.root.right.right = new Node(7);

        System.out.println("Using Pre-Order Recursively: ");
        dfs.preOrder_Recursion(dfs.root);

        System.out.println();
        System.out.println("Using Pre-Order Iteratively: ");
        dfs.preOrder_Iterative(dfs.root);

        System.out.println();
        System.out.println("Using Pre-Order Iteratively without Stacks: ");
        dfs.preOrderTraversal_without_stacks(dfs.root);

        System.out.println();

        System.out.println("Using In-Order Recursively: ");
        dfs.inOrderTraversal_Recur(dfs.root);

        System.out.println();
        System.out.println("Using In-Order Iteratively: ");
        dfs.inOrderTraversal_Iterative(dfs.root);

        System.out.println();
        System.out.println("Using In-Order Iteratively without Stacks: ");
        dfs.inOrderTraversal_Without_Stacks(dfs.root);

        System.out.println();

        System.out.println("Using Post-Order Recursively: ");
        dfs.postOrderTraversal_Recur(dfs.root);

        System.out.println();
        System.out.println("Using Post-Order Iteratively: ");
        dfs.postOrder_Iterative(dfs.root);
    }


}
