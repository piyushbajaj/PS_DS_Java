package TakeUForward.S15_Graphs.S15_5_MST_DisjointSet;

import java.util.ArrayList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_5_Minimum_Spanning_Tree
 * <p>
 * User: piyushbajaj
 * Date: 08/11/22
 * Time: 1:33 pm
 *
 * Link: <a href="https://practice.geeksforgeeks.org/problems/connecting-the-graph/1">...</a>
 */
public class P2_Disjoint_Set {

    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    /**
     * TC: O(4*alpha): O(1)
     *
     * @param n
     */
    public P2_Disjoint_Set(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ultParent = findUParent(parent.get(node));
        parent.set(node, ultParent);
        return parent.get(node);
    }

    public void unionByRank(int x, int y) {
        int ultParentX = findUParent(x);
        int ultParentY = findUParent(y);

        if (ultParentX == ultParentY) {
            return;
        }

        if (rank.get(ultParentX) < rank.get(ultParentY)) {
            parent.set(ultParentX, ultParentY);
        } else if (rank.get(ultParentY) < rank.get(ultParentX)) {
            parent.set(ultParentY, ultParentX);
        } else {
            parent.set(ultParentY, ultParentX);
            rank.set(ultParentX, rank.get(ultParentX) + 1);
        }
    }

    public void unionBySize(int x, int y) {
        int ultParentX = findUParent(x);
        int ultParentY = findUParent(y);

        if (ultParentX == ultParentY) {
            return;
        }

        if (size.get(ultParentX) < size.get(ultParentY)) {
            parent.set(ultParentX, ultParentY);
            size.set(ultParentY, size.get(ultParentY) + 1);
        } else {
            parent.set(ultParentY, ultParentX);
            size.set(ultParentX, size.get(ultParentX) + 1);
        }
    }

    public static void main(String[] args) {
        P2_Disjoint_Set p2_disjoint_set = new P2_Disjoint_Set(7);
//        p2_disjoint_set.unionByRank(1, 2);
//        p2_disjoint_set.unionByRank(2, 3);
//        p2_disjoint_set.unionByRank(4, 5);
//        p2_disjoint_set.unionByRank(6, 7);
//        p2_disjoint_set.unionByRank(5, 6);

//        if (p2_disjoint_set.findUParent(3) == p2_disjoint_set.findUParent(7)) {
//            System.out.println("Same");
//        } else {
//            System.out.println("Not Same");
//        }
//
//        p2_disjoint_set.unionByRank(3, 7);
//
//        if (p2_disjoint_set.findUParent(3) == p2_disjoint_set.findUParent(7)) {
//            System.out.println("Same");
//        } else {
//            System.out.println("Not Same");
//        }

        p2_disjoint_set.unionBySize(1, 2);
        p2_disjoint_set.unionBySize(2, 3);
        p2_disjoint_set.unionBySize(4, 5);
        p2_disjoint_set.unionBySize(6, 7);
        p2_disjoint_set.unionBySize(5, 6);

        if (p2_disjoint_set.findUParent(3) == p2_disjoint_set.findUParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        p2_disjoint_set.unionBySize(3, 7);

        if (p2_disjoint_set.findUParent(3) == p2_disjoint_set.findUParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
