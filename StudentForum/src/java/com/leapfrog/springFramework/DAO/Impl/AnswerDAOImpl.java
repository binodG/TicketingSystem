/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO.Impl;

import com.leapfrog.springFramework.DAO.AnswerDAO;
import com.leapfrog.springFramework.enitity.Answer;
import com.leapfrog.springFramework.enitity.Question;
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
@Repository(value="AnswerDAO")
public class AnswerDAOImpl implements AnswerDAO {
    @Autowired
    SessionFactory sessionFactory;
    Session session;
    Transaction trans;
    
    @Override
    public void insert(Answer t) {
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
    public List<Answer> getAnswers(int q_id)
    {
    try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT a FROM Answer a WHERE a.question.questionId=:id");
            query.setInteger("id",q_id);
            List<Answer> list = query.list();
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
