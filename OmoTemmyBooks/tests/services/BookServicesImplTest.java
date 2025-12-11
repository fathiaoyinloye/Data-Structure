package services;

import data.models.Book;
import data.models.Genre;
import data.repositories.BookRepository;
import data.repositories.BookRepositoryImplementation;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static data.models.Genre.COMEDY;
import static org.junit.jupiter.api.Assertions.*;

public class BookServicesImplTest {
 private BookService bookService;
    private BookRepository bookRepository;


    @BeforeEach
  public void setUp() {
        bookRepository = new BookRepositoryImplementation();
        bookService = new BookServicesImpl(bookRepository);
    }
    @Test
    public void testThatANewBookIsAdded_countIsOne(){
        AddBookRequest  request = new AddBookRequest();
        request.setIsbn("123");
        request.setAuthor("John Doe");
        request.setTitle("My Book");
        request.setDescription("My Book Description");
        request.setEdition(3);
        request.setPages(67_000);
        request.setGenre(COMEDY);
        request.setQuantity(14);
        AddBookResponse response = bookService.addBook(request);
        assertNotNull(response);
        assertEquals(1, bookRepository.count());
        System.out.println(response.getTitle());
        assertEquals("My Book", response.getTitle());


    }

}