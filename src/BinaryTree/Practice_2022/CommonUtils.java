package BinaryTree.Practice_2022;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CommonUtils extends BaseTreeNode {

    /*
    TC: O(N)
    SC: O(N)
     */
    public int countNodes_recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int countLeft = countNodes_recursion(node.left);
        int countRight = countNodes_recursion(node.right);

        return countLeft + countRight + 1;
    }

    /*
    TC: O(N)
    SC: O(N)
     */
    public int countNodes_iterative(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            count++;

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return count;
    }


    public int heightBinaryTree(TreeNode node) {
        if (node == null) return 0;

        int heightLeft = heightBinaryTree(node.left);
        int heightRight = heightBinaryTree(node.right);

        return (heightLeft > heightRight) ? heightLeft + 1 : heightRight + 1;
    }

    public int heightBinaryTree_iterative_queue(TreeNode node) {
        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int height = 0;

        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;

            while (nodeCount > 0) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                    nodeCount--;
                }
            }
        }
    }

    public int heightBinaryTree_iterative_queue_better(TreeNode node) {
        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        queue.offer(null);
        int count = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    count++;
                    queue.offer(null);
                }
            }
        }
        return count;
    }

    public int heightBinaryTree_iterative_stack(TreeNode node) {
        if (node == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode prev = null;
        int maxHeight = 0;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();

            if (prev == null || prev.left == curr || prev.right == curr) {
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
                stack.pop();
            }
            prev = curr;

            if (stack.size() > maxHeight) {
                maxHeight = stack.size();
            }
        }
        return maxHeight;
    }

    public int largestElement(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;

        int largestLeft = largestElement(node.left);
        int largestRight = largestElement(node.right);

        return Math.max(node.data, Math.max(largestLeft, largestRight));
    }

    // Doing with the help of Level Order Traversal here.
    public int largestElementIterative(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.data > max) {
                max = temp.data;
            }

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return max;
    }

    public int countLeafNodes(TreeNode node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return 1;
        }

        int countLeafLeft = countLeafNodes(node.left);
        int countLeafRight = countLeafNodes(node.right);

        return countLeafLeft + countLeafRight;
    }

    public int countLeafNodes_iterative(TreeNode node) {
        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left == null && temp.right == null) {
                count++;
            }

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return count;
    }

    public int countFullNodes_iterative(TreeNode node) {
        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null && temp.right != null) {
                count++;
            }

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return count;
    }

    public int countHalfNodes_iterative(TreeNode node) {
        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if ((temp.left != null && temp.right == null) || (temp.left == null && temp.right != null)) {
                count++;
            }

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return count;
    }

    public boolean searchInTheBinaryTreeRecur(TreeNode node, int key) {
        if (node == null) return false;

        if (node.data == key) {
            return true;
        }

        return searchInTheBinaryTreeRecur(node.left, key) || searchInTheBinaryTreeRecur(node.right, key);
    }

    public boolean searchInTheBinaryTreeIteration(TreeNode node, int key) {
        if (node == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.data == key) return true;
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return false;
    }

    public void insertInBT(int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null) {
                queue.offer(temp.left);
            } else {
                temp.left = newNode;
                return;
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            } else {
                temp.right = newNode;
                return;
            }
        }
    }

    public void insertInBST(int data) {
        root = insertBST_util(root, data);
    }

    private TreeNode insertBST_util(TreeNode node, int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return root;
        }

        if (node == null) {
            node = newNode;
            return node;
        }

        if (data < node.data) {
            node.left = insertBST_util(node.left, data);
        } else if (data > node.data) {
            node.right = insertBST_util(node.right, data);
        }

        return node;
    }

    public int findDeepestNode(TreeNode node) {
        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        assert temp != null;
        return temp.data;

    }

    public void printBinaryTree_inOrder(TreeNode node) {
        if (node == null) return;

        printBinaryTree_inOrder(node.left);
        System.out.print(node.data + " ");
        printBinaryTree_inOrder(node.right);
    }

    public List<List<Integer>> printBinaryTree_levelOrder(TreeNode node) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (node == null) return result;

        queue.offer(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> subResult = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                    subResult.add(temp.data);
                }
            }
            result.add(subResult);
        }
        return result;
    }

    public void insertDummyNodes() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }


    public static void main(String[] args) {
        CommonUtils commonUtils = new CommonUtils();
//        commonUtils.insertInBT(1);
//        commonUtils.insertInBT(2);
//        commonUtils.insertInBT(3);
//        commonUtils.insertInBT(4);
//        commonUtils.insertInBT(5);
//        commonUtils.insertInBT(6);
//        commonUtils.insertInBT(7);
//        commonUtils.printBinaryTree_levelOrder(commonUtils.root);
//        System.out.println();

        commonUtils.root = new TreeNode(1);
        commonUtils.root.left = new TreeNode(2);
        commonUtils.root.right = new TreeNode(3);
//        commonUtils.root.left.left = new TreeNode(4);
//        commonUtils.root.left.right = new TreeNode(5);
        commonUtils.root.right.left = new TreeNode(6);
        commonUtils.root.right.right = new TreeNode(7);
        commonUtils.printBinaryTree_levelOrder(commonUtils.root);
        System.out.println();

        System.out.println("Number of nodes: " + commonUtils.countNodes_recursion(commonUtils.root));
        System.out.println("Number of nodes iteratively: " + commonUtils.countNodes_iterative(commonUtils.root));

        System.out.println("Height of Binary Tree: " + commonUtils.heightBinaryTree(commonUtils.root));

        System.out.println("Height of Binary Tree iteratively using Stack: " + commonUtils.heightBinaryTree_iterative_stack(commonUtils.root));

        System.out.println("Height of Binary Tree iteratively using Queue: " + commonUtils.heightBinaryTree_iterative_queue(commonUtils.root));

        System.out.println("Height of Binary Tree iteratively using Queue better: " + commonUtils.heightBinaryTree_iterative_queue_better(commonUtils.root));

        System.out.println("Largest Element of Binary Tree: " + commonUtils.largestElement(commonUtils.root));
        System.out.println("Largest Element Iteratively of Binary Tree: " + commonUtils.largestElementIterative(commonUtils.root));
        System.out.println("Leaf Nodes in Binary Tree: " + commonUtils.countLeafNodes(commonUtils.root));

        System.out.println("Leaf Nodes in Binary Tree iteratively: " + commonUtils.countLeafNodes_iterative(commonUtils.root));

        System.out.println("Half Nodes in Binary Tree iteratively: " + commonUtils.countHalfNodes_iterative(commonUtils.root));

        System.out.println("Full Nodes in Binary Tree iteratively: " + commonUtils.countFullNodes_iterative(commonUtils.root));

        System.out.println("Search in Binary Tree: " + commonUtils.searchInTheBinaryTreeRecur(commonUtils.root, 0));

        System.out.println("Search in Binary Tree: " + commonUtils.searchInTheBinaryTreeIteration(commonUtils.root, 7));

        commonUtils.insertInBT(10);

        System.out.println("Half Nodes in Binary Tree iteratively: " + commonUtils.countHalfNodes_iterative(commonUtils.root));

        System.out.print("Print BT with In-Order fashion: ");
        commonUtils.printBinaryTree_inOrder(commonUtils.root);
        System.out.println();
        System.out.print("Print BT with Level-Order fashion: ");
        commonUtils.printBinaryTree_levelOrder(commonUtils.root);
        System.out.println();
        System.out.println("Deepest node in BT is: " + commonUtils.findDeepestNode(commonUtils.root));
    }
}
