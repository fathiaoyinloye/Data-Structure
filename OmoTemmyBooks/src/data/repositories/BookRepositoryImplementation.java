package data.repositories;

import data.models.Book;
import exceptions.BookExceptions.InvalidIdException;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImplementation implements BookRepository {
    private  List <Book> books = new ArrayList<>();
    private int count;

    @Override
    public Long count() {
        return (long) books.size();

    }


    //@Override
   /* public Book save(Book book) {
        boolean isThere = false;
        for(Book bookCheck : books){
            if(bookCheck.getId() == book.getId()){
                isThere = true;
                book = bookCheck;
            }
        }
        if(!isThere) {
            count++;
            book.setId(count);
            books.add(book);
        }
        return book;
    }*/
    @Override
  public Book save(Book book){
        if(isNew(book)) saveNew(book);
        else updateBook(book);

        return book;
         }

   public void saveNew(Book book){
            count++;
            book.setId(count);
            books.add(book);
    }


    private boolean isNew(Book book) {
        return book.getId() == 0;
    }

    private void updateBook(Book book) {
        deleteById(book.getId());
        books.add(book);
    }



    @Override
    public void delete(Book book) {
        books.remove(book);

    }

    @Override
    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
         }
        return null;
    }



    public boolean existById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return true;
        }

        return false;
    }

    public void deleteById(int id) {
        Book book = findById(id);
        books.remove(book);

    }
}
