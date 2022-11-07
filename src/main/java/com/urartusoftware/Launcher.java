package com.urartusoftware;

import com.urartusoftware.algorithms.MergeSort;
import com.urartusoftware.structures.*;

import java.util.Arrays;

public class Launcher {

    static MergeSort ms = new MergeSort();

    public static void main(String[] args) {
//        int[] intArr = { 20, 35, -15, 7, 55, 1, -22};
//
//        Employee joseph = new Employee("Hoseph", "Kevorkian", 1);
//        Employee savo = new Employee("Saverkis", "Hambardumian", 314);
//        Employee lamish = new Employee("Lamo", "Samo", 412);
//        Employee gago = new Employee("Gago", "Drago", 2);
//        Employee prosht = new Employee("Proshian", "Halkanian", 452);
//
//        ChainedHashtableStructure ht = new ChainedHashtableStructure();
//        ht.put("Hoseph", joseph);
//        ht.put("Saverkis", savo);
//        ht.put("Lamo", lamish);
//        ht.put("Gago", gago);
//
////        ht.printHashtable();
//
//        ht.printHashtable();

        int[] unsortedArr = {7, 12, 5, 2, 6, 1, 63, 0};
        System.out.println(Arrays.toString(ms.mergeSort(unsortedArr)));
    }
}
