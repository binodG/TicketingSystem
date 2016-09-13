/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO.Impl;

import com.leapfrog.springFramework.DAO.QuestionDAO;
import com.leapfrog.springFramework.enitity.Question;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="QuestionDAO")
public class QuestionDAOImpl implements QuestionDAO {
    @Autowired
    SessionFactory sessionFactory;
    Session session;
    Transaction trans;

    @Override
    public void insert(Question t) {
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
    public void update(Question t) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void update(int id) {
    }

    @Override
    public Question getByID(int id) {
     try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Question q=(Question)session.get(Question.class,id);
            
            if (q != null) {
                return q;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
     return null;
    
    }

    @Override
    public List<Question> getByParam(String param) {
      try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT q FROM Question q WHERE q.title like :param or q.question like :param or q.tags like :param ORDER BY q.submittedDate Desc");
            query.setString("param", "%" + param + "%");
            List<Question> list = query.list();
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
    public List<Question> getALL() {
     try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("Question.findAllByDate");

            List<Question> list = query.list();
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
    public List<Question> getByUserId(int id) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT q FROM Question q WHERE q.user.userId=:id");
            query.setInteger("id",id);
            List<Question> list = query.list();
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
    
    
    
}
