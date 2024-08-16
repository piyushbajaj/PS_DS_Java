package BinaryTree.Practice_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bajajp on 05 Jun, 2022
 */
public class TopView extends CommonUtils {
    public static void main(String[] args) {
        TopView topView = new TopView();
        topView.insertInBT(1);
        topView.insertInBT(2);
        topView.insertInBT(3);
        topView.insertInBT(4);
        topView.insertInBT(5);
        topView.insertInBT(6);
        topView.insertInBT(7);
        topView.root.left.left.left = new TreeNode(8);
        topView.printBinaryTree_levelOrder(topView.root);
        System.out.println();
        System.out.println(topView.topViewTraversal(topView.root));
    }

    public List<Integer> topViewTraversal(TreeNode node) {
        Map<Integer, Integer> result = new TreeMap<>();
        List<Integer> output = new ArrayList<>();
        topViewTraversal_preOrder(node, 0, result);

        result.forEach((key, value) -> {
            System.out.println(key + " " + value);
            output.add(value);
        });

        return output;
    }

    public void topViewTraversal_preOrder(TreeNode node, int distance, Map<Integer, Integer> result) {
        if (node != null) {
            if (!result.containsKey(distance)) {
                result.put(distance, node.data);
            }
            topViewTraversal_preOrder(node.left, distance - 1, result);
            topViewTraversal_preOrder(node.right, distance + 1, result);
        }
    }
}
