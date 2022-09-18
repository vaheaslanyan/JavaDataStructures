package com.urartusoftware.structures;

import java.util.NoSuchElementException;

public class CircularQueueStructure {

    private Employee[] queue;
    private int front;
    private int back;

    public CircularQueueStructure(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee emp) {
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArr = new Employee[queue.length * 2];

            // Rearranging the wrapped queue
            // Copying front portion
            System.arraycopy(queue, front, newArr, 0, queue.length - front);
            // Copying back portion
            System.arraycopy(queue, 0, newArr, queue.length - front, back);

            queue = newArr;

            front = 0;
            back = numItems;
        }

        queue[back] = emp;
        if (back < queue.length - 1) back++; else back = 0;
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
        } else if (front == queue.length) {
            front = 0;
        }

        return emp;
    }

    public Employee peek() {
        if (size() == 0) throw new NoSuchElementException();
        return queue[front];
    }

    public int size() {
        if (front <= back) return back - front;
        else return back - front + queue.length;
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }

            for ( int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
