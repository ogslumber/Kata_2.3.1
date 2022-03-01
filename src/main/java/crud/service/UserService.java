package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    List<User> get();
    void remove(long id);
    void update(long id, User user);
    User get(long id);
    void create(User user);
}
