package TakeUForward.Blind75.Tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 2:29 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">...</a>
 */
public class P6_Serialize_Deserialize_BT {

    public static void main(String[] args) {
        P6_Serialize_Deserialize_BT p6_serialize_deserialize_bt = new P6_Serialize_Deserialize_BT();

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);

        String serialize = p6_serialize_deserialize_bt.serialize(node);
        System.out.println(serialize);
        Utils.printTree(node);
        Utils.printTree(p6_serialize_deserialize_bt.deserialize(serialize));
    }

    /**
     * Serialization: Encodes a tree to a single string.
     * Followed Level Order Traversal to store the elements in the format like
     * Delimiter -> ','
     * Null -> #
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode currNode = treeNodeQueue.remove();

            if (currNode == null) {
                res.append("#,");
            } else {
                res.append(String.valueOf(currNode.data).concat(","));
                treeNodeQueue.offer(currNode.left);
                treeNodeQueue.offer(currNode.right);
            }
        }

        return res.toString();
    }

    /**
     * Deserialization: Decodes your encoded data to tree.
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) {
            return null;
        }

        String[] strValues = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strValues[0]));

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        int strValueLen = strValues.length;

        for (int i = 1; i < strValueLen - 1; i = i + 2) {
            TreeNode parent = treeNodeQueue.remove();

            if (!strValues[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(strValues[i]));
                parent.left = leftNode;
                treeNodeQueue.offer(leftNode);
            }

            if (!strValues[i + 1].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(strValues[i + 1]));
                parent.right = rightNode;
                treeNodeQueue.offer(rightNode);
            }
        }

        return root;
    }
}
