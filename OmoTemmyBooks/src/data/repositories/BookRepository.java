package data.repositories;
import data.models.Book;

public interface BookRepository {
    public Long count();

    public Book save(Book book);

    public void delete(Book book);

    public Book findById(int id);


   public boolean existById(int i);

   public void deleteById(int id);
}
