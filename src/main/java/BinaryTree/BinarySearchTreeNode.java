package BinaryTree;

/**
 * Created by piyush.bajaj on 22/12/16.
 * <p>
 * isBST can be done using Inorder Traversal:
 * 1.
 */
public class BinarySearchTreeNode {
    Node root;
    int prev = Integer.MIN_VALUE;

    public BinarySearchTreeNode() {
        root = null;
    }

    public BinarySearchTreeNode(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        BinarySearchTreeNode BT = new BinarySearchTreeNode(4);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(6);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(1);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(3);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(5);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println("Were you able to find data in the BST? " + BT.BST_Find(BT.root, 4));

        System.out.println("Were you able to find data in the BST using non-recursive approach? " +
            BT.BST_Find_Non_Recursive(BT.root, 1));

        System.out.println("Minimum element in the BST is: " + BT.findMin_BST(BT.root));

        System.out.println("Minimum element in the BST using Non-Recursion: " + BT.findMin_BST_Non_Recursive(BT.root));

        System.out.println("Maximum element in the BST is: " + BT.findMax_BST(BT.root));

        System.out.println(
            "Maximum element in the BST using Non-Recursion: " + BT.findMax_BST_Non_Recursive(BT.root).data);

        BT.insert_BST(BT.root, 10);

        BT.insert_BST(BT.root, 0);


        System.out.println("After inserting the value in the BST: " + BT.root.right.right.right.data);

        BT.insert_BST_Recursively(BT.root, 10);

        System.out.println(
            "After inserting the value in the BST using non-recursion: " + BT.root.right.right.right.data);

        BT.delete_Node_Recursively(BT.root, 10);

        System.out.println("After deleting the value in the BST using recursion: " + BT.root.right.right.right);

        System.out.println("Is the given Binary Tree is BST? " + BT.isBST(BT.root));

        System.out.println("Is the given Binary Tree is BST using improved time-complexity? "
            + BT.isBST_improved(BT.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println("Is the given Binary Tree is BST using INORDER Traversal with reduced time-complexity? "
            + BT.isBST_Using_InOrder(BT.root));


        BT.printRange(BT.root, 3, 9);


    }

    public boolean BST_Find(Node key, int data) {
        if (key == null) {
            return false;
        }
        if (data < key.data) {
            return BST_Find(key.left, data);
        } else if (data > key.data) {
            return BST_Find(key.right, data);
        }
        return true;
    }

    public boolean BST_Find_Non_Recursive(Node key, int data) {
        if (key == null) {
            return false;
        }
        while (key != null) {
            if (key.data == data) {
                return true;
            } else if (data < key.data) {
                key = key.left;
            } else {
                key = key.right;
            }
        }
        return false;
    }

    public int findMin_BST(Node key) {
        if (key == null) {
            return -1;
        } else if (key.left != null) {
            return findMin_BST(key.left);
        } else {
            return key.data;
        }
    }

    public int findMin_BST_Non_Recursive(Node key) {
        if (key == null) {
            return -1;
        }
        while (key != null) {
            if (key.left != null) {
                key = key.left;
            } else {
                return key.data;
            }
        }
        return -1;
    }

    public int findMax_BST(Node key) {
        if (key == null) {
            return -1;
        } else if (key.right != null) {
            return findMax_BST(key.right);
        } else {
            return key.data;
        }
    }

    public Node findMax_BST_Non_Recursive(Node key) {
        if (key == null) {
            return null;
        }
        while (key != null) {
            if (key.right != null) {
                key = key.right;
            } else {
                return key;
            }
        }
        return null;
    }

    public void insert_BST(Node key, int data) {
        if (key == null) {
            return;
        }
        while (key != null) {
            if (data < key.data) {
                if (key.left != null) {
                    key = key.left;
                } else {
                    key.left = new Node(data);
                    return;
                }
            } else {
                if (key.right != null) {
                    key = key.right;
                } else {
                    key.right = new Node(data);
                    return;
                }
            }
        }
    }

    public void insert_BST_Recursively(Node key, int data) {
        if (key == null) {
            key = new Node(data);
            return;
        } else {
            if (data < key.left.data) {
                insert_BST(key.left, data);
            } else if (data > key.right.data) {
                insert_BST(key.right, data);
            }
        }
        return;
    }

    public Node delete_Node_Recursively(Node key, int data) {
        Node temp;
        if (key == null) {
            System.out.println("Elements are not present in the list");
        }

        if (data < key.data) {
            key.left = delete_Node_Recursively(key.left, data);
        } else if (data > key.data) {
            key.right = delete_Node_Recursively(key.right, data);
        } else {
            if (key.left != null && key.right != null) {
                temp = findMax_BST_Non_Recursive(key.left);
                key.data = temp.data;
                key.left = delete_Node_Recursively(key.left, key.data);
            } else {
                //For 1 node only
                if (key.left == null) {
                    key = key.right;
                }
                if (key.right == null) {
                    key = key.left;
                }
            }
        }
        return key;
    }

    public boolean isBST(Node key) {
        if (key == null) {
            return true;
        }

        if (key.left != null && findMax_BST_Non_Recursive(key.left).data > key.data) {
            return false;
        }

        if (key.right != null && findMax_BST_Non_Recursive(key.right).data < key.data) {
            return false;
        }

        if (!isBST(key.left) || !isBST(key.right)) {
            return false;
        }

        return true;

        //Here the time complexity is O(n*n)
    }

    //Solving BST using InOrder Traversal as we know that InOrder Traversal will give us a sorted list of values while
    // going through BST

    public boolean isBST_improved(Node key, int min, int max) {
        if (key == null) {
            return true;
        }
        return (key.data > min && key.data < max && isBST_improved(key.left, min, key.data) &&
            isBST_improved(key.right, key.data, max));
    }

    public boolean isBST_Using_InOrder(Node key) {
        if (key == null) {
            return true;
        }
        if (!isBST_Using_InOrder(key.left)) {
            return false;
        }
        if (prev > key.data) {
            return false;
        }
        prev = key.data;

        return isBST_Using_InOrder(key.right);

    }

    public void printRange(Node key, int k1, int k2) {
        if (key == null) {
            return;
        }

        if (key.data >= k1 && key.data <= k2) {
            System.out.print(key.data + " ");
        }

        if (key.data >= k1) {
            printRange(key.left, k1, k2);
        }


        if (key.data <= k2) {
            printRange(key.right, k1, k2);
        }
    }

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


}
