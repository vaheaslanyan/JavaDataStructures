package com.urartusoftware.structures;

// MANUAL implementation, JDK Class exists.
public class SinglyLinkedListStructure {

    private EmployeeNode head;

    private int size;

    public void addToFront(Employee emp) {
        EmployeeNode node = new EmployeeNode(emp);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFromFront() {

        if (head != null) {
            EmployeeNode temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;

            return temp;
        }

        return null;
    }


    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD");

        while (current != null) {
            System.out.print(" -> " + current);
            current = current.getNext();
        }
    }

    public int getSize(){
        return size;
    }
}

class EmployeeNode {

    private Employee emp;
    private EmployeeNode next;

    public EmployeeNode(Employee emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return emp.toString();
    }

    // Getters and Setters
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }
}
