package com.example.thejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("테스트 반복")
class StudyTest03 {

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

    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void create_study(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition() +"/" + repetitionInfo.getTotalRepetitions());
    }

    @ParameterizedTest
    @ValueSource(strings = {"날씨가", "많이", "추워지고","있네요."})
    void parameterizedTest(String message) {
        System.out.println(message);
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고","있네요."})
    void parameterizedTest2(String message) {
        System.out.println(message);
    }
}