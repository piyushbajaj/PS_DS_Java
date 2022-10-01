package BinaryTree;

/**
 * Created by piyush.bajaj on 27/07/17.
 */
public class mirrorTree {
    Node root;

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    mirrorTree(int data){
        if(root == null)
            root = new Node(data);
    }

    Node temp = null;
    public void convertMirrorTree(Node key){
        if(key == null)
            return;

        convertMirrorTree(key.left);
        convertMirrorTree(key.right);

        if(key.left!=null || key.right!=null){
            temp = key.left;
            key.left = key.right;
            key.right = temp;
        }
    }

    public static void main(String[] args) {
        mirrorTree BT = new mirrorTree(1);
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
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root (" + BT.root.data + ") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println("After converting to Mirror: ");

        BT.convertMirrorTree(BT.root);

        System.out.println("Root: " + BT.root.data);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        System.out.println("Root (" + BT.root.data + ") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

    }
}
