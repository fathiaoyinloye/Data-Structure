package data.repositories;

import data.models.Book;
import data.models.BookBorrowed;

public interface BorrowedBookRepository{
    public long count();

    public BookBorrowed save(BookBorrowed bookBorrowed);

    public void delete(BookBorrowed bookBorrowed);

   public BookBorrowed findById(int id);


    public boolean existById(int i);

    public void deleteById(int id);

}
