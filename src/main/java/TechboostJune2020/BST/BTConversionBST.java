package TechboostJune2020.BST;

import java.util.ArrayList;
import java.util.Collections;

public class BTConversionBST {
    TreeNode root;
    ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        BTConversionBST bt = new BTConversionBST();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);

        bt.inOrderTraversal(bt.root);
        System.out.println(bt.arrayList);

        // Sorting the elements
        Collections.sort(bt.arrayList);

        // T.C.: nlogn (Internally uses either of quick, merge or heap sort)
        System.out.println(bt.arrayList);

//		int[] arr = bt.arrayList.toArray();
//

        // Putting the array to the InOrderBST
        bt.root = bt.arrayListToBST(bt.arrayList, bt.root, 0);

        bt.printTree(bt.root);

    }

    public void inOrderTraversal(TreeNode Nd) {
        if (Nd == null) {
            return;
        }

        inOrderTraversal(Nd.left);
        arrayList.add(Nd.data);
        inOrderTraversal(Nd.right);
    }


    public void printTree(TreeNode Nd) {
        if (Nd == null) {
            return;
        }

        inOrderTraversal(Nd.left);
        System.out.print(Nd.data + " ");
        inOrderTraversal(Nd.right);
    }

    // Total T.C: O(NlogN)

    // T.C: O(N)
    public TreeNode arrayListToBST(ArrayList<Integer> arr, TreeNode node, int index) {
        // Base condition
        if (node == null) {
            return null;
        }

        // Left Node
        arrayListToBST(arr, node.left, index);

        // Root Node
        node.data = arr.get(index);
        index++;

        // Right Node
        arrayListToBST(arr, node.right, index);

        return node;

    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
