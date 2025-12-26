package data.repositories;

import data.models.Book;
import data.models.BookBorrowed;

import java.util.ArrayList;
import java.util.List;

public class BorrowedBookRepoImpl implements BorrowedBookRepository {

    private List<BookBorrowed> borrowedBooks = new ArrayList<>();
    int count = 0;

    @Override
    public long count() {
        return (long) borrowedBooks.size();
    }

    @Override
    public BookBorrowed save(BookBorrowed bookBorrowed){
        bookBorrowed.setBorrowedBookId(++count);
       borrowedBooks.add(bookBorrowed);
       return bookBorrowed;
    }
    @Override
    public void delete(BookBorrowed bookBorrowed) {
        borrowedBooks.remove(bookBorrowed);
    }

    @Override
    public BookBorrowed findById(int id) {
        for(BookBorrowed book : borrowedBooks){
            if(book.getUserId() == id) return book;
        }
        return null;
    }

    @Override
    public boolean  existById(int id) {
        for(BookBorrowed book : borrowedBooks){
            if(book.getBorrowedBookId() == id) return true;
        }
        return false;
    }

    @Override
    public void deleteById(int id) {
        BookBorrowed book = findById(id);
        borrowedBooks.remove(book);
    }
}
