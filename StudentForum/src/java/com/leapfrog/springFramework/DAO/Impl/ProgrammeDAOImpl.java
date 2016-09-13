/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO.Impl;

import com.leapfrog.springFramework.DAO.ProgrammeDAO;
import com.leapfrog.springFramework.enitity.Programme;
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
@Repository(value = "ProgrammeDAO")
public class ProgrammeDAOImpl implements ProgrammeDAO {
    @Autowired
    SessionFactory sessionFactory;
    Session session;
    Transaction trans;
    @Override
    public void insert(Programme t) {
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
    public void update(Programme t) {
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
            Programme p=(Programme)session.get(Programme.class,id);
            session.delete(p);
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
    public Programme getByID(int id) {
    try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Programme p=(Programme)session.get(Programme.class,id);
            
            if (p != null) {
                return p;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public List<Programme> getByParam(String param) {
       try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT p FROM Programme p WHERE p.programmeName like :name");
            query.setString("name", "%" + param + "%");
            List<Programme> list = query.list();
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
    public List<Programme> getALL() {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("Programme.findAll");

            List<Programme> list = query.list();
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
    
    public List<Programme> getAllByFacId( int id)
    {
      try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT p FROM Programme p WHERE p.faculty.facultyId=:id");
            query.setParameter("id",id);
            List<Programme> list = query.list();
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
    public Programme CheckProgramme(String param) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
             Query query = session.getNamedQuery("Programme.findAll");
             List<Programme> list = query.list();
            if (list != null) {
                for (Programme p : list) {
                    if (p.getProgrammeName().equalsIgnoreCase(param)) {
                        return p;
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
