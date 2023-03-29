package Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Project: DS_Algo
 * Package: Test
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 3:24 pm
 */
public class ConsistentHash {

    private final int numberOfServers = 4;
    private final Map<String, Integer> treeMap = new TreeMap<>();

    ConsistentHash(final List<String> servers) {
        for (String server : servers) {
            put(server);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("MD5");
        MessageDigest m = MessageDigest.getInstance("MD5");
        List<String> listServers = new ArrayList<>();
        listServers.add("s1");
        listServers.add("s2");
        listServers.add("s3");
        listServers.add("s4");

        ConsistentHash consistentHash = new ConsistentHash(listServers);

        consistentHash.put("Jim");
        System.out.println(consistentHash.get("Jim"));


    }

    public void put(String key) {
        int serverNumber = Integer.parseInt(getMd5(key)) * numberOfServers;

        for (int i = 0; i < numberOfServers; i++) {
            treeMap.put(getMd5(key), serverNumber);
        }
    }

    // Input here is user name
    public String get(String key) {
        if (treeMap.isEmpty()) {
            return null;
        }

        String hashValue = getMd5(key);

        if (!treeMap.containsKey(hashValue)) {
            return "Key is not present";
        }
//        return treeMap.get(hashValue);
        return null;
    }

    public void delete(String key) {
        for (int i = 0; i < numberOfServers; i++) {
            treeMap.remove(getMd5(key), key);
        }
    }

    public String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
