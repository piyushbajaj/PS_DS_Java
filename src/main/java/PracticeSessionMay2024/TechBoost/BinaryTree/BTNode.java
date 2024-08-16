package PracticeSessionMay2024.TechBoost.BinaryTree;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.BinaryTree
 * <p>
 * User: piyushbajaj
 * Date: 20/06/24
 * Time: 12:06 pm
 */
public class BTNode {
    BTNode left, right;
    int data;

    public BTNode(int data) {
        this.data = data;
        this.right = this.left = null;
    }
}
