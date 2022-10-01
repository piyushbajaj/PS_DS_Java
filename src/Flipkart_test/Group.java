package Flipkart_test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by piyush.bajaj on 11/06/18.
 */
public class Group {
    private String id;
    private String name;
    private ArrayList<String> people = new ArrayList<>();

    private HashMap<String, ArrayList<String>> hashMapPersontoGroup = new HashMap<>();

    public Group(){

    }

    public Group(String newId, String newName, ArrayList<String> people,
                 HashMap<String, String> person_group){
        this.id = newId;
        this.name = newName;

        for(String str: people){
            if(person_group.get(str).isEmpty()){
                return;
            }
            else {
                hashMapPersontoGroup.put(newId, people);
            }
        }

        //this.hashMapPersontoGroup()
    }

    public HashMap<String, ArrayList<String>> addPersonToGroup(String strGrpId, ArrayList<String>
            groupPeople){


//        int n = strGrpId.length;
//
//        for(int i = 0; i < n; i++) {
//            hashMapPersontoGroup.put(strGrpId[i], groupPeople);
//            //new LinkedList.Person(strEmailId[i], strName[i]);
//        }
        hashMapPersontoGroup.put(strGrpId, groupPeople);


        return hashMapPersontoGroup;
    }
}
