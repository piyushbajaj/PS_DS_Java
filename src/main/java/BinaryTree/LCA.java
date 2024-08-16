package BinaryTree;

/**
 * Created by piyush.bajaj on 21/03/17.
 * This is 3 step process;
 * 1. First create find node function, which will take input as int, and give output as Node.
 * a. public void findNode(int temp){
 * Node key = root;
 * if(temp == key.data)
 * return key;
 * else if(temp < key.data)
 * findNode(key.left);
 * else if(temp > key.data)
 * findNode(key.right);
 * else
 * return null;
 * }
 * 2. public int findLCA(int val1, int val2, Node key){
 * a. if(key==null)
 * return;
 * b. if(val1 > val2) then swap(val1, val2);
 * c. Node key1 = findNode(val1);
 * if(key1!=null){
 * Node key2 = findNode(val2);
 * if(key2!=null){
 * return findLCA(Node key1, Node key2, Node key).data;
 * }
 * else
 * return -1;
 * }
 * else
 * return -1;
 * }
 * 3. pubic Node findLCA(Node key1, Node key2, Node key){
 * Node lcaNode;
 * if(key1.data == key.data || key2.data == key.data)
 * return key;
 * else if(key1.data < key.data && key2.data > key.data)
 * return key;
 * else if(key2.data < key.data){
 * lcaNode = findLCA(key1, key2, key.left);
 * }
 * else
 * lcaNode =  findLCA(key1, key2, key.right);
 * <p>
 * return lcaNode;
 * }
 * Time Complexity: O(log(n))
 */
public class LCA {
    Node root;

    public static void main(String[] args) {
        LCA PO = new LCA();
        PO.push(4);
        PO.push(2);
        PO.push(1);
        PO.push(3);
        PO.push(6);
        PO.push(5);
        PO.push(7);

        PO.printList(PO.root);
        System.out.println();

        System.out.println("Please check LCA: ");
        System.out.println(PO.findLCA(PO.root, 6, 7));


        System.out.println(PO.findLca_prac(PO.root, 1, -10).data);
    }

    public void push(int val) {
        Node new_node = new Node(val);
        if (root == null) {
            root = new_node;
            return;
        }

        Node temp = root;

        while (temp != null) {
            if (val < temp.data) {
                if (temp.left == null) {
                    temp.left = new_node;
                    return;
                } else {
                    temp = temp.left;
                }
            } else if (val > temp.data) {
                if (temp.right == null) {
                    temp.right = new_node;
                    return;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    //InorderTraversal
    public void printList(Node key) {
        if (key == null) {
            return;
        }

        printList(key.left);
        System.out.print(key.data + " ");
        printList(key.right);
    }

    public Node findLCA(Node key, Node key1, Node key2) {
        if (key == null) {
            return null;
        }


        if (key.data == key1.data || key.data == key2.data) {
            return key;
        } else if (key1.data < key.data && key2.data > key.data) {
            return key;
        }

        //both keys are in the left side
        Node lcaNode;
        if (key2.data < key.data) {
            lcaNode = findLCA(key.left, key1, key2);
            //findLCA(key.left, key1, key2);
        } else {
            lcaNode = findLCA(key.right, key1, key2);
            //findLCA(key.right, key1, key2);
        }

        return lcaNode;
    }

    public int findLCA(Node key, int val1, int val2) {
        if (val1 > val2) {
            int temp = val1;
            val1 = val2;
            val2 = temp;
        }

        Node n1 = findNodes(key, val1);
        if (n1 != null) {
            Node n2 = findNodes(key, val2);
            if (n2 != null) {
                return findLCA(key, n1, n2).data;
            }
        }

        return -1;


    }

    public Node findNodes(Node key, int val) {
        if (key == null) {
            return null;
        }

        if (key.data == val) {
            return key;
        }

        if (val < key.data) {
            return findNodes(key.left, val);
        } else {
            return findNodes(key.right, val);
        }


    }

    public Node findLca_prac(Node key, int a, int b) {
        if (key == null) {
            return null;
        }

        if (key.data > a && key.data > b) {
            return findLca_prac(key.left, a, b);
        } else if (key.data < a && key.data < b) {
            return findLca_prac(key.right, a, b);
        }

        return key;
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
