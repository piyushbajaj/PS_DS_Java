package Flipkart_test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by piyush.bajaj on 11/06/18.
 */
public class Bill {
    private String billId;
    private int totalAmt;
    private String groupId;

    HashMap<String, Integer> hashMap_contribution = new HashMap<>();

    HashMap<String, HashMap<String, Integer>> hashMap_groupwise = new HashMap<>();

    public Bill(){

    }

    public Bill(String newBillId, Integer newTotalAmt, String newGroupId){

    }


    public void addBill(String groupId, String personId, Integer share){
        hashMap_contribution.clear();
        hashMap_contribution.put(personId, share);
        hashMap_groupwise.put(groupId, hashMap_contribution);
    }


    public void paidByBill(String groupId, String[] people, Integer[] share){
        int n = people.length;

        for(int i = 0; i < n; i++){
            if(!hashMap_groupwise.isEmpty()){
                int person_shareAmnt = hashMap_groupwise.get(groupId).get(people[i]);
                int calculate = share[i] - person_shareAmnt;
                hashMap_contribution.put(people[i], calculate);
                //hashMap_groupwise.put(groupId,  )
            }
        }
    }

    public void calculateShares(String groupId, String PaidBy, int Amount){
        for(Map.Entry<String, HashMap<String, Integer>> entry: hashMap_groupwise.entrySet() ){
            String key = entry.getKey();
            if(key.equals(groupId)){
                HashMap<String, Integer> value = entry.getValue();
                if(value.containsKey(PaidBy)){

                }
                for(Map.Entry<String, Integer> entryCheck: value.entrySet() ){
                    String keyt = entry.getKey();
                    if(keyt.equals(PaidBy)){

                    }
                }

            }




        }
    }


}
