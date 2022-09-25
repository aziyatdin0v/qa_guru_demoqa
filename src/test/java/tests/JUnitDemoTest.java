package tests;

import org.junit.jupiter.api.*;

public class JUnitDemoTest {

    @BeforeAll
    static void setUp() {
        System.out.println("### @BeforeAll");

    }

    @AfterAll
    static void tearDown() {
        System.out.println("### @AfterAll");

    }

    @BeforeEach
    void beforeWEachTest() {
        System.out.println("###     @BeforeEach");
    }

    @AfterEach
    void afterWEachTest() {
        System.out.println("###     @AfterEach");
    }

    @Test
    void simpleTestFirst() {
        System.out.println("###         @simpleTestFirst");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void simpleTestSecond() {
        System.out.println("###         @simpleTestSecond");
        Assertions.assertTrue(3 > 2);
    }
}
