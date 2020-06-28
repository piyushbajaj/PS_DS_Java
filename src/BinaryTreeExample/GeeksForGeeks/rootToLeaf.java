package BinaryTreeExample.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 13/09/17.
 */
public class rootToLeaf {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public rootToLeaf(){
        root = null;
    }

    public rootToLeaf(int key){
        root = new Node(key);
    }


    //Using the approach from Pre_order
    public boolean sum_rootToLeaf(int sum, Node key){
        if(key == null) {
            if(sum == 0)
                return true;
            else
                return false;
        }
        else {
            boolean flag = false;
            int value = sum - key.data;

            if (key.left == null && key.right == null && value == 0)
                return true;

            if (key.left != null)
                flag = flag || sum_rootToLeaf(value, key.left);

            if (key.right != null)
                flag = flag || sum_rootToLeaf(value, key.right);

            return flag;

        }

    }

    public static void main(String[] args) {
        rootToLeaf BT = new rootToLeaf(1);

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

        System.out.println(BT.sum_rootToLeaf(11, BT.root));



    }
}
