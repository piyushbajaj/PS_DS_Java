package BinaryTree;

/**
 * Created by piyush.bajaj on 31/12/16.
 Algorithm for removing outside range is:
 1. recursive function removeOutsideRange(key, min, max){
    if(key==null)
        return;
    key.left = removeOutsideRange(key.left, min, max);
    key.right = removeOutsideRange(key.right, min, max);

    if(key.data < min)
        return key.right;
    if(key.data > max)
        return key.left;

    return key;
    }
 */
public class removeOutsideRange {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public removeOutsideRange(){
        root = null;
    }

    public removeOutsideRange(int key){
        root = new Node(key);
    }

    //This is done using Post-Order Traversal
    public Node removeNodeOutsideRange(Node key, int min, int max){
        //Base case
        if(key == null)
            return null;

        key.left = removeNodeOutsideRange(key.left, min, max);
        key.right = removeNodeOutsideRange(key.right, min, max);


        if(key.data < min){
            return key.right;
        }
        else if(key.data > max){
            return key.left;
        }
        else
            return key;


    }

//    public Node removeOutsideRange_better(Node key, int min, int max) {
//        if(key == null)
//            return null;
//        if(key.data >= min && key.data <= max) {
//            key.left = removeOutsideRange_better(key.left, min, max);
//            key.right = removeOutsideRange_better(key.right, min, max);
//            return key;
//        }
//        else if(key.data <= min) {
//            return removeOutsideRange_better(key.right, min, max);
//        }
//        else {
//            return removeOutsideRange_better(key.left, min, max);
//        }
//    }

    public Node removeOutsideRange_better(Node root , int min , int max)
    {
        if (root == null)
            return null;

        root.left = removeOutsideRange_better(root.left, min, max);
        root.right = removeOutsideRange_better(root.right , min , max);

        if(root.data < min)
        {
            Node rChild = root.right;
            root=null;
            return rChild;
        }

        if(root.data > max)
        {
            Node lChild = root.left;
            root=null;
            return lChild;
        }

        return  root;

    }


    public void inOrderTraversal(Node key){
        if(key ==null)
            return;

        inOrderTraversal(key.left);

        System.out.print(key.data + " ");

        inOrderTraversal(key.right);
    }




    public Node removeOutRange_prac(Node key, int min, int max){
        if(key == null)
            return null;

        key.left = removeOutRange_prac(key.left, min, max);
        key.right = removeOutRange_prac(key.right, min, max);

        if(key.data < min)
            return key.right;
        else if(key.data > max)
            return key.left;

        return key;

    }



    public static void main(String[] args) {
        removeOutsideRange BT = new removeOutsideRange(50);
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

        BT.inOrderTraversal(BT.root);

        System.out.println();

        //BT.removeOutsideRange_better(BT.root, 5, 45);

        System.out.println("After removing nodes: ");

        //BT.inOrderTraversal(BT.root);

        BT.inOrderTraversal(BT.removeOutRange_prac(BT.root, 20, 60));

    }
}
