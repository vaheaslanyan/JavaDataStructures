package com.urartusoftware.structures;

public class DoublyLinkedListStructure {

    private EmployeeNodeD head;
    private EmployeeNodeD tail;

    private int size;

    // Methods for adding to the list
    public void addToFront(Employee emp) {
        EmployeeNodeD newNode = new EmployeeNodeD(emp);
        if (head == null) {
            tail = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }

    public void addToEnd(Employee emp) {
        EmployeeNodeD newNode = new EmployeeNodeD(emp);
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
        size++;
    }

    public void addBefore(Employee empToAdd, Employee refEmp) {
        EmployeeNodeD newEmpNode = new EmployeeNodeD(empToAdd);

        EmployeeNodeD currentNode = head;

        if (head.getEmp().equals(refEmp)) {
            addToFront(empToAdd);
            System.out.println("Successfully added: " + newEmpNode.toString());
            return;
        }

        while (currentNode.getNext() != null) {
            EmployeeNodeD nextNode = currentNode.getNext();

            if (nextNode.getEmp().equals(refEmp)) {
                currentNode.setNext(newEmpNode);
                newEmpNode.setPrevious(currentNode);

                nextNode.setPrevious(newEmpNode);
                newEmpNode.setNext(nextNode);

                System.out.println("Successfully added: " + newEmpNode.toString());
                return;
            }

            currentNode = nextNode;
        }

        System.out.println("Could not find node for: " + refEmp.toString());
    }

    // Methods for removing from the list
    public EmployeeNodeD removeFromFront() {
        if (size <= 0) {
            return null;
        }

        EmployeeNodeD removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeNodeD removeFromEnd() {
        if (size <= 0) {
            return null;
        }

        EmployeeNodeD removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    // Other methods
    public void printList() {
        EmployeeNodeD current = head;
        System.out.print("HEAD");

        while (current != null) {
            System.out.print(" -> " + current);
            current = current.getNext();
        }
    }


}

class EmployeeNodeD {

    private Employee emp;

    private EmployeeNodeD next;
    private EmployeeNodeD previous;

    public EmployeeNodeD(Employee emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return emp.toString();
    }

    public EmployeeNodeD getNext() {
        return this.next;
    }

    public EmployeeNodeD getPrevious() {
        return this.previous;
    }

    public void setNext(EmployeeNodeD nextNode) {
        this.next = nextNode;
    }

    public void setPrevious(EmployeeNodeD previousNode) {
        this.previous = previousNode;
    }

    public Employee getEmp() {
        return this.emp;
    }

}