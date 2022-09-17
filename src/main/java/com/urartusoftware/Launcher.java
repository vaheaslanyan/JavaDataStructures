package com.urartusoftware;

import java.util.Arrays;
import com.urartusoftware.algorithms.*;
import com.urartusoftware.structures.*;
import com.urartusoftware.structures.DoublyLinkedListStructure;

public class Launcher {

    static BubbleSort bs = new BubbleSort();
    static SelectionSort ss = new SelectionSort();

    public static void main(String[] args) {
        int[] intArr = { 20, 35, -15, 7, 55, 1, -22};

        isPalindrome("1001");


    }

    public static void isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^A-Za-z]", "").toLowerCase();
        LinkedStackStructure halfStack = new LinkedStackStructure();

        int i = 0;

        for (char c : cleanedStr.toCharArray()) {
            if (cleanedStr.length() % 2 != 0 && i == cleanedStr.length() / 2) {
                i++;
                continue;
            }
            if (i < cleanedStr.length() / 2) {
                halfStack.push(c);
            } else if (halfStack.isEmpty() || halfStack.pop() != c) {
                System.out.println("String is NOT palindrome!");
                return;
            }
            i++;
        }

        System.out.println("String IS palindrome!");

    }
}
