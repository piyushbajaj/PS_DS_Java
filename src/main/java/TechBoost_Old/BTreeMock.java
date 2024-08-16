package TechBoost_Old;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 07/06/18.
 */
public class BTreeMock {
    BTNode root;

    ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        BTreeMock BT = new BTreeMock();


        String[] arr = {"1L2R5L6", "1R3R4R8", "1R3R4L7"};
        BT.constructTree(arr);
        int height = BT.height_recur(BT.root);
        BT.createDummyNode(BT.root, 1, height);
        System.out.println("Printing Level Order Traversal level by level: ");
        ArrayList<ArrayList<Integer>> arrayLists = BT.print_level_by_level_better(BT.root);
        System.out.println();
        System.out.println("Maximum width in a Binary Tree is: " + BT.maxWidth(arrayLists));
    }

    public void levelOrder_iterative(BTNode key) {
        if (key == null) {
            return;
        }

        Queue<BTNode> queue = new LinkedList<BTNode>();
        queue.add(key);

        while (!queue.isEmpty()) {
            BTNode temp = queue.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }


    public ArrayList<ArrayList<Integer>> print_level_by_level_better(BTNode key) {
        if (key == null) {
            return null;
        }


        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        Queue<BTNode> queue1 = new LinkedList<>();
        BTNode curr = null;
        queue1.add(key);
        queue1.add(null);

        while (!queue1.isEmpty()) {
            if (queue1.size() == 1 && queue1.peek() == null) {
                break;
            }
            curr = queue1.remove();
            if (curr == null) {
                queue1.add(null);
                System.out.println();
                arr.add(arrayList);
                arrayList = new ArrayList<>();
                //arrayList.clear();
//                arr.add(new ArrayList<>());
            } else {
                System.out.print(curr.data + " ");

                arrayList.add(curr.data);
                if (curr.left != null) {
                    queue1.add(curr.left);
                }
                if (curr.right != null) {
                    queue1.add(curr.right);
                }
            }
        }
        arr.add(arrayList);

        return arr;

    }

    public BTNode constructTree(String[] arr) {
        BTNode key = root;
        boolean lFlag = false;
        boolean rFlag = false;
        for (String str : arr) {
            int strLen = str.length();
            key = root;
            for (int i = 0; i < strLen; i++) {
                if (i % 2 == 0) {
                    int value = Integer.parseInt(String.valueOf(str.charAt(i)));
                    if (!(value >= -1 && value <= 9)) {
                        System.out.println("Invalid input");
                        break;
                    }
                    if (root == null) {
                        root = new BTNode(value);
                        key = root;
                        //return key;
                    }
//                    else if(root.data == value) {
//
//                        continue;
//                    }
                    else if (lFlag) {
                        if (key.left == null || key.left.data == -1) {
                            key.left = new BTNode(value);
                        }
//                        else if(key.left!=null && key.left.data != -1)
//                            continue;
                        if (key.right == null) {
                            key.right = new BTNode(-1);
                        }

                        key = key.left;
                        lFlag = false;
                        //return key;
                    } else if (rFlag) {
                        if (key.left == null) {
                            key.left = new BTNode(-1);
                        }
                        //key.right = new BTNode(value);
                        if (key.right == null || key.right.data == -1) {
                            key.right = new BTNode(value);
                        }
//                        else if(key.right!=null && key.right.data != -1)
//                            continue;

                        key = key.right;
                        rFlag = false;
                        //return key;
                    }
                } else {
                    if (str.charAt(i) == 'L') {
                        lFlag = true;
                        rFlag = false;
                        //key = key.left;
                    } else if (str.charAt(i) == 'R') {
                        lFlag = false;
                        rFlag = true;
                        //key = key.right;
                    } else {
                        System.out.println("Invalid input");
                        break;
                    }
                }
            }
        }
        return root;
    }

    public int height_recur(BTNode key) {
        if (key == null) {
            return 0;
        }

        int hleft = height_recur(key.left);
        int hright = height_recur(key.right);

        return Math.max(hleft, hright) + 1;
    }


    public BTNode createDummyNode(BTNode key, int size, int height) {
        if (key == null) {
            return null;
        }

        if (size < height) {
            if (key.data == -1) {
                key.left = new BTNode(-1);
                key.right = new BTNode(-1);
            }
            createDummyNode(key.left, size + 1, height);
            createDummyNode(key.right, size + 1, height);
        }


        return root;
    }


    public int maxWidth(ArrayList<ArrayList<Integer>> arr) {

        int count = 0, max = 0;

        for (ArrayList<Integer> arrayList : arr) {
            int start = -1;
            int end = -1;
            int i = 0;
            while (start <= end) {

                if (arrayList.get(i) >= 0 && start == -1) {
                    start = i;
                }
                if (arrayList.get(arrayList.size() - 1 - i) >= 0 && end == -1) {
                    end = arrayList.size() - 1 - i;
                }
                if (start != -1 && end != -1) {
                    count = end - start + 1;
                    break;
                }
                i++;
            }
            if (count > max) {
                max = count;
            }
            count = 0;
        }
        return max;
    }

    static class BTNode {
        BTNode left, right;
        int data;

        BTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
