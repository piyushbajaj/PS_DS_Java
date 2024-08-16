package BinaryTree.Practice_2022;

public class BT_24_LCA extends CommonUtils {
    public static void main(String[] args) {
        BT_24_LCA lcabt = new BT_24_LCA();
        lcabt.insertInBT(1);
        lcabt.insertInBT(2);
        lcabt.insertInBT(3);
        lcabt.insertInBT(4);
        lcabt.insertInBT(5);
        lcabt.insertInBT(6);
        lcabt.insertInBT(7);
        lcabt.printBinaryTree_levelOrder(lcabt.root);
        System.out.println();
        System.out.println(lcabt.getLCA(lcabt.root, lcabt.root.left.left, lcabt.root.right.right).data);
    }

    public TreeNode getLCA(TreeNode node, TreeNode key1, TreeNode key2) {
        if (node == null) {
            return null;
        }

        if (node == key1 || node == key2) {
            return node;
        }

        TreeNode leftLCA = getLCA(node.left, key1, key2);
        TreeNode rightLCA = getLCA(node.right, key1, key2);

        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }
}
