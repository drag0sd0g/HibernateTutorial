package com.dragos.hibernatetutorial;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAOImpl implements UserDAO {

    @Autowired
    private org.hibernate.SessionFactory sessionFactory;

    @Override
    public void insertUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(int userId) {
        return (User) sessionFactory.
                getCurrentSession().
                get(User.class, userId);
    }

    @Override
    public User getUser(String username) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from user where username = :username");
        query.setParameter("username", username);
        return (User) query.list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(User.class);
        return criteria.list();
    }

    @Override
    public int deleteAllUsers() {
        String hql = String.format("delete from user");
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.executeUpdate();
    }

    @Override
    public void deleteUserById(int userId) {
        sessionFactory.getCurrentSession().delete(userId);
    }

}