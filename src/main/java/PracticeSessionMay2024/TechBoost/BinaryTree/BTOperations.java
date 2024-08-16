package PracticeSessionMay2024.TechBoost.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javafx.util.Pair;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.BinaryTree
 * <p>
 * User: piyushbajaj
 * Date: 20/06/24
 * Time: 1:13 pm
 */
public class BTOperations {

    /**
     * TC: O(N)
     * SC: O(logN)
     *
     * @param root
     */
    public List<Integer> preOrderRecur(BTNode root) {
        List<Integer> arrayList = new ArrayList<>();
        preOrderRecurUtil(root, arrayList);
        return arrayList;
    }

    private void preOrderRecurUtil(BTNode root, List<Integer> arrayList) {
        if (root == null) {
            return;
        }

        arrayList.add(root.data);
        preOrderRecurUtil(root.left, arrayList);
        preOrderRecurUtil(root.right, arrayList);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderIterative(BTNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();
        Stack<BTNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BTNode temp = stack.pop();
            result.add(temp.data);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return result;
    }


    /**
     * TC: O(N)
     * SC: O(logN)
     *
     * @param root
     */
    public List<Integer> inOrderRecur(BTNode root) {
        List<Integer> arrayList = new ArrayList<>();
        inOrderRecurUtil(root, arrayList);
        return arrayList;
    }

    private void inOrderRecurUtil(BTNode root, List<Integer> arrayList) {
        if (root == null) {
            return;
        }

        inOrderRecurUtil(root.left, arrayList);
        arrayList.add(root.data);
        inOrderRecurUtil(root.right, arrayList);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderIterative(BTNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<BTNode> stack = new Stack<>();

        BTNode curr = root;

        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    curr = stack.pop();
                    result.add(curr.data);
                    curr = curr.right;
                }
            }
        }


        return result;
    }

    /**
     * TC: O(N)
     * SC: O(logN)
     *
     * @param root
     */
    public List<Integer> postOrderRecur(BTNode root) {
        List<Integer> arrayList = new ArrayList<>();
        postOrderRecurUtil(root, arrayList);
        return arrayList;
    }

    private void postOrderRecurUtil(BTNode root, List<Integer> arrayList) {
        if (root == null) {
            return;
        }

        postOrderRecurUtil(root.left, arrayList);
        postOrderRecurUtil(root.right, arrayList);
        arrayList.add(root.data);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderIterative(BTNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<BTNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }

        BTNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BTNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    result.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        result.add(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }

        return result;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     * Ref: <a href="https://youtu.be/ySp2epYvgTE?si=3ivx9UHtnEwzLC0A">...</a>
     *
     * @param root
     */
    public void preOrderInOrderPostOrderIterative(BTNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Pair<BTNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<BTNode, Integer> curr = stack.pop();
            if (curr.getValue() == 1) {
                preOrder.add(curr.getKey().data);
                stack.push(new Pair<>(curr.getKey(), curr.getValue() + 1));
                if (curr.getKey().left != null) {
                    stack.push(new Pair<>(curr.getKey().left, 1));
                }
            } else if (curr.getValue() == 2) {
                inOrder.add(curr.getKey().data);
                stack.push(new Pair<>(curr.getKey(), curr.getValue() + 1));
                if (curr.getKey().right != null) {
                    stack.push(new Pair<>(curr.getKey().right, 1));
                }
            } else {
                postOrder.add(curr.getKey().data);
            }
        }

        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderTraversal(BTNode root) {
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                BTNode temp = queue.remove();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                currList.add(temp.data);
            }

            result.add(currList);
        }

        return result;

    }

    /**
     * TC: O(logN)
     * SC: Auxiliary Space O(logN)
     *
     * @param root
     * @return
     */
    public int heightBTRecur(BTNode root) {
        if (root == null) {
            return 0;
        }

        int lHeight = heightBTRecur(root.left);
        int rHeight = heightBTRecur(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    /**
     * TC: O(N)
     * SC: O(Height of BT)
     *
     * @param root
     * @return
     */

    public int largestElement(BTNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftLargeElement = largestElement(root.left);
        int rightLargeElement = largestElement(root.right);

        return Math.max(root.data, Math.max(leftLargeElement, rightLargeElement));
    }

    /**
     * TC: O(N)
     * SC: O(Height of BT)
     *
     * @param root
     * @return
     */
    public int countLeafNodes(BTNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftCount = countLeafNodes(root.left);
        int rightCount = countLeafNodes(root.right);

        return leftCount + rightCount;
    }


    /**
     * TC: O(N)
     * SC: O(logN)
     *
     * @param root
     * @param val
     * @return
     */
    public boolean search(BTNode root, int val) {
        return search_util(root, val) != null;
    }

    private BTNode search_util(BTNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.data == val) {
            return root;
        }

        BTNode leftSearch = search_util(root.left, val);
        if (leftSearch != null) {
            return leftSearch;
        }

        BTNode rightSearch = search_util(root.right, val);
        if (rightSearch != null) {
            return rightSearch;
        }

        return null;
    }

    /**
     * Will be following preOrder technique here:
     * 1. If anytime root.data matches a or b, it will return root
     * 2. Go on the left side of the tree -> leftLCA
     * 3. Go on the right side of the tree -> rightLCA
     * 4. if leftLCA is not null and rightLCA is not null, root is the answer. Either of that is not null, that is
     * the answer, else null.
     * <p>
     * TC: O(N)
     * SC: O(logN)
     *
     * @param root
     * @param a
     * @param b
     * @return
     */
    public BTNode LCA(BTNode root, int a, int b) {
        // base conditions
        if (root == null) {
            return null;
        }

        if (root.data == a || root.data == b) {
            return root;
        }

        BTNode leftNode = LCA(root.left, a, b);
        BTNode rightNode = LCA(root.right, a, b);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        return leftNode != null ? leftNode : rightNode;
    }

    /**
     * Bruteforce approach
     * Question: <a href="https://leetcode.com/problems/balanced-binary-tree/">...</a>
     * Approach: <a href="https://www.youtube.com/watch?v=Yt50Jfbd8Po&ab_channel=takeUforward">...</a>
     * <p>
     * TC: O(N*N)
     * SC: O(N)
     *
     * @param root
     * @return
     */
    public boolean isBalanced(BTNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = heightBTRecur(root.left);
        int rightHeight = heightBTRecur(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);

        if (!leftBalanced || !rightBalanced) {
            return false;
        }

        return true;
    }

    /**
     * Problem: Check if the Binary Tree is Balanced
     * Question: <a href="https://leetcode.com/problems/balanced-binary-tree/">...</a>
     * Video: <a href="https://www.youtube.com/watch?v=Yt50Jfbd8Po&ab_channel=takeUforward">...</a>
     * TC: O(N)
     * SC: O(N)
     *
     * @param root
     * @return
     */
    public boolean isBalanced_better(BTNode root) {
        return heightModified(root) != -1;
    }

    private int heightModified(BTNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightModified(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = heightModified(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Diameter of tree
     * Question: <a href="https://leetcode.com/problems/diameter-of-binary-tree/">...</a>
     * <p>
     * TC: O(N*N)
     * SC: O(N)
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(BTNode root) {
        int[] diameter = new int[1];
        calculateHeight(root, diameter);
        return diameter[0];
    }

    private int calculateHeight(BTNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int leftHeight = calculateHeight(root.left, diameter);
        int rightHeight = calculateHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(20);
        root.right = new BTNode(30);
        root.left.left = new BTNode(40);
        root.left.right = new BTNode(50);
        root.right.left = new BTNode(60);
        root.right.right = new BTNode(70);
        BTOperations btOperations = new BTOperations();

        System.out.println("========================Binary Tree Traversal============================");
        System.out.println("PreOrder Traversal (Recursive) of BT: " + btOperations.preOrderRecur(root));
        System.out.println("PreOrder Traversal (Iterative) of BT: " + btOperations.preOrderIterative(root));
        System.out.println("InOrder Traversal (Recursive) of BT: " + btOperations.inOrderRecur(root));
        System.out.println("InOrder Traversal (Iterative) of BT: " + btOperations.inOrderIterative(root));
        System.out.println("PostOrder Traversal (Recursive) of BT: " + btOperations.postOrderRecur(root));
        System.out.println("PostOrder Traversal (Iterative) of BT: " + btOperations.postOrderIterative(root));
        System.out.println("Level Order Iterative Traversal of BT: " + btOperations.levelOrderTraversal(root));
        System.out.println("PreOrder InOrder PostOrder Traversal in single pass of BT: ");
        btOperations.preOrderInOrderPostOrderIterative(root);

        System.out.println("\n========================Binary Tree Operations============================");
        System.out.println("Search in BT: " + btOperations.search(root, 60));
        System.out.println("Maximum Height (Recursive) of BT: " + btOperations.heightBTRecur(root));
        System.out.println("Largest Element in BT: " + btOperations.largestElement(root));
        System.out.println("Number of Leaf Nodes in BT: " + btOperations.countLeafNodes(root));

        System.out.println("\n========================Complex Binary Tree Operations=====================");
        System.out.println("LCA in BT: " + btOperations.LCA(root, 40, 70).data);

        // Initialize
//        root.right.right.left = new BTNode(65);
//        root.right.right.right = new BTNode(75);
        System.out.println("Is Balanced BT Brute-force approach: " + btOperations.isBalanced(root));
//        root.right.right.right.right = new BTNode(80);
        System.out.println("Is Balanced BT Brute-force approach: " + btOperations.isBalanced(root));
        System.out.println("Is Balanced BT Optimised approach: " + btOperations.isBalanced_better(root));

        System.out.println("Diameter of BT Bruteforce approach: " + btOperations.diameterOfBinaryTree(root));

    }
}
