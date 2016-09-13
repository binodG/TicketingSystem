/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO.Impl;

import com.leapfrog.springFramework.DAO.FacultiesDAO;
import com.leapfrog.springFramework.enitity.faculties;
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
@Repository(value = "FacultiesDAO")
public class FacultiesDAOImpl implements FacultiesDAO {

    @Autowired
    SessionFactory sessionFactory;
    Session session;
    Transaction trans;

    @Override
    public void insert(faculties t) {
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
    public void update(faculties t) {
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
            faculties f=(faculties)session.get(faculties.class,id);
            session.delete(f);
            trans.commit();

        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }

    }

    @Override
    public void update(int id) {

    }

    @Override
    public faculties getByID(int id) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            faculties faculty = (faculties) session.get(faculties.class, id);

            if (faculty != null) {
                return faculty;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<faculties> getALL() {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("faculties.findAll");

            List<faculties> list = query.list();
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
    public List<faculties> getByParam(String param) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT f FROM faculties f WHERE f.facultyName like :name");
            query.setString("name", "%" + param + "%");
            List<faculties> list = query.list();
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
    public faculties CheckFaculty(String param) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
             Query query = session.getNamedQuery("faculties.findAll");
             List<faculties> list = query.list();
            if (list != null) {
                for (faculties f : list) {
                    if (f.getFacultyName().equalsIgnoreCase(param)) {
                        return f;
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

}
