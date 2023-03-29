package Heap;

/**
 * Created by piyush.bajaj on 08/01/17.
 */
public class isHeapSort {
    Node root;

    public isHeapSort() {
        root = null;
    }

    public isHeapSort(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        isHeapSort BT = new isHeapSort(100);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(80);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(90);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(70);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(60);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(50);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(40);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);


        System.out.println("Is given Binary tree represents heap or not? " + BT.isHeap(BT.root));

        int[] arr = {100, 80, 90, 110, 60, 50, 40};

        System.out.println("Is given Array represents heap or not? " + BT.isArrayHeap(arr));
    }

    public boolean isHeap(Node key) {
        if (key == null) {
            return false;
        }

        if ((key.left == null && key.right != null) || (key.left != null && key.right == null)) {
            return false;
        } else if (key.left == null && key.right == null) {
            return true;
        }

        if (key.data >= key.left.data && key.data >= key.right.data) {
            return isHeap(key.left) && isHeap(key.right);
        } else {
            return false;
        }

        //return true;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public boolean isArrayHeap(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int l = left(i);
            int r = right(i);

            if (l >= n || r >= n) {
                break;
            }

            if (arr[i] < arr[l] || arr[i] < arr[r]) {
                return false;
            }


        }
        return true;

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
