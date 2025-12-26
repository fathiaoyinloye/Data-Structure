package services;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.requests.RemoveBookRequest;
import dtos.responses.AddBookResponse;
import dtos.responses.RemoveBookResponse;
import dtos.responses.UpdateBookResponse;

public interface BookService {
   AddBookResponse addBook(AddBookRequest addBookRequest);
   //UpdateBookResponse updateBook(UpdateBookReqest updateBookReqest);
    RemoveBookResponse removeBook(RemoveBookRequest removeBookRequest);
}
