package BinaryTree;

/**
 * Created by piyush.bajaj on 24/07/17.
 */
public class sumOfLeftLeaf {
    Node root;

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    sumOfLeftLeaf(int data){
        if(root == null)
            root = new Node(data);
    }

    static int sum = 0;
    public void sumOfLeftLeaf_recursive(Node key){
        if(key == null)
            return;

        if(key.left == null && key.right == null){
            sum += key.data;
        }

        sumOfLeftLeaf_recursive(key.left);
        if(key.right!=null) {
            if (key.right.left != null)
                sumOfLeftLeaf_recursive(key.right);
        }
    }


    public static void main(String[] args) {
        sumOfLeftLeaf BT = new sumOfLeftLeaf(1);
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

        BT.root.left.left.right = new Node(8);
        BT.root.left.left.right.left = new Node(9);

        BT.sumOfLeftLeaf_recursive(BT.root);
        System.out.println(sum);
    }

}
