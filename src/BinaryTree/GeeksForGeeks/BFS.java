package BinaryTree.GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 29/08/17.
 */
public class BFS {
    Node root;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    BFS(){
        root = null;
    }

    BFS(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }



    //Using Iterative Approach
    public void levelOrderTraversal(Node key){
        if(key == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(key);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
    }


    //Printing Level Order Traversal Line by Line
    public void levelOrderTraversal_line(Node key){
        if(key == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(key);
        while (true){
            int NodeSize = queue.size();
            if(NodeSize == 0)
                break;

            while (NodeSize > 0) {
                Node temp = queue.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                NodeSize--;
            }
            System.out.println();
        }
    }

    //Using Recursive Approach
    public void levelOrderTraversal_recur(Node key){
        if(key == null)
            return;

        int level = getHeight(key);

        for(int i = 0; i < level; i++){
            levelOrderTraversal_recur_util(key, i);
        }

    }

    public void levelOrderTraversal_recur_util(Node key, int i){
        if(key == null)
            return;

        if(i == 0){
            System.out.print(key.data + " ");
            return;
        }

        else {
            levelOrderTraversal_recur_util(key.left, i-1);
            levelOrderTraversal_recur_util(key.right, i-1);
        }
    }

    //We got this using recursive approach
    public int getHeight(Node key){
        if(key == null)
            return 0;

        int lCount = getHeight(key.left);
        int rCount = getHeight(key.right);

        return lCount > rCount? lCount+1: rCount+1;
    }


    //We can also get height using iterative approach
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

    //Reverse of Level Order Traversal using Recursion
    public void reverse_level_order_traversal(Node key){
        if(key == null)
            return;

        int level = getHeight_iterative(key);
        for(int i = level - 1; i >= 0; i--){
            reverse_level_order_traversal_util(key, i, 0);
        }
    }

    public void reverse_level_order_traversal_util(Node key, int level, int height){
        if(key == null || height > level)
            return;

        if(level == height){
            System.out.print(key.data + " ");
            return;
        }
        else {
            reverse_level_order_traversal_util(key.left, level, height+1);
            reverse_level_order_traversal_util(key.right, level, height+1);
        }
        return;

    }

    //Reverse of Level Order Traversal using Iterative Approach
    public void reverse_level_order_traversal_iterative(Node key){
        if(key == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(key);
        while (true){
            int NodeSize = queue.size();
            if(NodeSize == 0)
                break;

            while (NodeSize > 0) {
                Node temp = stack.push(queue.poll());
                if (temp.right != null)
                    queue.add(temp.right);
                if (temp.left != null)
                    queue.add(temp.left);
                NodeSize--;
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop().data + " ");
        }
    }


    public static void main(String[] args) {
        BFS bfs = new BFS(1);
        bfs.root.left = new Node(2);
        bfs.root.right = new Node(3);
        bfs.root.left.left = new Node(4);
        bfs.root.left.right = new Node(5);
        bfs.root.right.left = new Node(6);
        bfs.root.right.right = new Node(7);

        System.out.println("Printing in BFS pattern using iterative approach: ");
        bfs.levelOrderTraversal(bfs.root);
        System.out.println();

        System.out.println("Printing in BFS pattern using Recursive Approach: ");
            bfs.levelOrderTraversal_recur(bfs.root);
        System.out.println();

        System.out.println("Printing BFS in line by line pattern: ");
        bfs.levelOrderTraversal_line(bfs.root);

        System.out.println("Height in Recursive Pattern: " + bfs.getHeight(bfs.root));
        System.out.println("Height in Iterative Pattern: " + bfs.getHeight_iterative(bfs.root));


        System.out.println();

        System.out.println("Printing in BFS Reversal pattern using Recursive Approach: ");
        bfs.reverse_level_order_traversal(bfs.root);
        System.out.println();

        System.out.println("Printing in BFS Reversal pattern using Iterative Approach: ");
        bfs.reverse_level_order_traversal_iterative(bfs.root);
        System.out.println();



    }
}
