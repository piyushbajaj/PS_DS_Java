package BinaryTree.Practice_2022;

public class MultipleTrees extends CommonUtils {

    public boolean identicalStructureBT(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null) {
            return false;
        }

        return identicalStructureBT(node1.left, node2.left) && identicalStructureBT(node1.right, node2.right);
    }

    public static void main(String[] args) {
        MultipleTrees multipleTrees = new MultipleTrees();

        MultipleTrees multipleTrees1 = new MultipleTrees();
        multipleTrees1.insertInBT(1);
        multipleTrees1.insertInBT(2);
        multipleTrees1.insertInBT(3);
        multipleTrees1.insertInBT(4);
        multipleTrees1.insertInBT(5);
        multipleTrees1.insertInBT(6);
        multipleTrees1.insertInBT(7);
        multipleTrees1.printBinaryTree_levelOrder(multipleTrees1.root);
        System.out.println();

        MultipleTrees multipleTrees2 = new MultipleTrees();
        multipleTrees2.insertInBT(10);
        multipleTrees2.insertInBT(20);
        multipleTrees2.insertInBT(30);
        multipleTrees2.insertInBT(40);
        multipleTrees2.insertInBT(50);
        multipleTrees2.insertInBT(60);
        multipleTrees2.insertInBT(70);
        multipleTrees2.insertInBT(80);
        multipleTrees2.printBinaryTree_levelOrder(multipleTrees2.root);

        System.out.println();
        System.out.println(multipleTrees.identicalStructureBT(multipleTrees1.root, multipleTrees2.root));

    }
}
