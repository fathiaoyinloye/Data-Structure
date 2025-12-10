package services;

import data.models.Book;
import data.repositories.BookRepositoryImplementation;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

import java.util.List;

public interface BookService {
  public AddBookResponse addBook(AddBookRequest addBookRequest);
  //List<Book> getBooks();
}
