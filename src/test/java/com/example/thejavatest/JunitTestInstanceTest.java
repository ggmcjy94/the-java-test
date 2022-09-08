package com.example.thejavatest;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(FindSlowTestExtension.class)
@DisplayName("테스트 인스턴스")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 상태 공유 properties 적용
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitTestInstanceTest {

    int value = 1;

//    @RegisterExtension // 이런 방법ㅇ 있다.
//    static FindSlowTestExtension findSlowTestExtension =
//            new FindSlowTestExtension(1000L);



    @BeforeAll
    void BeforeAll() {
        System.out.println("BeforeAll TestInstance 이부분 떄문에 static 일 필요가 없다 ");
    }
    @AfterAll
    void AfterAll() {
        System.out.println("AfterAll TestInstance 이부분 떄문에 static 일 필요가 없다 ");
    }

    @Order(2)
    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_net_study_01() {
        System.out.println(this);
        System.out.println(value++);
        Study actual = new Study(1);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }



    @Order(1) // 우선순위
    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_net_study_again() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println(this);
        System.out.println("create1 " + value++);
    }

}
