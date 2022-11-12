package TakeUForward.S15_Graphs.S15_5_MST_DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_5_MST_DisjointSet
 * <p>
 * User: piyushbajaj
 * Date: 09/11/22
 * Time: 7:11 pm
 */
public class P6_Account_Merge {

    /**
     * TC: O(N*M*logN)
     *
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, Integer> accountsMap = new HashMap<>();

        List<List<String>> result = new ArrayList<>();

        P2_Disjoint_Set disjoint_set = new P2_Disjoint_Set(n);

        // O(N*M)
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (!accountsMap.containsKey(accounts.get(i).get(j))) {
                    accountsMap.put(accounts.get(i).get(j), i);
                } else {
                    disjoint_set.unionBySize(accountsMap.get(accounts.get(i).get(j)), i);
                }
            }
        }

        // Using this, so list can be sorted
        List<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> integerMap : accountsMap.entrySet()) {
            int ultParent = disjoint_set.findUParent(integerMap.getValue());
            mergedMail[ultParent].add(integerMap.getKey());
        }

        // O(N*mlogM)
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) {
                continue;
            }

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();

            // Adding account name on first
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail[i]);

            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        P6_Account_Merge account_merge = new P6_Account_Merge();

        List<List<String>> accounts =
            Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
            );

        System.out.println(account_merge.accountsMerge(accounts));
    }
}
