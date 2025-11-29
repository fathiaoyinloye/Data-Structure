package dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void myArrayList_isEmpty_test() {
        MyArrayList list = new MyArrayList();
        assertTrue(list.isEmpty());
    }
    @Test
    public void addedOneElement_ListNotEmpty() {
        MyArrayList list = new MyArrayList();
        assertTrue(list.isEmpty());
        list.add("elements");
        assertFalse(list.isEmpty());
    }
    @Test
    public void addTwoElements_ListNotEmpty() {
        MyArrayList list = new MyArrayList();
        assertTrue(list.isEmpty());
        list.add("elements");
        list.add("second element");
        assertFalse(list.isEmpty());
    }
    @Test
    public void addtwoelements_ListNotEmpty_lastElementAddedToEndOfList() {
        MyArrayList list = new MyArrayList();
        list.add("elements");
        list.add("second element");

        assertTrue(list.isEmpty());
    }
}
