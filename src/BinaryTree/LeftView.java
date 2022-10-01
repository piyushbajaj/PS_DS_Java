package BinaryTree;

/**
 * Created by piyush.bajaj on 24/07/17.
 */
public class LeftView {
    Node root;

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    LeftView(int data){
        if(root == null)
            root = new Node(data);
    }

    int maxSize = -1;
    public void leftView_recursively(Node key, int currLevel){
        if(key == null)
            return;

        if(currLevel > maxSize){
            maxSize = currLevel;
            System.out.print(key.data + " ");
        }
        leftView_recursively(key.left, currLevel + 1);
        leftView_recursively(key.right, currLevel + 1);
    }

    public static void main(String[] args) {
        LeftView BT = new LeftView(1);
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

        BT.root.left.left.left = new Node(8);
        BT.root.left.left.left.right = new Node(10);

        BT.leftView_recursively(BT.root, 0);
    }

}
