package ru.onecommitman.springcourse.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.onecommitman.springcourse.model.User;

import java.util.List;


@Repository
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", id.intValue());
        return query.getSingleResult();
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User needsToUpdateUser = getUserById(id);
        needsToUpdateUser = entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }
}
