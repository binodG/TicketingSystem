/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO.Impl;

import com.leapfrog.springFramework.DAO.CourseDAO;
import com.leapfrog.springFramework.enitity.Course;
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
@Repository(value = "CourseDAO")
public class CourseDAOImpl implements CourseDAO {
    @Autowired
    SessionFactory sessionFactory;
    Session session;
    Transaction trans;
    
    @Override
    public void insert(Course t) {
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
    public void update(Course t) {
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
            Course p=(Course)session.get(Course.class,id);
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
    public Course getByID(int id) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Course c=(Course)session.get(Course.class,id);
            
            if (c != null) {
                return c;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
     return null;
    }

    @Override
    public List<Course> getByParam(String param) {
       try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT c FROM Course c WHERE c.courseName like :name");
            query.setString("name", "%" + param + "%");
            List<Course> list = query.list();
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
    public List<Course> getALL() {
       try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("Course.findAll");

            List<Course> list = query.list();
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
    public List<Course> getCoursesBySem(int param) {
       try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT c FROM Course c WHERE c.semester=:sem");
            query.setParameter("sem",param);
            List<Course> list = query.list();
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
    public Course CheckCourse(String param) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
             Query query = session.getNamedQuery("Course.findAll");
             List<Course> list = query.list();
            if (list != null) {
                for (Course c : list) {
                    if (c.getCourseName().equalsIgnoreCase(param)) {
                        return c;
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
