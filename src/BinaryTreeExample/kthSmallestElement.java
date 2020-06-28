package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 25/12/16.
 */
public class kthSmallestElement {


    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public kthSmallestElement(){
        root = null;
    }

    public kthSmallestElement(int key){
        root = new Node(key);
    }

    //This can be solved using InOrder Traversal Technique

    public static int counter =0;
    public Node kthSmallest(Node key, int k, int count){
        counter = count;
        if(key == null)
            return null;

        Node left = kthSmallest(key.left, k, counter);

        if(left!=null)
            return left;

        if(++counter == k)
            return key;

        return kthSmallest(key.right, k, counter);
    }

    public static int big_counter =0;
    public Node kthLargest(Node key, int k, int count){
        big_counter = count;
        if(key == null)
            return null;

        Node right = kthSmallest(key.right, k, big_counter);

        if(right!=null)
            return right;

        if(++big_counter == k)
            return key;

        return kthSmallest(key.left, k, big_counter);
    }



    public void inOrderTraversal(Node key){
        if(key == null)
            return;

        inOrderTraversal(key.left);

        System.out.print(key.data + " ");

        inOrderTraversal(key.right);
    }

    public static void main(String[] args) {
        kthSmallestElement BT = new kthSmallestElement(100);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(50);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(150);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(40);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(60);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(120);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(180);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);


        BT.inOrderTraversal(BT.root);

        System.out.println();
        counter = 2;
        System.out.println("So the " + counter + " smallest element from the start is: " + BT.kthSmallest(BT.root, counter, 0).data);


        big_counter = 2;
        System.out.println("So the " + big_counter + " largest element from the start is: " + BT.kthLargest(BT.root, big_counter, 0).data);

    }
}
