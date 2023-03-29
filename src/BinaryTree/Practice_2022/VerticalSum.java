package BinaryTree.Practice_2022;

import java.util.HashMap;
import java.util.Map;

public class VerticalSum extends CommonUtils {
    public static void main(String[] args) {
        VerticalSum vs = new VerticalSum();
        vs.insertInBT(1);
        vs.insertInBT(2);
        vs.insertInBT(3);
        vs.insertInBT(4);
        vs.insertInBT(5);
        vs.insertInBT(6);
        vs.insertInBT(7);
        vs.printBinaryTree_levelOrder(vs.root);
        System.out.println();
        vs.verticalSum(vs.root);
    }

    public void verticalSum(TreeNode node) {
        // HashMap<Position, Sum>
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        verticalSum_Util(node, 0, hashMap);

        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }

    public void verticalSum_Util(TreeNode node, int position, HashMap<Integer, Integer> hashMap) {
        if (node.left != null) {
            verticalSum_Util(node.left, position - 1, hashMap);
        }

        if (node.right != null) {
            verticalSum_Util(node.right, position + 1, hashMap);
        }

        if (hashMap.containsKey(position)) {
            hashMap.put(position, node.data + hashMap.get(position));
        } else {
            hashMap.put(position, node.data);
        }
    }
}
