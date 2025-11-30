package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
        MyArrayList list;
        @BeforeEach
        void setUp(){
            list = new MyArrayList();
        }

    @Test
    public void myArrayList_isEmpty_test() {
        assertTrue(list.isEmpty());
    }
    @Test
    public void addedOneElement_ListNotEmpty() {
        assertTrue(list.isEmpty());
        list.add("elements");
        assertFalse(list.isEmpty());
    }
    @Test
    public void addTwoElements_ListNotEmpty() {
        assertTrue(list.isEmpty());
        list.add("elements");
        list.add("second element");
        assertFalse(list.isEmpty());
    }
    @Test
    public void addTwoElements_ListNotEmpty_lastElementAddedToEndOfList() {
        list.add("elements");
        list.add("second element");
        assertFalse(list.isEmpty());
        assertEquals(1,list.lastElementIndex());

    }
    @Test
    public void addOneElement_removeOneElement_listIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("element");
        list.myRemove("element");
        assertTrue(list.isEmpty());

    }

    @Test
    public void AddTwoElements_removeOneElement_listIsNotEmpty() {
        assertTrue(list.isEmpty());
        list.add("element");
        list.add("second element");
        assertFalse(list.isEmpty());
        list.myRemove("second element");
        assertFalse(list.isEmpty());
    }
    @Test
    public void TestThatTwoElemenetsIsAdded_TwoRemoved_ListIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("element");
        list.add("second element");
        assertFalse(list.isEmpty());
        list.myRemove("second element");
        list.myRemove("element");
        assertTrue(list.isEmpty());
    }

   @Test
    public void testThatFiftyElementsCanBeAdded_ListIsNotEmpty() {
        assertTrue(list.isEmpty());
        for(int count = 1; count <= 100; count++){
            list.add("element" + count);
        }
        assertFalse(list.isEmpty());
    }
    @Test
    public void TestMyRemoveDoesNotRemoveElementNotInMyArrayList() {
        assertTrue(list.isEmpty());
        list.add("element");
        assertFalse(list.isEmpty());
        assertFalse(list.myRemove("third element"));
        assertFalse(list.myRemove("second element"));
    }
    @Test
    public void testThatAnElementCaneRemovedByItIndex(){
     assertTrue(list.isEmpty());
     list.add("element");
     list.add("second element");
     list.add("third element");
     list.myRemove(1);
     assertEquals("third element", list.get(1));
    }
    @Test
    public void testThatExceptionIsThrown_attemptToGetAnEmptyArraYList(){
        assertThrows(IllegalArgumentException.class, () -> list.get(0));

    }
    @Test
    public void testThatAnElementCanBeRemovedByIndex_sizeOMyListChanges(){
     assertTrue(list.isEmpty());
     list.add("element");
     list.add("second element");
     list.add("third element");
     list.myRemove(1);
     assertEquals("third element", list.get(1));
     assertEquals(2, list.size());
   }
    @Test
    public void testthatTheSizeOfArrayListCanBeChecked(){
        assertTrue(list.isEmpty());
        list.add("element");
        list.add("second element");
        list.add("third element");
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
    }
    @Test
    public void   testThatElementCanBeAddedAtSpecificIndex(){
                      assertTrue(list.isEmpty());
        list.add("element");
        list.add("second element");
        list.add(1, "third element");
        assertEquals("third element", list.get(1));

    }
   @Test
   public void testThatElementCanBeCheckedIfItIsInTheList(){
         assertTrue(list.isEmpty());
         list.add("element");
         list.add("second element");
        assertTrue(list.contains("second element"));
    }

   @Test
   public void testThatElementCanBeCheckedIfItIsNotInTheList(){
         assertTrue(list.isEmpty());
        list.add("element");
        list.add("second element");
        assertFalse(list.contains("third element"));
  }





}