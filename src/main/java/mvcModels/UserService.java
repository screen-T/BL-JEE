package mvcModels;

import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class UserService {

	 @PersistenceContext(unitName="bloggyV4")
	 private EntityManager entityManager;

    @Transactional
    //to fix register from here later
    public boolean register(User user) {
        if (user == null) {
            return false;
        }
        if (getUserByUsername(user.getUsername()) != null) {
            return false;
        }
        entityManager.persist(user);
        return true;
    }

    public User login(String cin) {
        if (cin == null ) {
            return null;
        }
        List<User> users = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.cin = :cin", User.class)
                .setParameter("cin", cin)
                .getResultList();
        if (users.isEmpty()) {
            return null;
        }
        System.out.println(users.get(0));
        return users.get(0);
        
    }

    public User getUserByUsername(String username) {
        List<User> users = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }
}
