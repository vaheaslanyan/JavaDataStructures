package com.urartusoftware.structures;

import java.util.NoSuchElementException;

public class ArrayQueueStructure {

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueueStructure(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee emp) {
        if (back == queue.length) {
            Employee[] newArr = new Employee[queue.length * 2];
            System.arraycopy(queue, 0, newArr, 0, queue.length);
            queue = newArr;
        }

        queue[back] = emp;
        back++;
    }

    public Employee remove() {
        if (size() ==0) {
            throw new NoSuchElementException();
        }

        Employee emp = queue[front];
        queue[front] = null;
        front++;

        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return emp;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

}
