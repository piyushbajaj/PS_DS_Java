package BinaryTree;

/**
 * Created by piyush.bajaj on 26/09/16.
 */
public class BFS {
    static class Node {
        int data;
        Node left, right;

        //boolean visited = false;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree(int key) {
            root = new Node(key);
        }

        BinaryTree() {
            root = null;
        }

        /* Driver program to LinkedList.test above functions */
        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);

            System.out.println("Level order traversal of binary tree is ");
            tree.printLevelOrder();
        }

        /* Compute the "height" of a tree -- the number of
        nodes along the longest path from the root node
        down to the farthest leaf node.*/

        /*
        Algorithm for calculating Height:
        1. if root == null, then 0
        2. left = height(root.left)
        3. right = height(root.right)
        4. if(left > right)
            return left + 1;
        5. else return right + 1;
         */

        void printLevelOrder() {
            int h = height(root);
            int i;
            for (i = 1; i <= h; i++) {
                printGivenLevel(root, i);
            }
        }

        int height(Node root) {
            if (root == null) {
                return 0;
            } else {
                /* compute  height of each subtree */
                int lheight = height(root.left);
                int rheight = height(root.right);

                /* use the larger one */
                if (lheight > rheight) {
                    return (lheight + 1);
                } else {
                    return (rheight + 1);
                }
            }
        }

//        private Queue<Integer> queue;
//
//        public void BFS(){
//            queue = new LinkedList.LinkedList<Integer>();
//        }
//
//        public void search(Node Nd){
//            int num_of_nodes = height(Nd);
//            Queue<Integer> Que = new Queue<Integer>() {
//            }
//
//        }

        /* Print nodes at the given level */
        void printGivenLevel(Node root, int level) {
            if (root == null) {
                return;
            }
            if (level == 1) {
                System.out.print(root.data + " ");
                return;
            } else if (level > 1) {
                printGivenLevel(root.left, level - 1);
                printGivenLevel(root.right, level - 1);
            }
        }
    }
}
