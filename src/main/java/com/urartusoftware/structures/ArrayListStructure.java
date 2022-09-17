package com.urartusoftware.structures;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStructure {

    public void perform() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Jane", "Jones", 123));
        empList.add(new Employee("John", "Doe", 4567));
        empList.add(new Employee("Mary", "Smith", 22));
        empList.add(new Employee("Mike", "WillMadeIt", 3245));
    }
}
