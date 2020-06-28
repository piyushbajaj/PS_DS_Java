package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 21/12/16.
 */
public class printAncestors {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public printAncestors(){
        root = null;
    }

    public printAncestors(int key){
        root = new Node(key);
    }

    public static boolean printAllAncestors(Node key, Node Nd){
        if(key == null)
            return false;
        if(key.left == Nd || key.right ==Nd || printAllAncestors(key.left, Nd) || printAllAncestors(key.right, Nd)){
            System.out.println(key.data);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        printAncestors BT1 = new printAncestors(1);
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

        printAllAncestors(BT1.root, BT1.root.left.left);

    }

}
