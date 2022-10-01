package TakeUForward.S13_BinaryTrees.S13_2_Medium;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by bajajp on 30 Sep, 2022
 */
public class P10_BottomViewOfBT {
    /**
     * Better way to use Pair instead of defining tuple
     * TC: O(nLogN)
     * SC: O(n)
     *
     * @param curr
     * @return
     */
    public List<Integer> bottomView_better(TreeNode curr) {
        if (curr == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // To store the nodes
        Queue<Pair<TreeNode, Integer>> queueNode = new LinkedList<>();
        queueNode.offer(new Pair<>(curr, 0));

        while (!queueNode.isEmpty()) {
            Pair<TreeNode, Integer> currPair = queueNode.remove();
            TreeNode currNode = currPair.getKey();
            int distance = currPair.getValue();

            treeMap.put(distance, currNode.data);

            if (currNode.left != null) {
                queueNode.offer(new Pair<>(currNode.left, distance - 1));
            }
            if (currNode.right != null) {
                queueNode.offer(new Pair<>(currNode.right, distance + 1));
            }
        }

        for (Map.Entry<Integer, Integer> map : treeMap.entrySet()) {
            result.add(map.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        P10_BottomViewOfBT p10_bottomViewOfBT = new P10_BottomViewOfBT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p10_bottomViewOfBT.bottomView_better(root));
    }
}
