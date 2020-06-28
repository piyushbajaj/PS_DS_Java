package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 18/12/16.
 */
public class diameterOfTree {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public diameterOfTree(){
        root = null;
    }

    public diameterOfTree(int key){
        root = new Node(key);
    }

    public int diameterOfTree(Node key){
        int left=0, right=0, diameter =0;
        if(key == null)
            return 0;
        left = diameterOfTree(key.left);
        right = diameterOfTree(key.right);

        if(left + right > diameter)
            diameter = left + right;

        return Math.max(left, right) + 1;

    }

    public static void main(String[] args) {
        diameterOfTree BT = new diameterOfTree(1);
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
        BT.root.right.right.left = new Node(9);

        System.out.println("Diameter of binary tree is: " + BT.diameterOfTree(BT.root));
    }
}
