package data.repositories;

import data.models.BookBorrowed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BorrowedBookRepoImplTest {

    BorrowedBookRepoImpl borrowedBookRepoImpl;

    @BeforeEach
    public void setUp() {
        borrowedBookRepoImpl = new BorrowedBookRepoImpl();
    }

    @Test
    public void testThatBorrowedBookRepoIsEmpty(){
        assertTrue(borrowedBookRepoImpl.count() == 0);
    }

    @Test
    public void testThatBookIsBorrowed_borrowedBookCountIsOne(){
        assertEquals(0, borrowedBookRepoImpl.count());
        borrowedBookRepoImpl.save(new BookBorrowed());
        assertEquals(1, borrowedBookRepoImpl.count());
    }
    @Test
    public void testThatBorrowedBookAsAnId(){
        assertEquals(0, borrowedBookRepoImpl.count());
        BookBorrowed bookBorrowed = new BookBorrowed();
        borrowedBookRepoImpl.save(bookBorrowed);
        assertEquals(1, borrowedBookRepoImpl.count());
        assertEquals(1, bookBorrowed.getBorrowedBookId());

    }

    @Test
    public void testThatBookIsBorrowed_bookBorrowedIsReturned(){
        assertEquals(0, borrowedBookRepoImpl.count());
        BookBorrowed bookBorrowed = new BookBorrowed();
        borrowedBookRepoImpl.save(bookBorrowed);
        assertEquals(1, borrowedBookRepoImpl.count());
        borrowedBookRepoImpl.delete(bookBorrowed);

    }

    @Test
    public void bookAandBisBorrowed_findBookCById_returnNull() {
        assertEquals(0, borrowedBookRepoImpl.count());
        BookBorrowed firstBook = new BookBorrowed();
        assertEquals(firstBook, borrowedBookRepoImpl.save(firstBook));
        BookBorrowed secondBook = new BookBorrowed();
        assertEquals(secondBook, borrowedBookRepoImpl.save(secondBook));
        assertNull(borrowedBookRepoImpl.findById(3));

    }

    @Test
    public void saveBookA_checkIfBookAIdExist() {
        assertEquals(0, borrowedBookRepoImpl.count());
        BookBorrowed firstBook = new BookBorrowed();
        assertEquals(firstBook, borrowedBookRepoImpl.save(firstBook));
        assertEquals(1, borrowedBookRepoImpl.count());
        assertTrue(borrowedBookRepoImpl.existById(1));
    }

    @Test
    public void saveBookA_checkIfBookBIdExist() {
        assertEquals(0, borrowedBookRepoImpl.count());
        BookBorrowed firstBook = new BookBorrowed();
        assertEquals(firstBook, borrowedBookRepoImpl.save(firstBook));
        assertEquals(1, borrowedBookRepoImpl.count());
        assertFalse(borrowedBookRepoImpl.existById(7));

    }    
}