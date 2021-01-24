import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class GreetingTest {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("==== Before this class ====\n");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("==== After this Class ====\n");
    }

    @BeforeEach
    public void before() {
        System.out.println("==== Before every test ====");
    }

    @AfterEach
    public void after() {
        System.out.println("==== After every test ====\n");
    }

    @Test
    public void test1() {
        System.out.println("Test1 is testing now...");

        String name = "Cristiano Ronaldo";
        Greeting.greeting("Cristiano Ronaldo");

        assertThat(Greeting.greeting(name), is("Hello, " + name));
    }

    @Test
    public void test2() {
        System.out.println("Test2 is testing now...");

        String name = "cristiano";
        Greeting.greeting("Cristiano Ronaldo");

        assertThat(Greeting.greeting(name), not("hello, " + name));
    }
}
