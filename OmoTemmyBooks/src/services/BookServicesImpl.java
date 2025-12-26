package services;

import data.models.Book;
import data.repositories.BookRepository;
import data.repositories.BookRepositoryImplementation;
import dtos.requests.AddBookRequest;
import dtos.requests.RemoveBookRequest;
import dtos.responses.AddBookResponse;
import dtos.responses.RemoveBookResponse;
import exceptions.BookExceptions.BookAlreadyExistException;

import static utils.Mapper.mapBookRequest;
import static utils.Mapper.mapBookResponse;

public class BookServicesImpl implements BookService {
    private BookRepository bookRepository;


    public BookServicesImpl(BookRepository bookRepositoryImplementation) {
        this.bookRepository = bookRepositoryImplementation;
    }

    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
        validate(addBookRequest);
        Book book = mapBookRequest(addBookRequest);
        bookRepository.save(book);
        return mapBookResponse(book);
    }
   private void validate(AddBookRequest addBookRequest) {
       Book book = mapBookRequest(addBookRequest);
       for (Book bookSaved : bookRepository.findAll()) {
           if (book.getTitle().equals(bookSaved.getTitle()) && book.getAuthor().equals(bookSaved.getAuthor()))
               throw new BookAlreadyExistException("Book Already Exist");

       }


   }

    public RemoveBookResponse removeBook(RemoveBookRequest removeBookRequest){
        Book book = new Book();
        removeBookRequest.setAuthor("yh");




    }



}


