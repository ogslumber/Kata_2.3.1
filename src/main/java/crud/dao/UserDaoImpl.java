package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> get() {
        return em.createQuery("select u from User u").getResultList();
    }

    @Override
    public User get(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public void remove(long id) {
        em.createQuery("delete from User u where u.id = :userId")
                .setParameter("userId", id)
                .executeUpdate();
    }

    @Override
    public void update(long id, User user) {
        User dbUser = em.find(User.class, id);
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        dbUser.setEmail(user.getEmail());
    }
}
