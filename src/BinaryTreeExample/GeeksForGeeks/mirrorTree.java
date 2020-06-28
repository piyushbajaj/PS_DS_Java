package BinaryTreeExample.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 25/09/17.
 */
public class mirrorTree {
    Node root;

    static class Node{
        Node left, right;
        int data;
        boolean isThreaded;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    mirrorTree(){
        root = null;
    }

    mirrorTree(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }

    public void mirrorTree(Node key){
        if(key == null)
            return;

        mirrorTree(key.left);
        mirrorTree(key.right);

        if(key.left!=null || key.right!=null){
            Node temp = key.left;
            key.left = key.right;
            key.right = temp;
        }

        return;
    }


    //InOrder Traversal
    public void inOrderTraversal_Recur(Node key){
        if(key == null)
            return;

        inOrderTraversal_Recur(key.left);
        System.out.print(key.data + " ");
        inOrderTraversal_Recur(key.right);
    }

    public static void main(String[] args) {
        mirrorTree BT = new mirrorTree();

        BT.root = new Node(4);

        BT.root.left = new Node(2);
        BT.root.left.left = new Node(1);
        BT.root.left.right = new Node(3);
        BT.root.right = new Node(6);
        BT.root.right.left = new Node(5);
        BT.root.right.right = new Node(7);

        System.out.print("Binary Tree is: ");
        BT.inOrderTraversal_Recur(BT.root);

        System.out.println();

        System.out.print("Mirror Tree is: ");
        BT.mirrorTree(BT.root);
        BT.inOrderTraversal_Recur(BT.root);
    }
}
