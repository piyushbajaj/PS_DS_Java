package TechboostJune2020.BST;

public class PreOrderConversionBST {
    TreeNode root;

    public static void main(String[] args) {
        PreOrderConversionBST preOrderConversionBST = new PreOrderConversionBST();
        int[] preOrderBST = {10, 5, 1, 7, 40, 50};
//		preOrderConversionBST.root = preOrderConversionBST.constructBST(preOrderBST);
//
//		preOrderConversionBST.printTree(preOrderConversionBST.root);

        preOrderConversionBST.root = preOrderConversionBST.constructBST_better(preOrderBST);

        preOrderConversionBST.printTree(preOrderConversionBST.root);


    }

    public TreeNode constructBST(int[] preOrderArr) {
        int low = 0;
        int high = preOrderArr.length - 1;

        return constructBST_Util(preOrderArr, new Index(), low, high, preOrderArr.length);
    }

    // T.C: O(N*N)
    // S.C: O(N)
    public TreeNode constructBST_Util(int[] preOrderArr, Index preIndex, int low, int high, int size) {
        if (low > high || preIndex.index >= size) {
            return null;
        }

        // Root Condition
        TreeNode node = new TreeNode(preOrderArr[preIndex.index]);
//		if(root == null) {
//			root = node;
//		}
        preIndex.index++;

        // Forming BST structure, this loop will come into the action
        int i = 0;

        // T.C: O(N)
        for (i = low + 1; i <= high; i++) {
            if (preOrderArr[i] > node.data) {
                break;
            }
        }

        // Left Child Condition
        node.left = constructBST_Util(preOrderArr, preIndex, preIndex.index, i - 1, size);

        // Right Child Condition
        node.right = constructBST_Util(preOrderArr, preIndex, i, high, size);

        return node;
    }

    public TreeNode constructBST_better(int[] preOrderArr) {

        return constructBST_util_better(preOrderArr, new Index(), preOrderArr[0], Integer.MIN_VALUE, Integer.MAX_VALUE,
            preOrderArr.length);
    }

    // T.C: o(N)
    // S.C: o(N)
    public TreeNode constructBST_util_better(int[] preOrderArr, Index preIndex, int key, int min, int max, int size) {
        if (preIndex.index >= size || (min > max)) {
            return null;
        }

        TreeNode node = null;


        System.out.println("PreIndex" + preIndex.index + " Key " + key + " Min " + min + " Max " + max);

        // To ensure we are in BST
        if (key > min && key < max) {
            node = new TreeNode(key);
            preIndex.index++;

            System.out.println(key + " ");

            if (preIndex.index < size) {
                // Do left
                node.left =
                    constructBST_util_better(preOrderArr, preIndex, preOrderArr[preIndex.index], min, key, size);

                // Do right
                node.right =
                    constructBST_util_better(preOrderArr, preIndex, preOrderArr[preIndex.index], key, max, size);
            }
        }

        return node;

    }

    //
    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.data + " ");
        printTree(node.right);
    }


    // Printing tree in InOrder traversal

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    class Index {
        int index = 0;
    }
}
