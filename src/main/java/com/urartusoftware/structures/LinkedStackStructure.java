package com.urartusoftware.structures;

import java.util.LinkedList;
import java.util.ListIterator;

// We are simply using Dequeue based LinkedList and turning it into a stack
// giving only stack functionality to the structure
public class LinkedStackStructure {

    private LinkedList<Character> stack;

    public LinkedStackStructure() {
        stack = new LinkedList<Character>();
    }

    public void push(Character c) {
        stack.push(c);
    }

    public char pop() {
        return stack.pop();
    }

    public char peak() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Character> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
