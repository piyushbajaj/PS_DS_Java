package BinaryTree.GeeksForGeeks;

import java.util.Arrays;

/**
 * Created by piyush.bajaj on 01/09/17.
 */
public class ConstructTree {
    Node root;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    ConstructTree(){
        root = null;
    }

    ConstructTree(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }

    class Index{
        int index = 0;
    }


    //Time Complexity for this solution: O(n*n)
    int index = 0;
    public Node construct_inOrder_preOrder(int[] preOrder, int[] inOrder, int start, int end){
        if(start > end) {
            return null;
        }
        int i = 0;
            for (i = start; i <= end; i++) {
                if (preOrder[index] == inOrder[i]) {
                    break;
                }
            }
            Node key = new Node(preOrder[index]);
            index++;
            key.left = construct_inOrder_preOrder(preOrder, inOrder, start, i - 1);
            key.right = construct_inOrder_preOrder(preOrder, inOrder, i + 1, end);

            return key;

    }

    //Now if i want to construct tree using InOrder and Level Order Traversal
    //index = 0;
    //This gets done with the Time Complexity of O(n*n*n)
    public Node construct_tree_InOrder_LevelOrder(int[] inOrder, int[] levelOrder, int start, int end){
        if(start > end)
            return null;

        if(start == end)
            return new Node(inOrder[start]);

        int index = 0;
        boolean flag = false;

        for(int i = 0; i < levelOrder.length; i++){
            int data = levelOrder[i];
            for(int j = start; j <=end; j++){
                if(data == inOrder[j]){
                    index = j;
                    flag = true;
                    break;
                }
            }
            if(flag == true)
                break;
        }

        Node key = new Node(inOrder[index]);

        key.left = construct_tree_InOrder_LevelOrder(inOrder, levelOrder, start, index-1);
        key.right = construct_tree_InOrder_LevelOrder(inOrder, levelOrder, index+1, end);

        return key;
    }

    public void postOrderTraversal(Node key){
        if(key == null)
            return;

        postOrderTraversal(key.left);
        postOrderTraversal(key.right);
        System.out.print(key.data + " ");
    }

    //Print PostOrder Traversal Using InOrder and PostOrder Traversal
    //Time Complexity for this solution: O(n*n)

    public void post_Order_traversal(int[] inOrder, int[] preOrder, int n){

        //First element in preOrder is always comes to be root, so everytime we need to search this in inOrder array, and
        //get the correct index for the same.
        int root = search_fun(inOrder, preOrder[0]);

        int[] tempInOrder, tempPreOrder;

        //If the left child is not NULL, then first we need to print Left Subtree
        if(root!=0){
            tempPreOrder = Arrays.copyOfRange(preOrder, 1, preOrder.length);
            post_Order_traversal(inOrder, tempPreOrder, root);
        }

        //If the right child is not NULL, then we need to print Right Subtree
        if(root!=n-1){
            tempPreOrder = Arrays.copyOfRange(preOrder, root+1, preOrder.length);
            tempInOrder = Arrays.copyOfRange(inOrder, root+1, inOrder.length);
            post_Order_traversal(tempInOrder, tempPreOrder, n-root-1);

        }

        //Print the root
        System.out.print(preOrder[0] + " ");

    }



    //Search function to search the key in an array, and returns the index
    public int search_fun(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key)
                return i;
        }
        return -1;
    }


    public void inOrder_Traversal(Node key){
        if(key == null)
            return;

        inOrder_Traversal(key.left);
        System.out.print(key.data + " ");
        inOrder_Traversal(key.right);
    }

    /*
    Construct Special Binary Tree from given Inorder traversal

    Input: inorder[] = {5, 10, 40, 30, 28}
    Output: root of following tree
         40
       /   \
      10     30
     /         \
    5          28
     */

    //int index_t = 0;

    //Time Complexity: O(n*n)
    public Node constructSpecialTree(int[] inOrder, int start, int end){
        if(start > end)
            return null;

        else {
            int max = Integer.MIN_VALUE;
            int index_t = 0;
            for (int i = start; i <= end; i++) {
                if (max < inOrder[i]) {
                    max = inOrder[i];
                    index_t = i;
                }
            }

            Node key = new Node(inOrder[index_t]);

            if(start == end)
                return key;

            key.left = constructSpecialTree(inOrder, start, index_t - 1);

            key.right = constructSpecialTree(inOrder, index_t + 1, end);

            return key;
        }
        //return key;
    }


    /*
    Construct a Binary Tree from Postorder and Inorder
     */

    public Node construct_tree_postOrder_inOrder(int[] postOrder, int[] inOrder){
        int n = postOrder.length;

        Index pIndex = new Index();
        pIndex.index = n-1;

        return construct_tree_postOrder_inOrder_util(postOrder, inOrder, 0, n-1, pIndex);
    }

    //int index_PI = 6;
    public Node construct_tree_postOrder_inOrder_util(int[] postOrder, int[] inOrder, int start, int end, Index index_PI){
        if(start > end || index_PI.index < 0)
            return null;

        Node key = new Node(postOrder[index_PI.index]);
        index_PI.index--;

        if(start == end)
            return key;

        int i = 0;
        for(i = start; i <= end; i++){
            if(postOrder[index_PI.index] == inOrder[i])
                break;
        }



        key.right = construct_tree_postOrder_inOrder_util(postOrder, inOrder, i+1, end, index_PI);

        key.left = construct_tree_postOrder_inOrder_util(postOrder, inOrder, start, i-1, index_PI);


        return key;


    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        int[] levelOrder = {1, 2, 3, 4, 5, 6, 7};
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};

        System.out.println("Constructing tree using InOrder and PreOrder Traversal: ");



        ct.root = ct.construct_inOrder_preOrder(preOrder, inOrder, 0, preOrder.length - 1);

        ct.postOrderTraversal(ct.root);

        System.out.println();



        ct.post_Order_traversal(inOrder, preOrder, preOrder.length);
        System.out.println();

        System.out.println("Constructing tree using InOrder and Level Order Traversal: ");

        ct.root = ct.construct_tree_InOrder_LevelOrder(inOrder, levelOrder, 0, levelOrder.length-1);

        ct.inOrder_Traversal(ct.root);

        System.out.println();

        int[] special_In = {5, 10, 40, 30, 28};

        System.out.println("Constructing tree using special InOrder Order Traversal: ");

        ct.root = ct.constructSpecialTree(special_In, 0, special_In.length-1);

        ct.inOrder_Traversal(ct.root);

        System.out.println();

        System.out.println("Constructing tree using InOrder & PostOrder Order Traversal: ");

        ct.root = ct.construct_tree_postOrder_inOrder(postOrder, inOrder);

        ct.inOrder_Traversal(ct.root);

    }
}
