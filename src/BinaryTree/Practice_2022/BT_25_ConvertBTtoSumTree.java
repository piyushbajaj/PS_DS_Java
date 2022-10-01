package BinaryTree.Practice_2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bajajp on 10 Jun, 2022
 */
public class BT_25_ConvertBTtoSumTree extends CommonUtils {
    public int convertBTSumTree(TreeNode root) {
        if (root == null) return 0;
        String[] words = {"foo", "bar"};
        Set<String> set = new HashSet<>(Arrays.asList(words));

        int leftSum = convertBTSumTree(root.left);
        int rightSum = convertBTSumTree(root.right);

        int old = root.data;

        root.data = leftSum + rightSum;

        return root.data + old;
    }

    public static void main(String[] args) {
        BT_25_ConvertBTtoSumTree convertBTtoSumTree = new BT_25_ConvertBTtoSumTree();
        convertBTtoSumTree.insertDummyNodes();
        System.out.println(convertBTtoSumTree.printBinaryTree_levelOrder(convertBTtoSumTree.root));
        convertBTtoSumTree.convertBTSumTree(convertBTtoSumTree.root);
        System.out.println(convertBTtoSumTree.printBinaryTree_levelOrder(convertBTtoSumTree.root));
    }
}
