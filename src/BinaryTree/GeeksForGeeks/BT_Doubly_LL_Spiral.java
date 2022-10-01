package BinaryTree.GeeksForGeeks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 04/10/17.
 * Algorithm:
 * 1. Here we use Deque to store the values in front and back.
 * 2. So in the start will insert root to Dequeue.
 * 3. Then will go to Odd level and even level.
 * 4. For Even level, will remove element from last and push to stack. While will move its right children to front, and
 * then will move left children to front.
 * 5. For Odd level, will remove element from front, add it to stack, and then will add its left child to end, and then
 * right child to the end.
 */
public class BT_Doubly_LL_Spiral {
    Node root, head;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public BT_Doubly_LL_Spiral(){
        root = null;
    }

    public BT_Doubly_LL_Spiral(int key){
        root = new Node(key);
    }

    public Node convert(Node key){
        if(key == null)
            return null;


        return null;
    }



    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public void spiralLevelOrder(Node key){
        if(key == null)
            return;

        Deque<Node> deque = new LinkedList<>();
        deque.add(key);

        Stack<Node> stack = new Stack<>();
        int level = 0;

        while (!deque.isEmpty()){
            int NC = deque.size(); //Node Count


            //Odd Case
            if(level%2 != 0){
                while(NC > 0) {
                    Node temp = deque.pollFirst();
                    stack.push(temp);

                    if (temp.left != null)
                        deque.addLast(temp.left);
                    if (temp.right != null)
                        deque.addLast(temp.right);

                    NC--;
                }
            }

            //Even Case
            else{
                while (NC > 0) {
                    Node temp = deque.pollLast();
                    stack.push(temp);

                    if (temp.right != null)
                        deque.addFirst(temp.right);
                    if (temp.left != null)
                        deque.addFirst(temp.left);

                    NC--;
                }
            }
            level++;
        }

        while (!stack.isEmpty()){
            push(stack.pop());
        }

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

    public static void main(String[] args) {
        BT_Doubly_LL_Spiral BT = new BT_Doubly_LL_Spiral();

        BT.root= new Node(1);
        BT.root.left= new Node(2);
        BT.root.right= new Node(3);
        BT.root.left.left= new Node(4);
        BT.root.left.right= new Node(5);
        BT.root.right.left= new Node(6);
        BT.root.right.right= new Node(7);
        BT.root.left.left.left = new Node(8);
        BT.root.left.left.right = new Node(9);
        BT.root.left.right.left = new Node(10);
        BT.root.left.right.right = new Node(11);
        BT.root.right.left.left= new Node(12);
        BT.root.right.left.right= new Node(13);
        BT.root.right.right.left= new Node(14);
        BT.root.right.right.right= new Node(15);

        BT.spiralLevelOrder(BT.root);

        //BT.printList(BT.root);

    }
}
