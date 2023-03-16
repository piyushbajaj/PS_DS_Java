package TakeUForward.Blind75.Tree;

import java.util.ArrayList;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 6:11 pm
 */
public class Utils {
    // Inorder
    public static void printTree(TreeNode node) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        printTree(node, arrayList);
        System.out.println(arrayList);
    }

    private static void printTree(TreeNode node, ArrayList<Integer> arrayList) {
        if (node != null) {
            printTree(node.left, arrayList);
            arrayList.add(node.data);
            printTree(node.right, arrayList);
        }
    }
}
