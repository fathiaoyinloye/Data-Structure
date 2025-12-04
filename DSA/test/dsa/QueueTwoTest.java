package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTwoTest {

    QueueTwo queue;
    @BeforeEach
    void setUp() {
        queue = new QueueTwo();
    }
    @Test
    public void testThatQueueIsEmpty() {
        assertTrue(queue.isEmpty());


    }
    @Test
    public void testThatElementXAdded_stackNotEmpty() {
        assertTrue(queue.isEmpty());
        assertTrue(queue.myOffer("element"));
        assertFalse(queue.isEmpty());


    }

    @Test
    public void addElementXYToMyQueue_QueueIsNotEmpty() {
        assertTrue(queue.isEmpty());
        assertTrue(queue.myOffer("element"));
        assertTrue(queue.myOffer("second element"));
        assertFalse(queue.isEmpty());

    }

    @Test
    public void addElementX_pollElementX_queueIsEmpty() {
        MyQueue queue = new MyQueue();
        assertTrue(queue.isEmpty());
        assertTrue(queue.myOffer("element"));
        queue.myPoll();
        assertTrue(queue.isEmpty());
    }
    @Test
    public void addElementXY_pollElementX_queueIsNotEmpty() {
        assertTrue(queue.isEmpty());
        queue.myOffer("X");
        queue.myOffer("Y");
        queue.myPoll();
        assertFalse(queue.isEmpty());
    }
    @Test
    public void addElementXY_pollElementX_queueIsNotEmpty_removedFirstElement() {
        assertTrue(queue.isEmpty());
        queue.myOffer("X");
        queue.myOffer("Y");
        assertFalse(queue.isEmpty());
        assertEquals("X", queue.myPoll());
    }
    @Test
    public void addElementXYZ_offerElementXY_queueIsNotEmpty_pollReturnsFirstElement() {
        assertTrue(queue.isEmpty());
        queue.myOffer("X");
        queue.myOffer("Y");
        queue.myOffer("Z");
        queue.myPoll();
        assertEquals("Y", queue.myPoll());
    }
    @Test
    public void queueIsEmpty_pollElementXFromMyQueue_ReturnsNull() {
        assertTrue(queue.isEmpty());
        assertNull(queue.myPoll());
    }
    @Test
    public void testThatMyOfferReturnsFalseWhenItsFull(){
        assertTrue(queue.isEmpty());
        queue.myOffer("W");
        queue.myOffer("X");
        queue.myOffer("Y");
        queue.myOffer("Z");
        queue.myOffer("W");
        assertFalse(queue.myOffer("X"));

    }
    @Test
    public void addElementX_removeElementX_queueIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.myOffer("X");
        assertFalse(queue.isEmpty());
        assertEquals("X", queue.remove());
        assertTrue(queue.isEmpty());

    }
    @Test
    public void addElementXY_removeElementX_queueIsNotEmpty_removedFirstElement() {
        assertTrue(queue.isEmpty());
        queue.myAdd("X");
        queue.myAdd("Y");
        assertFalse(queue.isEmpty());
        String actual = queue.remove();
        assertEquals("X", actual);
    }

    @Test
    public void testThatRemovedThrowsExceptionWhenQueueIsEmpty(){
        assertTrue(queue.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> queue.remove());
    }

    @Test
    public void testThatmyAddThrowsExceptionWhenQueueIsFilled(){
        assertTrue(queue.isEmpty());
        queue.myAdd("X");
        queue.myAdd("Y");
        queue.myAdd("Z");
        queue.myAdd("W");
        queue.myAdd("X");
        assertThrows(IllegalArgumentException.class, () -> queue.myAdd("P"));
    }
    @Test
    public void testThatFirstElementCanBeChecked(){
        assertTrue(queue.isEmpty());
        queue.myOffer("X");
        queue.myOffer("Y");
        queue.myOffer("Z");
        assertEquals("X", queue.element());
    }
    @Test
    public void testThatElementThrowsExceptionWhenQueueIsEmpty(){
        assertTrue(queue.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> queue.element());
    }

    @Test
    public void testThatFirstElementCanBePeeked(){
        assertTrue(queue.isEmpty());
        queue.myOffer("X");
        queue.myOffer("Y");
        queue.myOffer("Z");
        assertEquals("X", queue.peek());
    }
    @Test
    public void testThatPeekReturnNullWhenQueueIsEmpty(){
        assertTrue(queue.isEmpty());
        assertEquals(null,queue.peek());
    }

    @Test
    public void testThatRemoveWorksTheWayItShould() {
        assertTrue(queue.isEmpty());
        queue.myOffer("X");
        queue.myOffer("Y");
        queue.myOffer("Z");
        System.out.println(Arrays.toString(queue.getElements()));
        assertEquals("X", queue.remove());
        queue.remove();
        System.out.println(Arrays.toString(queue.getElements()));
       // queue.remove();
        System.out.println(Arrays.toString(queue.getElements()));
        //assertEquals("Y", queue.remove());
        queue.myOffer("W");
        System.out.println(Arrays.toString(queue.getElements()));



    }

}
