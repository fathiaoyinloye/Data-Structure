package utils;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public class Mapper {
    public static Book mapBookRequest(AddBookRequest addBookRequest) {
        Book book =  new Book();
        book.setAuthor(addBookRequest.getAuthor());
        book.setIsbn(addBookRequest.getIsbn());
        book.setEdition(addBookRequest.getEdition());
        book.setGenre(addBookRequest.getGenre());
        book.setDescription(addBookRequest.getDescription());
        book.setQuantity(addBookRequest.getQuantity());
        book.setPages(addBookRequest.getPages());
        book.setTitle(addBookRequest.getTitle());
        return book;
    }
    public static AddBookResponse mapBookResponse(Book book) {
        AddBookResponse addBookResponse = new AddBookResponse();
        addBookResponse.setAuthor(book.getAuthor());
        addBookResponse.setQuantity(book.getQuantity());
        addBookResponse.setId(book.getId());
        addBookResponse.setTitle(book.getTitle());
        return addBookResponse;
    }

}
