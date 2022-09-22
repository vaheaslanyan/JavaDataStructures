package com.urartusoftware.structures;

import java.util.*;

public class ChainedHashtableStructure {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtableStructure() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee emp) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, emp));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();

        StoredEmployee emp = null;

        while (iterator.hasNext()) {
            emp = iterator.next();
            if (emp.key.equals(key)) {
                return emp.emp;
            }
        }

        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();

        StoredEmployee emp = null;

        while (iterator.hasNext()) {
            emp = iterator.next();
            if (emp.key.equals(key)) {
                break;
            }
        }

        if (emp == null || !emp.key.equals(key)) {
            return null;
        } else {
            hashtable[hashedKey].remove(emp);
            return emp.emp;
        }
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
            } else {
                System.out.print("Position " + i + ": ");

                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while(iterator.hasNext()) {
                    System.out.print(" -> " + iterator.next().emp);
                }

                System.out.println("null");
            }
        }
    }

}
