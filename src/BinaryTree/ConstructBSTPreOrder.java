package BinaryTree;

/**
 * Created by piyush.bajaj on 01/01/17.
 */
public class ConstructBSTPreOrder {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public ConstructBSTPreOrder(){
        root = null;
    }

    public ConstructBSTPreOrder(int key){
        root = new Node(key);
    }

    public Node constructBST(int[] arr){
        int n = arr.length;
        //Index ind = new Index();
        return constructBSTUtil(arr, new Index(), 0, n-1, n);

    }

    public static class Index{
        int index =0;
    }
    //This takes O(n^2)
    public Node constructBSTUtil(int[] arr, Index pre, int low, int high, int size){
        //base case
        if(pre.index >= size || low > high)
            return null;

        Node key = new Node(arr[pre.index]);
        pre.index = pre.index +1;

        if(low == high){
            return key;
        }

        int i;
        for(i = low; i <= high; ++i){
            if(arr[i] > key.data)
                break;
        }

        key.left = constructBSTUtil(arr, pre, pre.index, i-1, size);
        key.right = constructBSTUtil(arr, pre, i, high, size);

        return key;

    }

    //With Improved Time Complexity
    public Node constructBSTUtil_Improved(int[] arr, Index pre,int key, int min, int max, int size){
        if(pre.index >= size)
            return null;

        Node root = null;

        if(key > min && key < max){
            root = new Node(key);
            pre.index += 1;

            if(pre.index < size){
                root.left = constructBSTUtil_Improved(arr, pre, arr[pre.index], min, key, size);
                root.right = constructBSTUtil_Improved(arr, pre, arr[pre.index], key, max, size);
            }
        }

        return root;























//        if (pre.index >= size) {
//            return null;
//        }
//
//        Node root = null;
//
//        // If current element of pre[] is in range, then
//        // only it is part of current subtree
//        if (key > min && key < max) {
//
//            // Allocate memory for root of this subtree and increment *preIndex
//            root = new Node(key);
//            pre.index = pre.index + 1;
//
//            if (pre.index < size) {
//
//                // Contruct the subtree under root
//                // All nodes which are in range {min .. key} will go in left
//                // subtree, and first such node will be root of left subtree.
//                root.left = constructBSTUtil_Improved(arr, pre, arr[pre.index],
//                        min, key, size);
//
//                // All nodes which are in range {key..max} will go in right
//                // subtree, and first such node will be root of right subtree.
//                root.right = constructBSTUtil_Improved(arr, pre, arr[pre.index],
//                        key, max, size);
//            }
//        }
//
//        return root;
    }

    public Node constructBST_Improved(int[] arr){
        return constructBSTUtil_Improved(arr, new Index(), arr[0], Integer.MIN_VALUE, Integer.MAX_VALUE, arr.length);
    }


    public void inOrderTraversal(Node key){
        if(key == null)
            return;
        inOrderTraversal(key.left);
        System.out.print(key.data + " ");
        inOrderTraversal(key.right);
    }

    public static void main(String[] args) {
        ConstructBSTPreOrder BT = new ConstructBSTPreOrder();
        int[] preOrder = {10, 5, 1, 7, 40, 50};




        //BT.inOrderTraversal(BT.constructBST(preOrder));


        BT.inOrderTraversal(BT.constructBST_Improved(preOrder));
    }

}
