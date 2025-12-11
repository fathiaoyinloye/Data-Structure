package services;

import data.models.Book;
import data.repositories.BookRepository;
import data.repositories.BookRepositoryImplementation;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import utils.Mapper;

import static utils.Mapper.mapBookRequest;
import static utils.Mapper.mapBookResponse;

public class BookServicesImpl implements BookService {
    private BookRepository bookRepository;


    public BookServicesImpl(BookRepository bookRepositoryImplementation) {
        this.bookRepository = bookRepositoryImplementation;
    }

    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
        Book book = mapBookRequest(addBookRequest);
        bookRepository.save(book);
        return mapBookResponse(book);
    }
   /* private void validate(AddBookRequest addBookRequest) {
        Book book = mapBookRequest(addBookRequest);
        for(Book bookSaved: bookRepository)
        if (book.getTitle().equals(bookSaved.getTitle()))
    }*/



}


