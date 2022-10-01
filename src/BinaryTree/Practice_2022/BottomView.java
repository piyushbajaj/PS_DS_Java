package BinaryTree.Practice_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bajajp on 05 Jun, 2022
 */
public class BottomView extends CommonUtils {
    public List<Integer> bottomView_recur(TreeNode node) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> result = new TreeMap<>();

        bottomView_recur_util(node, 0, result);

        result.forEach((key, value) -> {
            output.add(value);
        });

        return output;
    }

    public void bottomView_recur_util(TreeNode node, int distance, Map<Integer, Integer> result) {
        if (node != null) {
            result.put(distance, node.data);

            bottomView_recur_util(node.left, distance - 1, result);
            bottomView_recur_util(node.right, distance + 1, result);
        }
    }

    public static void main(String[] args) {
        BottomView bottomView = new BottomView();
        bottomView.root = new TreeNode(1);
        bottomView.root.left = new TreeNode(2);
        bottomView.root.right = new TreeNode(3);
        bottomView.root.left.left = new TreeNode(4);
        bottomView.root.left.right = new TreeNode(5);
        bottomView.root.right.left = new TreeNode(6);
        bottomView.root.right.right = new TreeNode(7);

        System.out.println(bottomView.bottomView_recur(bottomView.root));
    }
}
