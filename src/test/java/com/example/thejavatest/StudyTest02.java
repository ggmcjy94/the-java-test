package com.example.thejavatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("커스텀 태그")
class StudyTest02 {

    @FastTest
    @DisplayName("스터디 만들기 fast")
//    @Disabled // 실 행 하지 않음
    void create_net_study_01() {
        System.out.println("create1");
    }


    @SlowTest
    @DisplayName("스터디 만들기 slow")
//    @Disabled // 실 행 하지 않음
    void create_net_study_again() {
        System.out.println("create1");
    }


}