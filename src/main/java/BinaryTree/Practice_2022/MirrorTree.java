package BinaryTree.Practice_2022;

public class MirrorTree extends CommonUtils {
    public static void main(String[] args) {
        MirrorTree mirrorTree = new MirrorTree();
        mirrorTree.insertInBT(1);
        mirrorTree.insertInBT(2);
        mirrorTree.insertInBT(3);
        mirrorTree.insertInBT(4);
        mirrorTree.insertInBT(5);
        mirrorTree.insertInBT(6);
        mirrorTree.insertInBT(7);

        MirrorTree mirrorTree2 = new MirrorTree();
        mirrorTree2.insertInBT(1);
        mirrorTree2.insertInBT(3);
        mirrorTree2.insertInBT(2);
        mirrorTree2.insertInBT(7);
        mirrorTree2.insertInBT(6);
        mirrorTree2.insertInBT(5);
        mirrorTree2.insertInBT(4);

        mirrorTree.printBinaryTree_levelOrder(mirrorTree.root);
        System.out.println();
        mirrorTree.printBinaryTree_levelOrder(mirrorTree2.root);
        System.out.println();

        System.out.println(mirrorTree.isMirrorTree(mirrorTree.root, mirrorTree2.root));

        mirrorTree.printBinaryTree_levelOrder(mirrorTree.root);
        System.out.println();
        mirrorTree.createMirrorTree(mirrorTree.root);
        mirrorTree.printBinaryTree_levelOrder(mirrorTree.root);
    }

    public void createMirrorTree(TreeNode node) {
        if (node != null) {
            createMirrorTree(node.left);
            createMirrorTree(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    public boolean isMirrorTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.data != node2.data) {
            return false;
        }

        return isMirrorTree(node1.left, node2.right) && isMirrorTree(node1.right, node2.left);
    }
}
