package BinaryTreeExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 14/12/16.
 */
public class MyBinaryTree {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public MyBinaryTree(){
        root = null;
    }

    public MyBinaryTree(int key){
        root = new Node(key);
    }

    public static void main(String[] args) {
        MyBinaryTree BT = new MyBinaryTree(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
    }


    /**
     * Created by piyush.bajaj on 14/12/16.
     */
    public static class PreOrderTraverse {


        public static void preOrderTraversal(Node key){
            if(key!=null){
                System.out.print(key.data + " ");
                preOrderTraversal(key.left);
                preOrderTraversal(key.right);
            }
        }

        public static ArrayList<Integer> preOrderTraversal_Iterative(Node key){
            ArrayList<Integer> res = new ArrayList<>();


            if(key == null)
                return res;
            Stack<Node> s = new Stack<Node>();
            s.push(key);

            while (!s.empty()){
                Node temp = s.pop();
                res.add(temp.data);
                if(temp.right!=null)
                    s.push(temp.right);
                if(temp.left!=null)
                    s.push(temp.left);
            }
            return res;
        }


        public static void main(String[] args) {
            MyBinaryTree BT = new MyBinaryTree(1);
            System.out.println("Root: " + BT.root.data);
            BT.root.left = new Node(2);
            System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
            BT.root.right = new Node(3);
            System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
            BT.root.left.left = new Node(4);
            System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
            BT.root.left.right = new Node(5);
            System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
            BT.root.right.left = new Node(6);
            System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
            BT.root.right.right = new Node(7);
            System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
            System.out.println("Pre-Order Traversal Using Recursive: ");
            preOrderTraversal(BT.root);
            System.out.println("Pre-Order Traversal Using Iterative Approach: " + preOrderTraversal_Iterative(BT.root));

        }
    }

    public static class InOrderTraverse {

       static ArrayList<Integer>  res = new ArrayList<>();
        public static ArrayList<Integer> inOrderTraversal(Node key){
            if(key == null)
                return res;
            else {
                inOrderTraversal(key.left);
                res.add(key.data);
                inOrderTraversal(key.right);
            }
            return res;
        }

        static ArrayList<Integer>  result = new ArrayList<>();
        public static ArrayList<Integer> inOrderTraversal_Iterative(Node key){
            if(key == null)
                return result;
            Stack<Node> s = new Stack<Node>();
            Node temp = key;
            Boolean flag = false;
            while (!flag){
                if(temp!=null){
                    s.push(temp);
                    temp = temp.left;
                }
                else {
                    if(s.empty())
                        flag = true;
                    else {
                        temp = s.pop();
                        result.add(temp.data);
                        temp = temp.right;
                    }
                }
            }
            return result;
        }



        public static void main(String[] args) {
            InOrderTraverse IO = new InOrderTraverse();
            MyBinaryTree BT = new MyBinaryTree(1);
            System.out.println("Root: " + BT.root.data);
            BT.root.left = new Node(2);
            System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
            BT.root.right = new Node(3);
            System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
            BT.root.left.left = new Node(4);
            System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
            BT.root.left.right = new Node(5);
            System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
            BT.root.right.left = new Node(6);
            System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
            BT.root.right.right = new Node(7);
            System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
            System.out.println("In-Order Traversal Using Recursive: " + IO.inOrderTraversal(BT.root));

            System.out.println("In-Order Traversal Using Iteration: " + IO.inOrderTraversal_Iterative(BT.root));
            //inOrderTraversal_Iterative
            //System.out.println("Pre-Order Traversal Using Iterative Approach: " + preOrderTraversal_Iterative(BT.root));

        }

    }

    public static class PostOrderTraverse {

        static ArrayList<Integer> res = new ArrayList<>();
        public static ArrayList<Integer> postOrderTraversal(Node key){
            if(key==null)
                return res;
            else {
                postOrderTraversal(key.left);
                postOrderTraversal(key.right);
                res.add(key.data);
            }
            return res;
        }

        static ArrayList<Integer> result = new ArrayList<>();
        public static ArrayList<Integer> postOrderTraversal_Iterative(Node key){
            Stack<Node> s = new Stack<>();
            Node prev = null;

            s.push(key);
            while (!s.empty()){
                Node current = s.peek();
                if(prev==null || prev.left == current || prev.right == current){
                    if(current.left!=null)
                        s.push(current.left);
                    else if(current.right!=null)
                        s.push(current.right);
                    else{
                        s.pop();
                        result.add(current.data);
                    }
                }
                else if(current.left == prev){
                    if(current.right!=null)
                        s.push(current.right);
                    else {
                        s.pop();
                        result.add(current.data);
                    }
                }
                else if(current.right == prev){
                    s.pop();
                    result.add(current.data);
                }
                prev = current;
            }
            return result;
        }





        public static void main(String[] args) {
            PostOrderTraverse PO = new PostOrderTraverse();
            MyBinaryTree BT = new MyBinaryTree(1);
            System.out.println("Root: " + BT.root.data);
            BT.root.left = new Node(2);
            System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
            BT.root.right = new Node(3);
            System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
            BT.root.left.left = new Node(4);
            System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
            BT.root.left.right = new Node(5);
            System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
            BT.root.right.left = new Node(6);
            System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
            BT.root.right.right = new Node(7);
            System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
            System.out.println("Post-Order Traversal Using Recursive: " + PO.postOrderTraversal(BT.root));

            System.out.println("Post-Order Traversal Using Iteration: " + PO.postOrderTraversal_Iterative(BT.root));
        }

    }



    public static class LevelOrderTraversal {
        public ArrayList<ArrayList<Integer>> levelOrderTraverse(Node key){
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> current = new ArrayList<>();

            if(key==null)
                return res;

            Queue<Node> queue = new LinkedList<Node>();
            queue.add(key);
            queue.add(null);

            while (!queue.isEmpty()){
                Node tmp = queue.poll();
                if(tmp!=null){
                    current.add(tmp.data);
                    if(tmp.left!=null)
                        queue.add(tmp.left);
                    if(tmp.right!=null)
                        queue.add(tmp.right);
                }
                else {
                    ArrayList<Integer> c_curr = new ArrayList<Integer>(current);
                    res.add(c_curr);
                    current.clear();
                    if(!queue.isEmpty())
                        queue.add(null);
                }
            }
            return res;
        }

        public static void main(String[] args) {
            LevelOrderTraversal PO = new LevelOrderTraversal();
            MyBinaryTree BT = new MyBinaryTree(1);
            System.out.println("Root: " + BT.root.data);
            BT.root.left = new Node(2);
            System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
            BT.root.right = new Node(3);
            System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
            BT.root.left.left = new Node(4);
            System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
            BT.root.left.right = new Node(5);
            System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
            BT.root.right.left = new Node(6);
            System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
            BT.root.right.right = new Node(7);
            System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
            System.out.println("Level Order Traversal Using Iteration: " + PO.levelOrderTraverse(BT.root));

        }
    }

}
