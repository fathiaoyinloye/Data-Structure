package dsa;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    MyStack strings;
    @BeforeEach
    void setup() {
        strings = new MyStack();

    }
    @Test
    public void testThat_StackIsEmpty(){
        assertTrue(strings.isEmpty());

    }
    @Test
    public void testAddOneElementToStack_StackIsNotEmpty(){
        strings.push("myElement");
        assertFalse(strings.isEmpty());
}
    @Test
    public void testAddTwoElementToStack_MyStackNotEmpty(){
        strings.push("myElement");
        strings.push("secondElement");
        assertFalse(strings.isEmpty());
}
    @Test
    public void pushIntoMyStack_popOutOfMyStack_MyStackEmpty(){
        assertTrue(strings.isEmpty());
        strings.push("myElement");
        assertFalse(strings.isEmpty());
        strings.pop();
        assertTrue(strings.isEmpty());
    }

    @Test
    public void addTwoElements_popOneElement_StackIsNotEmpty(){
        assertTrue(strings.isEmpty());
        strings.push("myElement");
        strings.push("secondElement");
        assertFalse(strings.isEmpty());
        strings.pop();
        assertFalse(strings.isEmpty());

    }


    @Test
    public void testThatAddTwoElements_popOneElement_MyStackNotEmpty_popLastElement(){
        assertTrue(strings.isEmpty());
        strings.push("myElement");
        strings.push("secondElement");
        assertFalse(strings.isEmpty());
        assertEquals("secondElement", strings.pop());
    }

    @Test
    public void testAddTwoElements_popTwoElements_MyStackIsEmpty_popFirstElement(){
        assertTrue(strings.isEmpty());
        strings.push("myElement");
        strings.push("secondElement");
        assertFalse(strings.isEmpty());
        strings.pop();
        assertEquals("myElement", strings.pop());
        assertTrue(strings.isEmpty());
    }
    @Test
    public void testThatExceptionIsThrownWhenStackIsFull(){
        assertTrue(strings.isEmpty());
        strings.push("myElement");
        strings.push("secondElement");
        strings.push("thirdElement");
        strings.push("fourthElement");
        strings.push("fifthElement");
        assertFalse(strings.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> strings.push("sixthElement"));
    }
    @Test
    public void testPopThrowsException_whenStackIsEmpty(){
        assertTrue(strings.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> strings.pop());
    }

    @Test
    public void testPeek_lastElementInTheStack(){
        assertTrue(strings.isEmpty());
        strings.push("myElement");
        assertEquals(strings.peek(), "myElement");
    }
    @Test
    public void testAddXY_peekReturnsY(){
        assertTrue(strings.isEmpty());
        strings.push("myElement");
        strings.push("secondElement");

        assertEquals(strings.peek(), "secondElement");
    }























}
