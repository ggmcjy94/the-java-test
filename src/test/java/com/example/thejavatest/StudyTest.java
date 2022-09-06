package com.example.thejavatest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    @EnabledOnJre({JRE.JAVA_8,JRE.JAVA_9,JRE.JAVA_10,JRE.JAVA_11, JRE.JAVA_18})
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void create_new_study02() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));
//        Assumptions.assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
//            System.out.println("local");
//            Study actual = new Study(100);
//            assertThat(actual.getLimit()).isGreaterThan(0);
//        });
    }


    @Test
    @DisplayName("스터디 만들기")
    @DisabledOnOs(OS.MAC)
    void create_new_study() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        }); // TODO ThreadLocal 을 사용 시 예상치 못한 변수가 나올수 있음 assertTimeoutPreemptively 테스트시
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());
//        assertAll(
//                () -> assertNotNull(study),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),
//                ()-> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
//        );
        assertTrue(1 < 2);
        assertNull(null);
    }


    @Test
    @Tag("fast")
    @DisplayName("스터디 만들기 fast")
//    @Disabled // 실 행 하지 않음
    void create_net_study_01() {
        System.out.println("create1");
    }

    @Test
    @Tag("slow")
    @DisplayName("스터디 만들기 slow")
//    @Disabled // 실 행 하지 않음
    void create_net_study_again() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll 전체 테스트 실행전 한번");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("afterAll 전체 테스트 실행후 한번");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach 테스트 메소드 실행전에 실행");
    }
    @AfterEach
    void afterEach() {
        System.out.println("afterEach 테스트 메소드 실행후 실행");
    }
}