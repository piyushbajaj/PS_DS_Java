package BinaryTree.Practice_2022;

public class ConstructTreePostOrderInOrder extends CommonUtils {

    static int index = 0;

    public static void main(String[] args) {
        ConstructTreePostOrderInOrder constructTree = new ConstructTreePostOrderInOrder();
        constructTree.root =
            constructTree.constructPostOrderInOrder(new int[] {4, 5, 2, 6, 7, 3, 1}, new int[] {4, 2, 5, 1, 6, 3, 7});
        constructTree.printBinaryTree_levelOrder(constructTree.root);
    }

    public TreeNode constructPostOrderInOrder(int[] postOrder, int[] inOrder) {
        index = inOrder.length - 1;
        return constructPostOrderInOrder_util(postOrder, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode constructPostOrderInOrder_util(int[] postOrder, int[] inOrder, int start, int end) {
        if (start <= end) {
            int i = start;
            for (; i < end; i++) {
                if (postOrder[index] == inOrder[i]) {
                    break;
                }
            }

            TreeNode node = new TreeNode(postOrder[index]);
            index--;
            node.right = constructPostOrderInOrder_util(postOrder, inOrder, i + 1, end);
            node.left = constructPostOrderInOrder_util(postOrder, inOrder, start, i - 1);

            return node;
        }

        return null;
    }
}
