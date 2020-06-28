package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 28/07/17.
 */
public class removeAllNodes {
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

    removeAllNodes(int data){
        if(root == null)
            root = new Node(data);
    }

    public Node getLeft(Node key){
        if(key == null || key.left == null)
            return null;
        key.left.sum = key.left.data + key.sum;
        return key.left;
    }

    public Node getRight(Node key){
        if(key == null || key.right == null)
            return null;
        key.right.sum = key.right.data + key.sum;
        return key.right;
    }

    public Node removeNodesInPath(Node key, int maxSum){
        if(key == null)
            return null;

        key.left = removeNodesInPath(getLeft(key), maxSum);
        key.right = removeNodesInPath(getRight(key), maxSum);

        if(key.left==null && key.right == null){
            if(key.sum < maxSum)
                return null;
            else
                return key;
        }
        else
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
        removeAllNodes BT = new removeAllNodes(50);
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
        BT.root.right.right = new Node(80);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.inOrderTraversal(BT.removeNodesInPath(BT.root, 0));


    }
}
