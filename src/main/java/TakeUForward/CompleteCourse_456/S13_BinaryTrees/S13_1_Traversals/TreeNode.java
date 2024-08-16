package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class TreeNode {
    public TreeNode left, right;
    public int data;

    List<TreeNode> nArray = new ArrayList<>();

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
