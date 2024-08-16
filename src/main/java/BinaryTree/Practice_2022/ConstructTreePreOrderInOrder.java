package BinaryTree.Practice_2022;

public class ConstructTreePreOrderInOrder extends CommonUtils {
    int index = 0;

    public static void main(String[] args) {
        ConstructTreePreOrderInOrder constructTree = new ConstructTreePreOrderInOrder();
        constructTree.root = constructTree.constructBTFromInOrderPreOrder(new int[] {1, 2, 4, 5, 3, 6, 7},
            new int[] {4, 2, 5, 1, 6, 3, 7});
        constructTree.printBinaryTree_levelOrder(constructTree.root);
    }

    public TreeNode constructBTFromInOrderPreOrder(int[] preOrder, int[] inOrder) {
        return constructBTFromInOrderPreOrder_util(preOrder, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode constructBTFromInOrderPreOrder_util(int[] preOrder, int[] inOrder, int start, int end) {
        if (start <= end) {
            int i = start;

            for (; i < end; i++) {
                if (preOrder[index] == inOrder[i]) {
                    break;
                }
            }

            TreeNode node = new TreeNode(preOrder[index]);
            index++;
            node.left = constructBTFromInOrderPreOrder_util(preOrder, inOrder, start, i - 1);
            node.right = constructBTFromInOrderPreOrder_util(preOrder, inOrder, i + 1, end);

            return node;
        }

        return null;
    }
}
