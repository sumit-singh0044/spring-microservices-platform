package com.user.userinfo.sampletest;

import org.junit.jupiter.api.*;

public class CalculatorTest {

    @BeforeAll
    public static void init(){
        System.out.println("This method execute before all test cases");
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("This method execute after all test cases");
    }

    @BeforeEach
    public void beforeEachTest(){
        System.out.println("This method execute before each test case");
    }

    @AfterEach
    public void afterEachTest(){
        System.out.println("This method execute after each test case");
    }


    @Test
    @DisplayName("Test for addTwoNumbers method")
    public void addTwoNumbers_Test() {
        System.out.println("First test started");

        int expected_1 = 50;
        int actual_1 = Calculator.addTwoNumbers(10, 40);

        Assertions.assertEquals(expected_1, actual_1);
    }

    @Test
    public void sumAnyNumbers_Test() {

        System.out.println("Second test started");
        int expected_2 = 60;
        int actual_2 = Calculator.addAnyNumber(10, 20, 30);

        Assertions.assertEquals(expected_2, actual_2);
    }


}
