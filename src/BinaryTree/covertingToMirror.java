package BinaryTree;

/**
 * Created by piyush.bajaj on 19/12/16.
 */
public class covertingToMirror {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public covertingToMirror(){
        root = null;
    }

    public covertingToMirror(int key){
        root = new Node(key);
    }

    public void makeMirrorNodes(Node key){
        Node temp = null;
        if(key == null)
            return;
        else {
            makeMirrorNodes(key.left);
            makeMirrorNodes(key.right);
            temp = key.left;
            key.left = key.right;
            key.right = temp;
        }
        return;
    }


    public static void main(String[] args) {
        covertingToMirror BT = new covertingToMirror(1);
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

        System.out.println("After converting the nodes to its mirror: ");
        BT.makeMirrorNodes(BT.root);
        System.out.println("Root: " + BT.root.data);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
    }
}
