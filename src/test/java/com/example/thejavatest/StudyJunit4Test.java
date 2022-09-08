package com.example.thejavatest;

import org.junit.Before;
import org.junit.Test;

public class StudyJunit4Test {

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void test1() {
        System.out.println("test");
    }
}
