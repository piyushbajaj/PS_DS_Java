package BinaryTree.GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 07/09/17.
 * Construct Complete Binary Tree from its Linked List Representation
 * Given Linked List Representation of Complete Binary Tree, construct the Binary tree. A complete binary tree can be
 * represented in an array in the following approach.

 If root node is stored at index i, its left, and right children are stored at indices 2*i+1, 2*i+2 respectively.
 Suppose tree is represented by a linked list in same way, how do we convert this into normal linked representation of
 binary tree where every node has data, left and right pointers? In the linked list representation, we cannot
 directly access the children of the current node unless we traverse the list.

 Algorithm:
 1. First create a root node and assign the header value to it, and then also add this to the queue.
 head = head.next
 2. Noe we will go until head reaches NULL.
 3. Create a Node Parent = queue.poll();
 then head = head.next;
 queue.add(parent)
 4. leftChild = null, rightChild = null.
 5. leftChild = new Node(head.data)
 queue.add(leftChild)
 head = head.next;
 6. if(head!=null){
 rightChild = new Node(head.data);
 queue.add(rightChild)
 head = head.next;
 }
 7. parent.left = leftChild;
 parent.right = rightChild;

 Time Complexity: O(n)

 */
public class LinkedList_to_BinaryTree {
    Node root;
    LNode head;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class LNode{
        LNode next;
        int data;
        LNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    LinkedList_to_BinaryTree(){
        head = null;
    }

    LinkedList_to_BinaryTree(int data){
        if(head == null)
            head = new LNode(data);
        else
            new LNode(data);
    }

    public Node constructTree_fromLL(LNode key){
        if(key == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        root = new Node(key.data);
        queue.add(root);
        key = key.next;

        while (key!=null){
            Node parent = queue.poll();
            Node leftChild = null, rightChild = null;

            leftChild = new Node(key.data);
            queue.add(leftChild);
            key = key.next;

            if(key!=null){
                rightChild = new Node(key.data);
                queue.add(rightChild);
                key = key.next;
            }

            parent.left = leftChild;
            parent.right = rightChild;


        }

        return root;
    }

    public void inOrder_Traversal(Node key){
        if(key == null)
            return;

        inOrder_Traversal(key.left);
        System.out.print(key.data + " ");
        inOrder_Traversal(key.right);
    }

    public int getCount(LNode key){
        if(key == null)
            return 0;

        int count = 0;

        while (key!=null){
            key = key.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        LinkedList_to_BinaryTree ll = new LinkedList_to_BinaryTree();
        ll.head = new LNode(10);
        ll.head.next = new LNode(12);
        ll.head.next.next = new LNode(15);
        ll.head.next.next.next = new LNode(25);
        ll.head.next.next.next.next = new LNode(30);
        ll.head.next.next.next.next.next = new LNode(36);

        ll.constructTree_fromLL(ll.head);

        ll.inOrder_Traversal(ll.root);
    }
}
