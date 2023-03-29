package Flipkart_test;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 11/06/18.
 */
public class Person {
    HashMap<String, String> hashMapPerson = new HashMap<>();
    private String name;
    private String emailId;

    public Person() {
    }

    public Person(String newName, String newEmailId) {
        this.name = newName;
        this.emailId = newEmailId;
        //hashMapPerson.put(this.emailId, this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getEmailId() {
        return emailId;
    }

    ;

    public void setEmailId(String newEmailId) {
        emailId = newEmailId;
    }

    public HashMap<String, String> addPerson(String[] strName, String[] strEmailId) {
        if (strName.length != strEmailId.length) {
            return null;
        }

        int n = strName.length;

        for (int i = 0; i < n; i++) {
            hashMapPerson.put(strEmailId[i], strName[i]);
            //new LinkedList.Person(strEmailId[i], strName[i]);
        }

        return hashMapPerson;
    }


}
