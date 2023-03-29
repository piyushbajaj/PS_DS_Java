package BinaryTree.Practice_2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bajajp on 05 Jun, 2022
 */
public class VerticalOrder extends CommonUtils {
    public static void main(String[] args) {
        VerticalOrder verticalOrder = new VerticalOrder();
        verticalOrder.insertInBT(1);
        verticalOrder.insertInBT(2);
        verticalOrder.insertInBT(3);
        verticalOrder.insertInBT(4);
        verticalOrder.insertInBT(5);
        verticalOrder.insertInBT(6);
        verticalOrder.insertInBT(7);
//        verticalOrder.root.left.left.left = new TreeNode(8);
        verticalOrder.printBinaryTree_levelOrder(verticalOrder.root);
        System.out.println();
        System.out.println(verticalOrder.verticalOrder_recursive(verticalOrder.root));
    }

    public List<List<Integer>> verticalOrder_recursive(TreeNode node) {
        Map<Integer, List<Integer>> result = new TreeMap<>();
        List<List<Integer>> output = new ArrayList<>();
        verticalOrder_recursive_util(node, 0, result);

        result.forEach((key, value) -> {
            System.out.println(key + " " + value);
            output.add(value);
        });

        return output;
    }

    public void verticalOrder_recursive_util(TreeNode node, int distance, Map<Integer, List<Integer>> result) {
        if (node != null) {
            if (!result.containsKey(distance)) {
                result.put(distance, new ArrayList<>(Collections.singletonList(node.data)));
            } else {
                List<Integer> itr = result.get(distance);
                itr.add(node.data);
                Collections.sort(itr);
                result.put(distance, itr);
            }
            verticalOrder_recursive_util(node.left, distance - 1, result);
            verticalOrder_recursive_util(node.right, distance + 1, result);
        }
    }
}
