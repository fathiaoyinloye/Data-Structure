package data.repositories;

import data.models.Book;
import exceptions.BookExceptions.InvalidIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryImplementationTest {

        BookRepositoryImplementation bookRepository;

        @BeforeEach
        public void setup() {
            bookRepository = new BookRepositoryImplementation();
        }

        @Test
        public void testThatBookRepoitoryIncreaeses() {
            System.out.println(bookRepository.count());
           assertEquals(3, bookRepository.count());
        }

        @Test
        public void bookAIsSavedInTheBookRepository_countIsOne() {
            assertEquals(0, bookRepository.count());
            bookRepository.save(new Book());
            assertEquals(1, bookRepository.count());
        }

        @Test
        public void bookAIsSavedInTheBookRepository_countIOne_saveReturnBookSaved() {
            assertEquals(1, bookRepository.count());
            bookRepository.save(new Book());
            assertEquals(2, bookRepository.count());
            assertNotNull(bookRepository.save(new Book()));
        }

        @Test
        public void bookAandBIsSavedInTheBookRepository_countIsTwo_bookIsDeleted_countIsZero() {
            assertEquals(3, bookRepository.count());
            Book firstBook = new Book();

            bookRepository.save(firstBook);
            assertEquals(4, bookRepository.count());
            bookRepository.delete(firstBook);
            assertEquals(3, bookRepository.count());
        }

       /* @Test
        public void bookIsSaved_bookIsFoundInTheBookRepository_countIsOne() {
            assertEquals(0, bookRepository.count());
            Book firstBook = new Book();
            assertEquals(firstBook, bookRepository.save(firstBook));
            assertEquals(firstBook, bookRepository.findById(1));
        }

        @Test
        public void bookAandBSaved_findBookCById_throwsException() {
            assertEquals(0, bookRepository.count());
            Book firstBook = new Book();
            assertEquals(firstBook, bookRepository.save(firstBook));
            Book secondBook = new Book();
            assertEquals(secondBook, bookRepository.save(secondBook));
            assertNull(bookRepository.findById(3));

        }

        @Test
        public void saveBookA_checkIfBookAIdExist() {
            assertEquals(0, bookRepository.count());
            Book firstBook = new Book();
            assertEquals(firstBook, bookRepository.save(firstBook));
            assertEquals(1, bookRepository.count());
            assertTrue(bookRepository.existById(1));
        }

        @Test
        public void saveBookA_checkIfBookBIdExist() {
            assertEquals(0, bookRepository.count());
            Book firstBook = new Book();
            assertEquals(firstBook, bookRepository.save(firstBook));
            assertEquals(1, bookRepository.count());
            assertFalse(bookRepository.existById(7));

        }
        @Test
        public void saveBookA_updateTheBook_ResaveTheBook() {
            assertEquals(0, bookRepository.count());
            Book firstBook = new Book();
            firstBook.setIsbn("123");
            assertEquals(firstBook, bookRepository.save(firstBook));
            firstBook.setIsbn("366");
            assertEquals(firstBook, bookRepository.save(firstBook));
            assertEquals(firstBook, bookRepository.findById(1));
            assertEquals("366",  firstBook.getIsbn());

        }*/

    }


