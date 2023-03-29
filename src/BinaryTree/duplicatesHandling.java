package BinaryTree;

/**
 * Created by piyush.bajaj on 04/01/17.
 */
public class duplicatesHandling {
    Node root;

    public duplicatesHandling() {
        root = null;
    }

    public duplicatesHandling(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        duplicatesHandling BT = new duplicatesHandling();
        BT.root = BT.insert(BT.root, 12);
        BT.root = BT.insert(BT.root, 10);
        BT.root = BT.insert(BT.root, 12);
        BT.root = BT.insert(BT.root, 5);
        BT.root = BT.insert(BT.root, 13);


        BT.inOrderTraversal(BT.root);

        System.out.println();

        BT.delete(BT.root, 12);

        BT.inOrderTraversal(BT.root);

        System.out.println();

        BT.delete(BT.root, 12);

        BT.inOrderTraversal(BT.root);
    }

    public Node insert(Node key, int data) {
        if (key == null) {
            return new Node(data);
        }

        if (key.data == data) {
            key.count++;
            return key;
        }

        if (data < key.data) {
            key.left = insert(key.left, data);
        } else {
            key.right = insert(key.right, data);
        }
        return key;
    }

    public Node findMax(Node key) {
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


    public Node delete(Node key, int data) {
        if (key == null) {
            return null;
        }
        if (data < key.data && key.left != null) {
            delete(key.left, data);
        } else if (data > key.data && key.right != null) {
            delete(key.right, data);
        } else {
            if (key.count > 1) {
                key.count--;
            }
            //for two nodes
            else if (key.left != null && key.right != null) {
                Node temp = findMax(key.right);
                key.data = temp.data;
                key.right = delete(key.right, data);
            }
            //for 1 node
            else {
                if (key.left == null) {
                    key = key.right;
                    //delete(key.right, data);
                } else if (key.right == null) {
                    key = key.left;
                    //delete(key.left, data);
                }
            }
        }
        return key;
    }


    public void inOrderTraversal(Node key) {
        if (key == null) {
            return;
        }

        inOrderTraversal(key.left);

        System.out.print(key.data + "(" + key.count + ")" + " ");

        inOrderTraversal(key.right);

    }

    public static class Node {
        int data;
        int count;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.count = 1;
            left = right = null;
        }
    }


}
