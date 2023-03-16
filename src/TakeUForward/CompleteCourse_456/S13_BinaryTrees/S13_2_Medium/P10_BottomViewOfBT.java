package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_2_Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;
import javafx.util.Pair;

/**
 * Created by bajajp on 30 Sep, 2022
 * g4g:<a href="https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1">...</a>
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
        if (curr == null) {
            return new ArrayList<>();
        }

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

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<Integer> bottomView_much_better(TreeNode curr) {
        List<Integer> result = new ArrayList<>();
        if (curr == null) {
            return result;
        }

        // Node and then distance
        Queue<Pair<TreeNode, Integer>> pairQueue = new LinkedList<>();
        // Distance along with nodes
        Map<Integer, Integer> hashMap = new HashMap<>();

        pairQueue.offer(new Pair<>(curr, 0));
        int minDistance = 0, maxDistance = 0;

        while (!pairQueue.isEmpty()) {
            Pair<TreeNode, Integer> pair = pairQueue.remove();
            TreeNode node = pair.getKey();
            int distance = pair.getValue();

            hashMap.put(distance, node.data);

            if (node.left != null) {
                pairQueue.add(new Pair<TreeNode, Integer>(node.left, distance - 1));
            }

            if (node.right != null) {
                pairQueue.add(new Pair<TreeNode, Integer>(node.right, distance + 1));
            }

            minDistance = Math.min(minDistance, distance);
            maxDistance = Math.max(maxDistance, distance);
        }

        for (int i = minDistance; i <= maxDistance; i++) {
            int nodeVal = hashMap.get(i);
            result.add(nodeVal);
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
        System.out.println(p10_bottomViewOfBT.bottomView_much_better(root));
    }
}
