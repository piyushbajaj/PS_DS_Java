package BinaryTreeExample.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 16/09/17.
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

    static class Height{
        int height = 0;
    }

    /*
    Algorithm for taking out Diameter of a tree, so the max of the following three:
    1. Calculate the diameter of left subtree
    2. Calculate the diameter of right subtree
    3. Left Height + Right Height + 1
     */

    public int getHeight(Node key){
        if(key == null)
            return 0;

        int lCount = getHeight(key.left);
        int rCount = getHeight(key.right);

        return lCount > rCount? lCount+1: rCount+1;
    }


    //Time Complexity: O(n*n)
    public int diameter(Node key){
        if(key == null)
            return 0;

        int lHeight = getHeight(key.left);
        int rHeight = getHeight(key.right);

        int lDiameter = diameter(key.left);
        int rDiameter = diameter(key.right);

        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
    }

    //Time Complexity: O(n)
    public int diameter_improved(Node key , Height height){
        if(key == null)
        {
            height.height = 0;
            return 0;
        }

        Height lHeight = new Height();
        Height rHeight = new Height();

        int lDiameter = diameter_improved(key.left, lHeight);
        int rDiameter = diameter_improved(key.right, rHeight);

        if(lHeight.height > rHeight.height)
            height.height = lHeight.height + 1;
        else
            height.height = rHeight.height + 1;

        return Math.max(lHeight.height + rHeight.height + 1, Math.max(lDiameter, rDiameter));

    }

    public static void main(String[] args) {
        diameterOfTree BT = new diameterOfTree(1);

        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        BT.root.left.left.left = new Node(8);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        BT.root.left.right.left = new Node(9);
        BT.root.left.right.left.left = new Node(10);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        //BT.root.right.right.right = new Node(8);
        //BT.root.right.right.right.right = new Node(9);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.root = new Node(1);
        BT.root.left = new Node(2);
        BT.root.right = new Node(3);
        BT.root.left.left = new Node(4);
        BT.root.left.right = new Node(5);


        System.out.println(BT.diameter(BT.root));

        System.out.println("Much improved complexity: " +  BT.diameter_improved(BT.root, new Height()));
    }

}
