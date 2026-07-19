package com.user.userinfo.sampletest;

public class Calculator {

    public static int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public static int subtractTwoNumbers(int a, int b) {
        return a - b;
    }

    public static int multiplyTwoNumbers(int a, int b) {
        return a * b;
    }

    public static int divideTwoNumbers(int a, int b) {
        return a / b;
    }

    public static int addAnyNumber(int ... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
