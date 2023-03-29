package BinaryTree.Practice_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal extends CommonUtils {
    public static void main(String[] args) {
        DFSTraversal dfsTraversal = new DFSTraversal();
        dfsTraversal.root = new TreeNode(1);
        dfsTraversal.root.left = new TreeNode(2);
        dfsTraversal.root.right = new TreeNode(3);
        dfsTraversal.root.left.left = new TreeNode(4);
        dfsTraversal.root.left.right = new TreeNode(5);
        dfsTraversal.root.right.left = new TreeNode(6);
        dfsTraversal.root.right.right = new TreeNode(7);

        System.out.println("PreOrder Recursion: " + dfsTraversal.preOrderRecur(dfsTraversal.root));
        System.out.println("PreOrder Iterative: " + dfsTraversal.preOrderIterative(dfsTraversal.root));
        System.out.println("Inorder Recursion: " + dfsTraversal.inOrderRecur(dfsTraversal.root));
        System.out.println("Inorder Iterative: " + dfsTraversal.inOrderIterative(dfsTraversal.root));
        System.out.println("Inorder Iterative Better: " + dfsTraversal.inOrderIterative_better(dfsTraversal.root));
        System.out.println("PostOrder Recursive: " + dfsTraversal.postOrderRecur(dfsTraversal.root));
        System.out.println("PostOrder Iterative: " + dfsTraversal.postOrderIterative(dfsTraversal.root));
        System.out.println("PostOrder Iterative Better: " + dfsTraversal.postOrderIterative_better(dfsTraversal.root));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> preOrderRecur(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        preOrderRecur_Util(node, res);
        return res;
    }

    private void preOrderRecur_Util(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.data);
            preOrderRecur_Util(node.left, res);
            preOrderRecur_Util(node.right, res);
        }
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> preOrderIterative(TreeNode node) {
        List<Integer> res = new ArrayList<>();

        if (node == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.data);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return res;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> inOrderRecur(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        inOrderRecur_Util(node, res);
        return res;
    }

    private void inOrderRecur_Util(TreeNode node, List<Integer> res) {
        if (node != null) {
            inOrderRecur_Util(node.left, res);
            res.add(node.data);
            inOrderRecur_Util(node.right, res);
        }
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> inOrderIterative(TreeNode node) {
        List<Integer> res = new ArrayList<>();

        if (node == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = node;
        boolean flag = false;
        while (!flag) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                if (stack.isEmpty()) {
                    flag = true;
                } else {
                    currNode = stack.pop();
                    res.add(currNode.data);
                    currNode = currNode.right;
                }
            }
        }
        return res;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> inOrderIterative_better(TreeNode node) {
        List<Integer> arrayList = new ArrayList<>();
        if (node == null) {
            return arrayList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = node;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            arrayList.add(currNode.data);
            currNode = currNode.right;
        }

        return arrayList;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> postOrderRecur(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        postOrderRecur_Util(node, res);
        return res;
    }

    private void postOrderRecur_Util(TreeNode node, List<Integer> res) {
        if (node != null) {
            postOrderRecur_Util(node.left, res);
            postOrderRecur_Util(node.right, res);
            res.add(node.data);
        }
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> postOrderIterative(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null, curr = null;
        stack.push(node);

        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                // explore all current right and left nodes and push it to the stack
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                res.add(curr.data);
                stack.pop();
            }
            prev = curr;
        }
        return res;
    }

    public List<Integer> postOrderIterative_better(TreeNode node) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        s1.push(node);
        TreeNode curr = null;
        while (!s1.isEmpty()) {
            curr = s1.pop();
            s2.push(curr);
            if (curr.left != null) {
                s1.push(curr.left);
            }
            if (curr.right != null) {
                s1.push(curr.right);
            }
        }

        while (!s2.isEmpty()) {
            res.add(s2.pop().data);
        }
        return res;
    }
}
