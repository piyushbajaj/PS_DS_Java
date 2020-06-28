package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 04/12/16.
 */
public class BinaryTreeBalancedClass {
    Node root;

    static class Node{
        Node left, right, root;
        int data;
        Node(int d){
            data = d;
            left = right = root = null;
        }
    }

    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

//    int difference(int N1, int N2){
//
//    }

    public void balancedTreeTwoNodes(Node Nd1, Node Nd2){
        int diff = height(Nd1) - height(Nd2);
        if(Math.abs(diff) == 1 || diff == 0) {
            System.out.println("Binary tree is balanced for the given Nodes");
            return;
        }
        else {
            System.out.println("Binary tree is Not balanced for the given Nodes");
            return;
        }
    }

    //This takes O(n*n) time as height function iterates n^2 times
    public boolean isbalancedTree(Node Nd){
        if(Nd == null)
            return true;
        int diff = height(Nd.left) - height(Nd.right);
        if(Math.abs(diff) > 1)
            return false;
        else
            return isbalancedTree(Nd.left) && isbalancedTree(Nd.right);
    }

    public int checkHeight(Node key){
        if(key==null)
            return 0;

        int left = checkHeight(key.left);
        if(left == -1)
            return -1;

        int right = checkHeight(key.right);
        if(right == -1)
            return -1;

        int diff = left - right;
        if(Math.abs(diff) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }

    public boolean isbalancedTree_improved(Node Nd){
        if(checkHeight(Nd) == -1)
            return false;
        else
            return true;
    }



    public static void main(String[] args) {
        BinaryTreeBalancedClass BT = new BinaryTreeBalancedClass();
        BT.root = new Node(3);
        System.out.println("Root of a binary tree is: " + BT.root.data);
        BT.root.left = new Node(2);

        BT.root.right = new Node(4);

        System.out.println("Root->left of a binary tree is: " + BT.root.left.data);

        System.out.println("Root->right of a binary tree is: " + BT.root.right.data);

        System.out.println("Root->left->left of a binary tree is: " + BT.root.left.left);

        System.out.println("Root->right->right of a binary tree is: " + BT.root.left.right);

        BT.root.left.left = new Node(1);

        BT.root.right.right = new Node(5);

        BT.root.right.right.right = new Node(6);

        System.out.println("Root->left->left of a binary tree is: " + BT.root.left.left.data);

        System.out.println("Root->right->right of a binary tree is: " + BT.root.right.right.data);

        BT.balancedTreeTwoNodes(BT.root, BT.root.left.left);

        System.out.println(BT.isbalancedTree(BT.root));

        System.out.println("After improving time space");

        System.out.println(BT.isbalancedTree_improved(BT.root));

    }
}
