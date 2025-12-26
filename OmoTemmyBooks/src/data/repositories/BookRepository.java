package data.repositories;
import data.models.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookRepository {
     Long count();

     Book save(Book book);

     void delete(Book book);

     Book findById(int id);


    boolean existById(int i);

    void deleteById(int id);
    List<Book> findAll();

}
