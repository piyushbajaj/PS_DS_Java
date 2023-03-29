package TechBoost_Old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by piyush.bajaj on 29/04/18.
 */
public class nArray_Prob {


    public static boolean check_Equal(HashMap<Integer, ArrayList<Integer>> hashMap1,
                                      HashMap<Integer, ArrayList<Integer>> hashMap2) {
        int n1 = hashMap1.size();
        int n2 = hashMap2.size();

        if (n1 == 0 && n2 == 0) {
            return true;
        }

        if (n1 != n2) {
            return false;
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry1 : hashMap1.entrySet()) {
            int key = entry1.getKey();
            ArrayList<Integer> arrayList1 = entry1.getValue();
            ArrayList<Integer> arrayList2 = hashMap2.get(key);

            if (arrayList1.size() == 0) {
                continue;
            }

            if (is_lists_equal(arrayList1, arrayList2)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean is_lists_equal(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        Collections.sort(arr1);
        Collections.sort(arr2);

        return arr1.equals(arr2);
    }

    public static void printTree(HashMap<Integer, ArrayList<Integer>> hashMap) {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue());

            System.out.println();
        }
    }

    public static void add(HashMap<Integer, ArrayList<Integer>> hashMap, int value, int newValue) {
        if (hashMap.containsKey(value)) {
            ArrayList<Integer> arrayList = hashMap.get(value);
            arrayList.add(newValue);
            hashMap.put(value, arrayList);
        }
    }

    public static void delete(HashMap<Integer, ArrayList<Integer>> hashMap, int parent, int child) {
        if (child == -1) {
            if (hashMap.containsKey(parent)) {
                //Deleting Node from inside the main ArrayList
                for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
                    if (entry.getValue().contains(parent)) {
                        ArrayList<Integer> arrayList = entry.getValue();
                        arrayList.remove(arrayList.indexOf(parent));
                    }
                }


                //Deleting Nodes
                ArrayList<Integer> arrayList = hashMap.get(parent);
                hashMap.remove(parent);
                //for(Integer num: arrayList){
                int j = 0;
                int n = arrayList.size();
                while (j < n) {
                    n = arrayList.size();
                    int num = arrayList.get(j);
                    if (hashMap.containsKey(num)) {
                        ArrayList<Integer> arrayList_child = hashMap.get(num);
                        if (arrayList_child.size() > 0) {
                            for (int i = 0; i < arrayList_child.size(); i++) {
                                if (!arrayList.contains(arrayList_child.get(i))) {
                                    arrayList.add(arrayList_child.get(i));
                                }
                            }
                        }
                        //arrayList.addAll(arrayList_child);
                    }
                    j++;
                }

                for (Integer num : arrayList) {
                    hashMap.remove(num);
                }

            }
        } else {


            if (parent == child) {
                return;
            }
            if (hashMap.containsKey(parent) && hashMap.containsKey(child)) {
                ArrayList<Integer> arrayList = hashMap.get(parent);
                if (arrayList.contains(child)) {
                    int index = arrayList.indexOf(child);
                    arrayList.remove(index);
                    arrayList.addAll(new ArrayList<>(hashMap.get(child)));
                    hashMap.remove(child);
                }
            }
        }
    }


    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> hashMap1 = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> hashMap2 = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> hashMap3 = new HashMap<>();

        //String jsonObject ="{\n\n\n {\n \"id\": 22,\n\"menu_id\": 1,\n \"field_type_id\": 1,\n\"c4w_code\": \"1234\",\n\"field_label\": \"Customer No\",\n\"field_values\": \"\",\n\"date_Created\": \"2012-09-16 05:11:23\",\n\"date_modified\": \"2013-11-20 10:33:23\",\n\"is_required\":0,\n\"is_static\": 1,\n\"field_order\": 1\n},\n{\n\"id\":23,\n\"menu_id\": 1,\n\"field_type_id\": 1,\n\"c4w_code\": \"1234\",\n\"field_label\": \"Company Name\",\n\"field_values\": \"\",\n\"date_Created\": \"2012-09-16 05:11:56\",\n\"date_modified\": \"2013-11-20 10:33:23\",\n\"is_required\": 1,\n\"is_static\": 1,\n\"field_order\": 3\n}\n\n}";

        hashMap1.put(1, new ArrayList<>(Arrays.asList(2, 3)));
        hashMap1.put(2, new ArrayList<>(Arrays.asList(4, 5)));
        hashMap1.put(3, new ArrayList<>(Arrays.asList()));
        hashMap1.put(4, new ArrayList<>(Arrays.asList()));
        hashMap1.put(5, new ArrayList<>(Arrays.asList()));

        hashMap2.put(1, new ArrayList<>(Arrays.asList(2, 3)));
        hashMap2.put(2, new ArrayList<>(Arrays.asList(5, 4)));
        hashMap2.put(3, new ArrayList<>(Arrays.asList()));
        hashMap2.put(4, new ArrayList<>(Arrays.asList()));
        hashMap2.put(5, new ArrayList<>(Arrays.asList()));

        hashMap3.put(1, new ArrayList<>(Arrays.asList(2, 3, 4)));
        hashMap3.put(2, new ArrayList<>(Arrays.asList(5, 6)));
        hashMap3.put(3, new ArrayList<>(Arrays.asList()));
        hashMap3.put(4, new ArrayList<>(Arrays.asList()));
        hashMap3.put(5, new ArrayList<>(Arrays.asList()));
        hashMap3.put(6, new ArrayList<>(Arrays.asList()));

        System.out.println(check_Equal(hashMap1, hashMap2));

        printTree(hashMap3);

        add(hashMap3, 2, 4);
        printTree(hashMap3);

        delete(hashMap3, 1, 3);
        printTree(hashMap3);

        delete(hashMap3, 1, -1);
        printTree(hashMap3);


    }
}
