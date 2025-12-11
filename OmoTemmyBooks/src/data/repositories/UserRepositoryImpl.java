package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private int count;
    private List<User> users = new ArrayList<>();

    @Override
    public long count() {
        return (long) users.size();
    }
    @Override
    public User save(User user){
        if(isNew(user)) saveNew(user);
        else updateBook(user);

        return user;
    }

    private void saveNew(User user){
        count++;
        user.setUserId(count);
        users.add(user);
    }

    private boolean isNew(User user) {
        return user.getUserId() == 0;
    }
    private void updateBook(User user) {
        deleteById(user.getUserId());
        users.add(user);
    }

    public void delete(User user) {
        users.remove(user);
    }
    public User findById(int id) {
        for(User user : users){
            if(user.getUserId() == id) return user;
        }
        return null;
    }

    @Override
    public boolean  existById(int id) {
        for(User user : users){
            if(user.getUserId() == id) return true;
        }
        return false;
    }

    @Override
    public void deleteById(int id) {
        User user = findById(id);
        users.remove(user);
    }



}
