package TakeUForward.S17_Tries;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S17_Tries
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 12:01 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/count-of-distinct-substrings/1">...</a>
 * Youtube: <a href="https://youtu.be/RV0QeTyHZxo">...</a>
 */
public class P4_Count_Distinct_Substrings {
    static class Node {
        Node[] links = new Node[26];

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }
    }

    /**
     * TC: O(N*N)
     * SC: O(N*26)
     *
     * @param st
     * @return
     */
    public int countDistinctSubstring(String st) {
        int count = 0;
        Node root = new Node();

        for (int i = 0; i < st.length(); i++) {
            Node node = root;
            for (int j = i; j < st.length(); j++) {
                if (!node.containsKey(st.charAt(j))) {
                    node.put(st.charAt(j), new Node());
                    count++;
                }
                node = node.get(st.charAt(j));
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        P4_Count_Distinct_Substrings p4_count_distinct_substrings = new P4_Count_Distinct_Substrings();
        System.out.println(p4_count_distinct_substrings.countDistinctSubstring("ababa"));
    }
}
