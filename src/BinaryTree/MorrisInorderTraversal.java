package BinaryTree;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 11/01/17.
 */


/*
Morris Inorder Traversal Algo: This is a step that intead of using strack and recursion we have another way

current = root;
while(current!=null){
        if(current.left==null){
        visit(current)
        current = current.right;
        }
       else
    {
    predecessor = findPredecessor(current)
    if(predecessor.right==null){
        predecessor.right = current;
        current = current.left;
        }
    else{
        predecessor.right = null;
        visit(current)
        current = current.right;
        }
    }
}
 */
public class MorrisInorderTraversal {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public MorrisInorderTraversal(){
        root = null;
    }

    public MorrisInorderTraversal(int key){
        root = new Node(key);
    }

    //Normal InOrderTraversal Using Stack which takes Time Complexity: O(n); Space Complexity: O(n)
    public void inOrderTraversal(Node key){
        if(key == null)
            return;
        Stack<Node> s = new Stack<>();
        Node temp = key;
        Boolean flag = false;
        while (!flag){
            if(temp!=null){
                s.push(temp);
                temp = temp.left;
            }
            else {
                if(s.isEmpty()){
                   flag = true;
                }
                else {
                    temp = s.pop();
                    System.out.print(temp.data + " ");
                    temp = temp.right;
                }
            }
        }
    }

    //This approach uses pointers to traverse inOrder Traversal with Space Complexity: O(1)
    public void inOrderTraversal_Morris(Node key){
        if(key == null)
            return;
        Node current = key;
        while (current!=null){
            if(current.left == null){
                System.out.print(current.data + " ");
                current = current.right;
            }
            else {
                findPredecessor(current, current.data);
                if(Pred.right == null){
                    Pred.right = current;
                    current = current.left;
                }
                else {
                    Pred.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }


    public static Node Pred;
    public static Node Succ;
    public void findPredecessor(Node key, int val){
        if(key == null)
            return;
        if(key!=null){
            if(key.data == val){
                if(key.left!=null){
                    Node temp = key.left;
                    //temp.right!=key included because to check if the next pointer is pointing to current node
                    while (temp.right!=null && temp.right!=key){
                        temp = temp.right;
                    }
                    Pred = temp;
                }
                if(key.right!=null){
                    Node temp = key.right;
                    while (temp.left!=null && temp.left!=key){
                        temp = temp.left;
                    }
                    Succ = temp;
                }
                return;
            }
            else if(val > key.data){
                Pred = key;
                findPredecessor(key.right, val);
            }
            else{
                Succ = key;
                findPredecessor(key.left, val);
            }
        }

    }

    public static void main(String[] args) {
        MorrisInorderTraversal BT = new MorrisInorderTraversal(40);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(20);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(60);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(10);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(30);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(50);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(70);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.inOrderTraversal(BT.root);


        System.out.println("After Morris Inorder Traversal: ");
        BT.inOrderTraversal_Morris(BT.root);
    }
}
