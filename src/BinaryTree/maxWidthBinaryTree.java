package BinaryTree;

/**
 * Created by piyush.bajaj on 18/12/16.
 */
public class maxWidthBinaryTree {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public maxWidthBinaryTree(){
        root = null;
    }

    public maxWidthBinaryTree(int key){
        root = new Node(key);
    }

    public int heightOfBT(Node key){
        if(key == null)
            return 0;
        int leftcount = heightOfBT(key.left);
        int rightcount= heightOfBT(key.right);

        return (leftcount>rightcount)? leftcount+1: rightcount+1;

    }

    public int width(Node key){
        int max =0;
        int height = heightOfBT(key);
        for(int i =0; i < height; i++){
            int temp = width(key, i);
            if(temp > max)
                max = temp;
        }
        return max;
    }

    //Returns the number of nodes at a given level
    public int width(Node key, int depth){
        if(key==null)
            return 0;
        else {
            if(depth == 0)
                return 1;
            else
                return width(key.left, depth-1) + width(key.right, depth-1);
        }
    }

    public static void main(String[] args) {
        maxWidthBinaryTree BT = new maxWidthBinaryTree(1);
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
        BT.root.right.right.right = new Node(8);

        System.out.println("Maximum width of a tree is: " + BT.width(BT.root));
    }
}
