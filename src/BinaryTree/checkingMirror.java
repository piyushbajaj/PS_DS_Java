package BinaryTree;

/**
 * Created by piyush.bajaj on 19/12/16.
 */
public class checkingMirror {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public checkingMirror(){
        root = null;
    }

    public checkingMirror(int key){
        root = new Node(key);
    }

    public static boolean isBTMirror(Node key1, Node key2){
        if(key1 == null && key2 == null)
            return true;
        if(key1 == null || key2 == null)
            return false;
        if(key1.data != key2.data)
            return false;
        return (isBTMirror(key1.left, key2.right) && isBTMirror(key1.right, key2.left));
    }

    public static void main(String[] args) {
        checkingMirror BT1 = new checkingMirror(1);
        System.out.println("Root: " + BT1.root.data);
        BT1.root.left = new Node(2);
        System.out.println("Root ("+ BT1.root.data +") -> Left: " + BT1.root.left.data);
        BT1.root.right = new Node(3);
        System.out.println("Root ("+ BT1.root.data +") -> Right: " + BT1.root.right.data);
        BT1.root.left.left = new Node(4);
        System.out.println("Root ("+ BT1.root.data +") -> Left ("+ BT1.root.left.data + ") -> Left: " + BT1.root.left.left.data);
        BT1.root.left.right = new Node(5);
        System.out.println("Root ("+ BT1.root.data +") -> Left ("+ BT1.root.left.data + ") -> Right: " + BT1.root.left.right.data);
        BT1.root.right.left = new Node(6);
        System.out.println("Root ("+ BT1.root.data +") -> Right ("+ BT1.root.right.data + ")-> Left: " + BT1.root.right.left.data);
        BT1.root.right.right = new Node(7);
        System.out.println("Root ("+ BT1.root.data +") -> Right ("+ BT1.root.right.data + ") -> Right: " + BT1.root.right.right.data);

        checkingMirror BT2 = new checkingMirror(1);
        System.out.println("Root: " + BT2.root.data);
        BT2.root.left = new Node(3);
        System.out.println("Root ("+ BT2.root.data +") -> Left: " + BT2.root.left.data);
        BT2.root.right = new Node(2);
        System.out.println("Root ("+ BT2.root.data +") -> Right: " + BT2.root.right.data);
        BT2.root.left.left = new Node(7);
        System.out.println("Root ("+ BT2.root.data +") -> Left ("+ BT2.root.left.data + ") -> Left: " + BT2.root.left.left.data);
        BT2.root.left.right = new Node(6);
        System.out.println("Root ("+ BT2.root.data +") -> Left ("+ BT2.root.left.data + ") -> Right: " + BT2.root.left.right.data);
        BT2.root.right.left = new Node(5);
        System.out.println("Root ("+ BT2.root.data +") -> Right ("+ BT2.root.right.data + ")-> Left: " + BT2.root.right.left.data);
        BT2.root.right.right = new Node(4);
        System.out.println("Root ("+ BT2.root.data +") -> Right ("+ BT2.root.right.data + ") -> Right: " + BT2.root.right.right.data);

        System.out.println("Check if the BT's are mirror of each other: " + isBTMirror(BT1.root, BT2.root));

    }
}
