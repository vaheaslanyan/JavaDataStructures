package com.urartusoftware.structures;

import java.util.EmptyStackException;

public class ArrayStackStructure {

    private Employee[] stack;

    // top is not the top element but rather the empty space above it
    private int top;

    public ArrayStackStructure(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee emp) {
        if (top == stack.length) {
            // Resizing the backing array
            Employee[] newArray = new Employee[stack.length * 2];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
        }

        stack[top++] = emp;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Employee emp = stack[--top];
        stack[top] = null;
        return emp;
    }

    public Employee peak() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public void printStack() {
        for (int i = top - 1; i > 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public boolean isEmpty() {
        return top == 0;
    }

}
