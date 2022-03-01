package crud.service;

import crud.dao.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> get() {
        return dao.get();
    }

    @Override
    public User get(long id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public void create(User user) {
        dao.create(user);
    }

    @Override
    @Transactional
    public void remove(long id) {
        dao.remove(id);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        dao.update(id, user);
    }
}
