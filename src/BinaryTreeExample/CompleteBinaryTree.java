package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 24/07/17.
 */
public class CompleteBinaryTree {
    Node root;

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    CompleteBinaryTree(int data){
        if(root == null)
            root = new Node(data);
    }

    //boolean flag = false;
    public boolean check_complete_BinaryTree(Node key){
        if(key == null)
            return true;

        if(key.left == null && key.right == null)
            return true;
        else if((key.left != null && key.right == null) || (key.left == null && key.right != null))
            return false;

        return check_complete_BinaryTree(key.left) && check_complete_BinaryTree(key.right);
    }


    /*
    Write a program to check if a given binary tree is complete tree or not.

A binary tree is a complete binary tree if all levels of the tree starting from root node level are filled.
Only the last level of the tree is allowed to have an incompletely filled state.
Also for tree to be a complete binary tree, all nodes should be placed as left as possible.
For example, both tree shown below are complete trees.
Though the tree on the left-hand side has one of the levels incompletely filled, because it is the last level this tree fulfills conditions for a complete tree.
     */

    public int height(Node key){
        if(key == null)
            return 0;

        int leftcount = height(key.left);
        int rightcount = height(key.right);

        if(leftcount > rightcount)
            return leftcount+1;
        else
            return rightcount+1;
    }



    public boolean isBTComplete(Node key){
        if(key == null)
            return true;

        int n = height(key);

        return isBTComplete_util(key, 0, n-1);


    }


    public boolean isBTComplete_util(Node key, int level, int maxLevel){
        if(key == null)
            return true;

        if(level < maxLevel) {
            if (level < maxLevel - 1 && (key.left == null || key.right == null))
                return false;

            if ((level == maxLevel - 1) && (key.left == null && key.right != null))
                return false;

            return isBTComplete_util(key.left, level + 1, maxLevel) && isBTComplete_util(key.right, level + 1, maxLevel);
        }
        else
            return true;

    }

    public static void main(String[] args) {
        CompleteBinaryTree BT = new CompleteBinaryTree(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        //BT.root.right.left = new Node(6);
        //System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.root.left.left.left = new Node(8);

        System.out.println(BT.check_complete_BinaryTree(BT.root));

        System.out.println(BT.isBTComplete(BT.root));
    }
}


