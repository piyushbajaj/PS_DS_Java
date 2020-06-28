package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 06/02/17.
 * There are 2 functions which are needed to accomplish this task:
 * 1. AreIdentical: Will check if both the BT are matching or not
 * 2. IsSubtree: Will check if its a Subtree or not
 */
public class BinaryTreeSubTree {
    Node root;

    public static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public BinaryTreeSubTree(){
        root = null;
    }

    public BinaryTreeSubTree(int key){
        root = new Node(key);
    }

    public void insert_BST(Node key, int data){
        if(root==null) {
            root = new Node(data);
            return;
        }
        while (key!=null) {
            if (data < key.data) {
                if (key.left != null) {
                    key = key.left;
                }
                else {
                    key.left = new Node(data);
                    return;
                }
            }
            else {
                if (key.right != null) {
                    key = key.right;
                }
                else {
                    key.right = new Node(data);
                    return;
                }
            }
        }
    }

    public void inOrderTraversal(Node key){
        if(key == null)
            return;

        inOrderTraversal(key.left);
        System.out.print(key.data + " ");
        inOrderTraversal(key.right);
    }


    public boolean areIdentical(Node key1, Node key2){
        if(key1 == null && key2 == null)
            return true;

        if(key1 == null || key2 == null)
            return false;

        return (key1.data == key2.data
                && areIdentical(key1.left, key2.left)
                && areIdentical(key1.right, key2.right));
    }


    /*
    The only drawback here of this function is that it take O(n*m) time,
    where: n is the nodes in BT
    m is the nodes in ST
     */
    public boolean isSubTree(Node BT, Node ST){
        if(ST==null)
            return true;

        if(BT==null)
            return false;

        if(areIdentical(BT, ST))
            return true;

        return (isSubTree(BT.left, ST)) || (isSubTree(BT.right, ST));
    }

    public void fillUpInorder(String[] str, Node key){
        if(key == null)
            return;

        fillUpInorder(str, key.left);
        str[0] += key.data;
        fillUpInorder(str, key.right);
    }

    public void fillUpPreOrder(String[] str, Node key){
        if(key == null)
            return;

        str[0] += key.data;
        fillUpPreOrder(str, key.left);
        fillUpPreOrder(str, key.right);
    }

    //This is done using the concept of Inorder and PreOrder Traversal
    public boolean improvedSubTree(Node BT, Node ST){

        String[] inorderBT = {""};
        String[] inorderST = {""};

        fillUpInorder(inorderBT, BT);
        fillUpInorder(inorderST, ST);

        if(inorderBT[0].contains(inorderST[0])){
            String preOrderBT = "";
            String preOrderST = "";

//            fillUpPreOrder(preOrderBT, BT);
//            fillUpPreOrder(preOrderST, ST);

            return preOrderBT.contains(preOrderST);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Complete Binary Tree: ");
        BinaryTreeSubTree BT = new BinaryTreeSubTree(26);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(10);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: "
                + BT.root.left.left.data);
        BT.root.left.right = new Node(6);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: "
                + BT.root.left.right.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: "
                + BT.root.right.right.data);
        BT.root.left.left.right = new Node(30);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: ("
                + BT.root.left.left.data +
                ") -> Right: " + BT.root.left.left.right.data);


        System.out.println();
        System.out.println("SubTree: ");
        BinaryTreeSubTree ST = new BinaryTreeSubTree(10);
        System.out.println("Root: " + ST.root.data);
        ST.root.left = new Node(4);
        System.out.println("Root ("+ ST.root.data +") -> Left: " + ST.root.left.data);
        ST.root.right = new Node(6);
        System.out.println("Root ("+ ST.root.data +") -> Right: " + ST.root.right.data);
        //ST.root.left.right = new Node(30);
        //System.out.println("Root (" + ST.root.data + ") -> Left (" + ST.root.left.data + ") -> Right: "
                //+ ST.root.left.right.data);

        //BT.inOrderTraversal(BT.root);

        System.out.println(BT.isSubTree(BT.root, ST.root));

        System.out.println(BT.improvedSubTree(BT.root, ST.root));
    }

}
