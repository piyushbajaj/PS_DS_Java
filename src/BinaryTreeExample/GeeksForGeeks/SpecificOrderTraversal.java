package BinaryTreeExample.GeeksForGeeks;

import java.util.*;

/**
 * Created by piyush.bajaj on 05/09/17.
 */
public class SpecificOrderTraversal {
    Node root;

    static class Node{
        Node left, right;
        int data;
        boolean visited;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
            this.visited = false;
        }
    }

    SpecificOrderTraversal(){
        root = null;
    }

    SpecificOrderTraversal(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }

    public void levelOrderTraversal_special(Node key){
        if(key == null)
            return;

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(key);
        queue2.add(key);

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            Node temp1 = queue1.poll();
            Node temp2 = queue2.poll();

            if(temp1.data ==temp2.data) {
                System.out.print(temp1.data + " ");
                if(temp1.left!=null){
                    queue1.add(temp1.left);
                }
                if(temp2.right!=null){
                    queue2.add(temp2.right);
                }
            }

            else {
                System.out.print(temp1.data + " " + temp2.data + " ");

                if(temp1.left!=null){
                    queue1.add(temp1.left);
                }
                if(temp2.right!=null){
                    queue2.add(temp2.right);
                }
                if(temp1.right!=null){
                    queue1.add(temp1.right);
                }
                if(temp2.left!=null){
                    queue2.add(temp2.left);
                }
            }


            //System.out.print(temp.data + " ");

        }



    }

    public void levelOrderTraversal_special_better(Node key){
        if(key == null)
            return;

        Queue<Node> queue = new LinkedList<>();

        System.out.print(key.data + " ");

        if(key.left==null)
            return;

        System.out.print(key.left.data + " ");

        System.out.print(key.right.data + " ");

        if(key.left.left == null)
            return;

        queue.add(key.left);
        queue.add(key.right);

        while (!queue.isEmpty()){
            Node first = queue.poll();
            Node second = queue.poll();

            System.out.print(first.left.data + " " + second.right.data + " ");
            System.out.print(first.right.data + " " + second.left.data + " ");

            if(first.left.left!=null) {
                queue.add(first.left);
                queue.add(second.right);
                queue.add(first.right);
                queue.add(second.left);
            }
        }

    }

    public int getHeight_iterative(Node key){
        int count = 0;

        if(key == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(key);

        while (true){
            int nodeCount = queue.size();
            if(nodeCount == 0)
                break;

            while (nodeCount>0){
                Node temp = queue.remove();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
                nodeCount--;
            }
            count++;
        }
        return count;
    }

    public void levelOrderTraversal_reversal(Node key){
        if(key == null)
            return;

        Stack<Integer> stack = new Stack<>();
        stack.push(key.data);

        if(key.left!=null){
            stack.push(key.right.data);
            stack.push(key.left.data);

        }

        if(key.left.left != null){
            levelOrderTraversal_reversal_util(key, stack);
        }


        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }



    }

    public void levelOrderTraversal_reversal_util(Node key, Stack<Integer> stack){
        if(key == null)
            return;

        Queue<Node> queue = new LinkedList<>();

        //System.out.print(key.data + " ");

        if(key.left==null)
            return;

        //System.out.print(key.left.data + " ");

        //System.out.print(key.right.data + " ");

        if(key.left.left == null)
            return;

        queue.add(key.left);
        queue.add(key.right);

        while (!queue.isEmpty()){
            Node first = queue.poll();
            Node second = queue.poll();

            //System.out.print(first.left.data + " " + second.right.data + " ");
            //System.out.print(first.right.data + " " + second.left.data + " ");

            stack.push(second.left.data);
            stack.push(first.right.data);
            stack.push(second.right.data);
            stack.push(first.left.data);

            if(first.left.left!=null) {
                queue.add(first.right);
                queue.add(second.left);
                queue.add(first.left);
                queue.add(second.right);
            }
        }

    }

    public static void main(String[] args) {
        SpecificOrderTraversal bfs = new SpecificOrderTraversal(1);
        bfs.root.left = new Node(2);
        bfs.root.right = new Node(3);
        bfs.root.left.left = new Node(4);
        bfs.root.left.right = new Node(5);
        bfs.root.right.left = new Node(6);
        bfs.root.right.right = new Node(7);
        bfs.root.left.left.left = new Node(8);
        bfs.root.left.left.right = new Node(9);
        bfs.root.left.right.left = new Node(10);
        bfs.root.left.right.right = new Node(11);
        bfs.root.right.left.left = new Node(12);
        bfs.root.right.left.right = new Node(13);
        bfs.root.right.right.left = new Node(14);
        bfs.root.right.right.right = new Node(15);



        System.out.println("Printing in Special BFS pattern using iterative approach: ");
        bfs.levelOrderTraversal_special(bfs.root);
        System.out.println();

        System.out.println("Printing in Special BFS pattern using iterative approach in a better way: ");
        bfs.levelOrderTraversal_special_better(bfs.root);
        System.out.println();


        System.out.println("Printing in Special BFS Reversal pattern using iterative approach: ");
        bfs.levelOrderTraversal_reversal(bfs.root);
        System.out.println();
    }


}
