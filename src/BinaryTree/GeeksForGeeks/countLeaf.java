package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 16/09/17.
 */
public class countLeaf {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public countLeaf(){
        root = null;
    }

    public countLeaf(int key){
        root = new Node(key);
    }

    //Time Complexity: O(n)
    int count = 0;
    public int countLeafNodes(Node key){
        if(key == null)
            return 0;

        countLeafNodes(key.left);
        countLeafNodes(key.right);

        if(key.left==null && key.right == null)
            count++;

        return count;
    }

    public static void main(String[] args) {
        countLeaf BT = new countLeaf(1);

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

        System.out.println(BT.countLeafNodes(BT.root));
    }
}
