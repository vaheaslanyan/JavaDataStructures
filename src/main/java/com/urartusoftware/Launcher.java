package com.urartusoftware;

import com.urartusoftware.structures.*;

public class Launcher {

    public static void main(String[] args) {
        int[] intArr = { 20, 35, -15, 7, 55, 1, -22};

        Employee joseph = new Employee("Hoseph", "Kevorkian", 1);
        Employee savo = new Employee("Saverkis", "Hambardumian", 314);
        Employee lamish = new Employee("Lamo", "Samo", 412);
        Employee gago = new Employee("Gago", "Drago", 2);
        Employee prosht = new Employee("Proshian", "Halkanian", 452);

        CircularQueueStructure aq = new CircularQueueStructure(10);
        aq.add(joseph);
        aq.add(savo);
        aq.add(lamish);
        aq.add(gago);
        aq.add(prosht);

//        aq.printQueue();

        aq.remove();
        aq.remove();

        aq.printQueue();

        System.out.println(aq.peek());
    }
}
