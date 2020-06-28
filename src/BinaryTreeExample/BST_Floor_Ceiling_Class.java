package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 25/12/16.
 */
public class BST_Floor_Ceiling_Class {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public BST_Floor_Ceiling_Class(){
        root = null;
    }

    public BST_Floor_Ceiling_Class(int key){
        root = new Node(key);
    }

    public Node inOrder_BST(int[] arr, int start, int end){
        //int floor = 0, ceil = 0;
        if(start>end)
            return null;

        int mid = (start+end)/2;

        Node root = new Node(arr[mid]);

        root.left = inOrder_BST(arr,start, mid-1);

        root.right = inOrder_BST(arr, mid+1, end);

        return root;

    }

//    public Node floor_calculation(Node key, int data){
//        Node prev = null;
//
//        return floor_cal_recur(key, prev, data);
//    }
//
//    public Node floor_cal_recur(Node key, Node prev, int data){
//        if(key == null)
//            return null;
//
//         key.left = floor_cal_recur(key.left, prev, data);
//
//        if(key.left!=null)
//            return key.left;
//
//        if(key.data == data)
//            return key;
//
//        if(key.data > data) {
//            return prev;
//        }
//
//        prev = key;
//
//        key.right= floor_cal_recur(key.right, prev, data);
//        return prev;
//    }


//    public int floor_calculation(Node key, int data){
//        if(key == null)
//            return -1;
//
//        if(key.data == data)
//            return key.data;
//
//        //If root's key is bigger then the value must be in left subtree
//        if(key.data > data)
//            floor_calculation(key.left, data);
//
//        //Or else either right subtree or root has the Floor Value
//
//        int floor = floor_calculation(key.right, data);
//        return (floor < data)? floor:key.data;
//    }

    static class Value
    {
        int floor=-1;
        int ceil= -1;
    }


    void floorCeil(Node root, Value value, int max, int min, int data)
    {
        if(root==null)
            return;

        if(root.data==data)
        {
            value.floor=root.data;
            value.ceil=root.data;
        }


        if(root.data<data)
        {
            value.floor= root.data;
            floorCeil(root.right, value, max, root.data, data);
        }
        else
        {
            value.ceil= root.data;
            floorCeil(root.left, value, root.data, min, data);
        }


    }



    public static void main(String[] args) {
        BST_Floor_Ceiling_Class tree = new BST_Floor_Ceiling_Class();

        int[] arr = new int[]{1, 2, 8, 10, 10, 12, 19};
        int n = arr.length;
        int x =9;

        Node root = tree.inOrder_BST(arr, 0, n - 1);

        System.out.println("Root: " + root.data);
        System.out.println("Root (" + root.data + ") -> Left: " + root.left.data);
        System.out.println("Root (" + root.data + ") -> Right: " + root.right.data);
        System.out.println("Root (" + root.data + ") -> Left (" + root.left.data + ") -> Left: " + root.left.left.data);
        System.out.println("Root (" + root.data + ") -> Left (" + root.left.data + ") -> Right: " + root.left.right.data);
        System.out.println("Root (" + root.data + ") -> Right (" + root.right.data + ")-> Left: " + root.right.left.data);
        System.out.println("Root (" + root.data + ") -> Right (" + root.right.data + ") -> Right: " + root.right.right.data);


        System.out.print("The floor value for this integer(" + x + ") is: ");

        Value val = new Value();

        tree.floorCeil(root, val, Integer.MAX_VALUE, Integer.MIN_VALUE, x);

        System.out.println("Floor value: " + val.floor);

        System.out.println("Ceil value: " + val.ceil);

        //System.out.print(tree.floor_calculation(root, x));
//        tree.inOrderTraversal(root);
    }
}
