package BinaryTree;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 30/12/16.
 */
public class IdenticalBST {
    Node root;
    ArrayList<Integer> res = new ArrayList<>();
    ArrayList<Integer> res1 = new ArrayList<>();

    public IdenticalBST() {
        root = null;
    }

    public IdenticalBST(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        IdenticalBST IT = new IdenticalBST();
        int[] arr1 = {2, 4, 1, 3};
        int[] arr2 = {2, 4, 3, 1};

//        ArrayList<Integer> res1 = IT.inOrderTraverse(arr1, 0, arr1.length - 1);
//        System.out.println(res1);
//
//        ArrayList<Integer> res2 = IT.inOrderTraverse1(arr2, 0, arr2.length - 1);
//
//        System.out.println(res2);
//
//        System.out.println(IT.isIdenticalBST(res1, res2));


        System.out.println(IT.isSameBST(arr1, arr2, arr1.length));

    }

    public boolean isIdenticalBST(ArrayList<Integer> res1, ArrayList<Integer> res2) {
        if (res1 == res2) {
            return true;
        } else {
            return false;
        }


    }

    public ArrayList<Integer> inOrderTraverse(int[] arr1, int start, int end) {
        if (start > end) {
            return res;
        } else {
            inOrderTraverse(arr1, 2 * start + 1, end);
            res.add(arr1[start]);
            inOrderTraverse(arr1, 2 * start + 2, end);
        }
        return res;
    }

    public ArrayList<Integer> inOrderTraverse1(int[] arr2, int start, int end) {
        if (start > end) {
            return res1;
        } else {
            inOrderTraverse1(arr2, 2 * start + 1, end);
            res1.add(arr2[start]);
            inOrderTraverse1(arr2, 2 * start + 2, end);
        }
        return res1;
    }


    // A C program to check for Identical BSTs without building the trees

    /* The main function that checks if two arrays a[] and b[] of size n construct
      same BST. The two values 'min' and 'max' decide whether the call is made for
      left subtree or right subtree of a parent element. The indexes i1 and i2 are
      the indexes in (a[] and b[]) after which we search the left or right child.
      Initially, the call is made for INT_MIN and INT_MAX as 'min' and 'max'
      respectively, because root has no parent.
      i1 and i2 are just after the indexes of the parent element in a[] and b[]. */
    boolean isSameBSTUtil(int a[], int b[], int n, int i1, int i2, int min, int max) {
        int j, k;

        for (j = i1; j < n; j++) {
            if (a[j] > min && a[j] < max) {
                break;
            }
        }

        for (k = i2; k < n; k++) {
            if (b[k] > min && b[k] < max) {
                break;
            }
        }

        if (j == n && k == n) {
            return true;
        }

        if (((j == n) ^ (k == n)) || (a[j] != b[k])) {
            return false;
        }


        return isSameBSTUtil(a, b, n, j + 1, k + 1, a[j], max) &&  //Right Subtree
            isSameBSTUtil(a, b, n, j + 1, k + 1, min, a[j]);


//        int j, k;
//
//   /* Search for a value satisfying the constraints of min and max in a[] and
//      b[]. If the parent element is a leaf node then there must be some
//      elements in a[] and b[] satisfying constraint. */
//        for (j=i1; j<n; j++)
//            if (a[j]>min && a[j]<max)
//                break;
//        for (k=i2; k<n; k++)
//            if (b[k]>min && b[k]<max)
//                break;
//
//   /* If the parent element is leaf in both arrays */
//        if (j==n && k==n)
//            return true;
//
//   /* Return false if any of the following is true
//      a) If the parent element is leaf in one array, but non-leaf in other.
//      b) The elements satisfying constraints are not same. We either search
//         for left child or right child of the parent element (decinded by min
//         and max values). The child found must be same in both arrays */
//        if (((j==n)^(k==n)) || a[j]!=b[k])
//            return false;
//
//   /* Make the current child as parent and recursively check for left and right
//      subtrees of it. Note that we can also pass a[k] in place of a[j] as they
//      are both are same */
//        return isSameBSTUtil(a, b, n, j+1, k+1, a[j], max) &&  // Right Subtree
//                isSameBSTUtil(a, b, n, j+1, k+1, min, a[j]);    // Left Subtree
    }

    // A wrapper over isSameBSTUtil()
    boolean isSameBST(int a[], int b[], int n) {
        return isSameBSTUtil(a, b, n, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
