package BinaryTree.Practice_2022;

public class RootToLeaf extends CommonUtils {
    public void getRootToLeaf(TreeNode node, int[] path, int pathLen) {
        if (node == null) return;

        path[pathLen] = node.data;
        pathLen++;

        if (node.left == null && node.right == null) {
            printArrayPath(path, pathLen);
        } else {
            getRootToLeaf(node.left, path, pathLen);
            getRootToLeaf(node.right, path, pathLen);
        }
    }

    public boolean matchRootToLeafSum(TreeNode node, int sum) {
        if (node == null) return false;

        if (node.left == null && node.right == null && node.data == sum) {
            return true;
        }

        return matchRootToLeafSum(node.left, sum - node.data) || matchRootToLeafSum(node.right, sum - node.data);
    }

    public void printArrayPath(int[] path, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RootToLeaf rootToLeaf = new RootToLeaf();
        rootToLeaf.insertInBT(1);
        rootToLeaf.insertInBT(2);
        rootToLeaf.insertInBT(3);
        rootToLeaf.insertInBT(4);
        rootToLeaf.insertInBT(5);
        rootToLeaf.insertInBT(6);
        rootToLeaf.insertInBT(7);
        rootToLeaf.printBinaryTree_levelOrder(rootToLeaf.root);
        System.out.println();

        rootToLeaf.getRootToLeaf(rootToLeaf.root, new int[256], 0);

        System.out.println(rootToLeaf.matchRootToLeafSum(rootToLeaf.root, 9));
    }
}
