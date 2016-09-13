/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO.Impl;

import com.leapfrog.springFramework.DAO.UserDAO;
import com.leapfrog.springFramework.enitity.Programme;
import com.leapfrog.springFramework.enitity.User;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BkoNod
 */
@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;
    Session session;
    Transaction trans;

    @Override
    public void insert(User t) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.save(t);
            trans.commit();

        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
        } finally {
            session.close();
        }

    }

    @Override
    public void update(User t) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(t);
            trans.commit();

        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(int id) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            User u = (User) session.get(User.class, id);
            session.delete(u);
            trans.commit();

        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }

    }

    @Override
    public void update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getByID(int id) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            User u = (User) session.get(User.class, id);

            if (u != null) {
                return u;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public List<User> getByParam(String param) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT u FROM User u WHERE u.firstName like :name or u.username like :name or u.email like :name");
            query.setString("name", "%" + param + "%");
            List<User> list = query.list();
            if (list != null) {

                return list;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public List<User> getALL() {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("User.findAll");

            List<User> list = query.list();
            if (list != null) {

                return list;

            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public User checkUsername(String username, String password) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("User.findAll");
            List<User> list = query.list();
            if (list != null) {
                for (User u : list) {
                    if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                        System.out.println(u.getUsername());

                        return u;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
        return null;

    }
    @Override
    public int countUsers(){
         try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("User.findAll");
            List<User> list=query.list();
            int count=0;
            if(list!=null)
            {
              for(User u:list)
              {
                count=count+1;
              }
              return count;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
       return 0;
    }

}
