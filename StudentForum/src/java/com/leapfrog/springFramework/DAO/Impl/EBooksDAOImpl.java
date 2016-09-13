/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO.Impl;

import com.leapfrog.springFramework.DAO.EBooksDAO;
import com.leapfrog.springFramework.enitity.EBooks;
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
@Repository(value = "EBooksDAO")
public class EBooksDAOImpl implements EBooksDAO {
@Autowired
    SessionFactory sessionFactory;
    Session session;
    Transaction trans;

    @Override
    public void insert(EBooks t) {
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
    public void update(EBooks t) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.update(t);
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
            EBooks b=(EBooks)session.get(EBooks.class,id);
            session.delete(b);
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
    public EBooks getByID(int id) {
         try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            EBooks b=(EBooks)session.get(EBooks.class,id);
            
            if (b != null) {
                return b;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
     return null;
   
    }

    @Override
    public List<EBooks> getByParam(String param) {
       try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT b FROM EBooks b WHERE b.ebookName like :name");
            query.setString("name", "%" + param + "%");
            List<EBooks> list = query.list();
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
    public List<EBooks> getALL() {
      try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("EBooks.findAll");

            List<EBooks> list = query.list();
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
    public List<EBooks> getByUserId(int param) {
       try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT b FROM EBooks b WHERE b.user.userId=:id");
            query.setParameter("id",param);
            List<EBooks> list = query.list();
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
    public List<EBooks> getByCourseId(int param) {
       try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT b FROM EBooks b WHERE b.course.courseId=:id");
            query.setParameter("id",param);
            List<EBooks> list = query.list();
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
    public EBooks CheckBook(String param) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
             Query query = session.getNamedQuery("EBooks.findAll");
             List<EBooks> list = query.list();
            if (list != null) {
                for (EBooks b : list) {
                    if (b.getEbookName().equalsIgnoreCase(param)) {
                        return b;
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
    public int countBooks() {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
             Query query = session.getNamedQuery("EBooks.findAll");
             List<EBooks> list = query.list();
             int count=0;
            if (list != null) {
                for (EBooks b : list) {
                    count=count+1;
                }
            }
            return count;
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
        return 0;
        
     
    }

    
}
