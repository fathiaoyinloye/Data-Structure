package data.repositories;

import data.models.User;

public interface UserRepository {
   public  long count();

    public User save(User user);

    void delete(User user);

    User findById(int id);

    boolean existById(int id);

    void deleteById(int id);
}
