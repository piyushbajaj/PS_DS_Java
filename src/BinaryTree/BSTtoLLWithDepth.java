package BinaryTree;

import java.util.LinkedList;

/**
 * Created by piyush.bajaj on 05/02/17.
 */
public class BSTtoLLWithDepth {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public BSTtoLLWithDepth(){
        root = null;
    }

    public BSTtoLLWithDepth(int key){
        root = new Node(key);
    }

    //height
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


    //Like PreOrder Traversal
    public void treeToListArray(LinkedList[] listArr, Node key, int level){
        if(key==null)
            return;

        if(listArr[level]== null){
            LinkedList<Integer> tempList = new LinkedList<>();
            tempList.add(key.data);
            listArr[level] = tempList;
            level++;
        }
        else {
            listArr[level].add(key.data);
            level++;
        }
        treeToListArray(listArr, key.left, level);
        treeToListArray(listArr, key.right, level);
    }

    public void printList(LinkedList[] listArr, int h){
        for(int i = 0; i < h; i++){
            System.out.println(listArr[i]);
        }


    }

    public static void main(String[] args) {
        BSTtoLLWithDepth BT = new BSTtoLLWithDepth();
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

        System.out.println("Root->left->left of a binary tree is: " + BT.root.left.left.data);

        System.out.println("Root->right->right of a binary tree is: " + BT.root.right.right.data);

        System.out.println("Height of a binary tree is: " + BT.height(BT.root));

        //System.out.println(BT.root.data);

        int h = BT.height(BT.root);
        LinkedList[] listArr = new LinkedList[h];

        BT.treeToListArray(listArr, BT.root, 0);

        BT.printList(listArr, h);

        //System.out.println()


    }

}
