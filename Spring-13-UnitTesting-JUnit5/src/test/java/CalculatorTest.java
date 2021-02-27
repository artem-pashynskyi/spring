import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUpEach() {
        System.out.println("--BeforeEach has been executed");
    }

    @AfterEach
    void TearDownEach() {
        System.out.println("--AfterEach has been executed");
    }

    @BeforeAll
    static void setUpAll() {
        System.out.println("--BeforeAll has been executed");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("--AfterAll has been executed");
    }

    @Test
    void add() {
        System.out.println("Test add() has been executed");
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual);
    }

    @Test
    void testAssertEquals() {
        System.out.println("Test testAssertEquals() has been executed");
        assertEquals(1, 1);
    }

    @Test
    void testAssertTrue() {
        System.out.println("Test testAssertTrue() has been executed");
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testAssertArrayEquals() {
        System.out.println("Test testAssertArrayEquals() has been executed");
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }

    @Test
    void testAssertNotNullAndAssertNull() {
        System.out.println("Test testAssertNotNullAndAssertNull() has been executed");
        String str = "Hello";
        assertNotNull(str);
        assertNull(null);
    }

    @Test
    void testAssertNotSame() {
        System.out.println("Test testAssertNotSame() has been executed");
        assertNotSame(new Calculator(), new Calculator());
    }

}