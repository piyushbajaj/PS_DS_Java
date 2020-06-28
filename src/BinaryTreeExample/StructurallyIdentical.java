package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 18/12/16.
 */
public class StructurallyIdentical {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public StructurallyIdentical(){
        root = null;
    }

    public StructurallyIdentical(int key){
        root = new Node(key);
    }

    public static boolean isStructureIdentical(Node Nd1, Node Nd2){
        if(Nd1 == null && Nd2 == null)
            return true;
        if(Nd1 == null || Nd2 == null)
            return false;

        return (isStructureIdentical(Nd1.left, Nd2.left) && isStructureIdentical(Nd1.right, Nd2.right));
    }

    public static void main(String[] args) {
        StructurallyIdentical BT1 = new StructurallyIdentical(1);
        StructurallyIdentical BT2 = new StructurallyIdentical(11);
        System.out.println("Root: " + BT1.root.data);
        BT1.root.left = new Node(2);
        System.out.println("Root ("+ BT1.root.data +") -> Left: " + BT1.root.left.data);
        BT1.root.left.left = new Node(4);
        System.out.println("Root ("+ BT1.root.data +") -> Left ("+ BT1.root.left.data + ") -> Left: " + BT1.root.left.left.data);
        BT1.root.left.right = new Node(5);
        System.out.println("Root ("+ BT1.root.data +") -> Left ("+ BT1.root.left.data + ") -> Right: " + BT1.root.left.right.data);


        System.out.println("Root: " + BT2.root.data);
        BT2.root.left = new Node(12);
        System.out.println("Root ("+ BT2.root.data +") -> Left: " + BT2.root.left.data);
        BT2.root.left.left = new Node(14);
        System.out.println("Root ("+ BT2.root.data +") -> Left ("+ BT2.root.left.data + ") -> Left: " + BT2.root.left.left.data);
        BT2.root.left.right = new Node(15);
        System.out.println("Root ("+ BT2.root.data +") -> Left ("+ BT2.root.left.data + ") -> Right: " + BT2.root.left.right.data);
        BT2.root.left.right.left = new Node(15);

        System.out.println("Is both the Binary tree structure is same: " + isStructureIdentical(BT1.root, BT2.root));

    }
}

