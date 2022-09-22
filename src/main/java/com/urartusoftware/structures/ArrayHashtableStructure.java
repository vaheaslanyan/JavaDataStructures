package com.urartusoftware.structures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class ArrayHashtableStructure {

    private StoredEmployee[] hashtable;

    public ArrayHashtableStructure() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
     int hashedKey = hashKey(key);

     // Linear Probing
     if (occupied(hashedKey)) {
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while(occupied(hashedKey) && hashedKey != stopIndex) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

     }

     if (occupied(hashedKey)) {
         System.out.println("Duplicate hashed key " + hashedKey);
     } else {
         hashtable[hashedKey] = new StoredEmployee(key, employee);
     }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].emp;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        Employee emp = hashtable[hashedKey].emp;
        hashtable[hashedKey] = null;

        // Rehashing
        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];

        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].emp);
            }
        }

        return emp;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        // Linear Probing
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return  hashedKey;
        } else {
            return -1;
        }
    }

    // Terrible hashing example
    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }


    public void printHashtable() {
        for (StoredEmployee e : hashtable) {
            if (e == null) {
                System.out.println("empty");
            } else {
                System.out.print("Key: " + e.key + "; Value: ");
                System.out.println(e.emp);
            }
        }
    }

}

class StoredEmployee {
    public String key;
    public Employee emp;

    public StoredEmployee(String key, Employee emp) {
        this.key = key;
        this.emp = emp;
    }
}

