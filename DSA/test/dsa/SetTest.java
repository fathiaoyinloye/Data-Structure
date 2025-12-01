package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SetTest {
    MySet set;
    @BeforeEach
    public void setup(){
        set = new MySet();
    }

    @Test
    public void testThatSetIsEmpty(){
        assertTrue(set.isEmpty());
    }
    @Test
    public void testThatSetIsEmpty_ItsSizeIsZero(){
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }
    @Test
    public void addElementX_SetIsNotEmpty(){
        assertTrue(set.isEmpty());
        assertTrue(set.add("X"));
        assertFalse(set.isEmpty());
    }
    @Test
    public void addElementXY_SetIsNotEmpty_ItsSizeIsTwo(){
        assertTrue(set.isEmpty());
        assertTrue(set.add("X"));
        assertTrue(set.add("Y"));
        assertFalse(set.isEmpty());
        assertEquals(2, set.size());
    }
    @Test
    public void testThatSameElementCannotBeAddedTwice_sizeRemainedOne(){
        assertTrue(set.isEmpty());
        assertTrue(set.add("X"));
        assertFalse(set.add("X"));
        assertEquals(1, set.size());

    }
    @Test
    public void testThatElementXYCanBeAdded_ElementXCanBeRemoved(){
        assertTrue(set.isEmpty());
        assertTrue(set.add("X"));
        assertTrue(set.add("Y"));
        assertTrue(set.add("Z"));
        assertEquals(3, set.size());
        assertTrue(set.remove("X"));
        assertEquals(2, set.size());

    }
    @Test
    public void testThatElementXYCanBeAdded_andRemoved(){
        assertTrue(set.isEmpty());
        assertTrue(set.add("X"));
        assertTrue(set.add("Y"));
        assertEquals(2, set.size());
        assertTrue(set.remove("Y"));
       assertTrue(set.remove("X"));
        assertEquals(0, set.size());

    }
    @Test
    public void testThatOnlyElementInTheSetCanBeRemoved(){
        assertTrue(set.isEmpty());
        assertTrue(set.add("X"));
        assertTrue(set.add("Y"));
        assertFalse(set.remove("T"));
        assertEquals(2, set.size());
    }

    @Test
    public void testThatMySetContainsAnElement(){
        assertTrue(set.add("X"));
        assertTrue(set.add("Y"));
        assertTrue(set.contains("Y"));
    }
    @Test
    public void testThatMySetDoesNotContainsAnElement(){
        assertTrue(set.add("X"));
        assertTrue(set.add("Y"));
        assertFalse(set.contains("C"));
    }
    @Test
    public void testThatMySetCanBeCleared(){
        assertTrue(set.isEmpty());
        assertTrue(set.add("X"));
        assertTrue(set.add("Y"));
        assertFalse(set.isEmpty());
        set.clear();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());

    }
    @Test
    public void testThatYouCanAddMoreThanTwentyElementToSet(){
        assertTrue(set.isEmpty());
        for(int count = 0; count < 20; count++){
            assertTrue(set.add(String.valueOf(count)));
        }
        assertFalse(set.isEmpty());
    }
    @Test
    public void testThatYouCanAddAndRemoveMoreThanTwentyElementTo() {
        assertTrue(set.isEmpty());
        for (int count = 0; count < 20; count++) {
            assertTrue(set.add(String.valueOf(count)));
        }
        assertFalse(set.isEmpty());
        for (int count = 0; count < 20; count++) {
            assertTrue(set.remove(String.valueOf(count)));
        }
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    }
