package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 29/07/17.
 */
public class removeHalfNodes {
    Node root;

    static class Node{
        Node left, right;
        int data;
        int sum;

        Node(int data){
            this.data = data;
            left = right = null;
            this.sum = this.data;
        }
    }

    removeHalfNodes(int data){
        if(root == null)
            root = new Node(data);
    }

    public Node removeHalf(Node key){
        if(key == null)
            return null;

        key.left = removeHalf(key.left);
        key.right = removeHalf(key.right);

        if(key.left==null && key.right!=null){
            key = key.right;
        }
        else if(key.left!=null && key.right==null){
            key = key.left;
        }
        return key;

    }

    public void inOrderTraversal(Node key){
        if(key ==null)
            return;

        inOrderTraversal(key.left);

        System.out.print(key.data + " ");

        inOrderTraversal(key.right);
    }

    public static void main(String[] args) {
        removeHalfNodes BT = new removeHalfNodes(50);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(30);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(70);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(20);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(40);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(60);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
//        BT.root.right.right = new Node(80);
//        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

//        BT.root.left.left.left = new Node(10);
//        BT.root.left.left.right = new Node(25);
        BT.inOrderTraversal(BT.removeHalf(BT.root));

    }
}
