/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO.Impl;

import com.leapfrog.springFramework.DAO.ModalPapersDAO;
import com.leapfrog.springFramework.enitity.ModalPapers;
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
@Repository(value = "ModalPapersDAO")
public class ModalPapersDAOImpl implements ModalPapersDAO {
@Autowired
    SessionFactory sessionFactory;
    Session session;
    Transaction trans;


    @Override
    public void insert(ModalPapers t) {
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
    public void update(ModalPapers t) {
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
            ModalPapers m=(ModalPapers)session.get(ModalPapers.class,id);
            session.delete(m);
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
    public ModalPapers getByID(int id) {
               try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            ModalPapers m=(ModalPapers)session.get(ModalPapers.class,id);
            
            if (m != null) {
                return m;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        } finally {
            session.close();
        }
     return null;
   

    }

    @Override
    public List<ModalPapers> getByParam(String param) {
    try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT m FROM ModalPapers m WHERE m.ModalPapers like :name");
            query.setString("name", "%" + param + "%");
            List<ModalPapers> list = query.list();
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
    public List<ModalPapers> getALL() {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.getNamedQuery("ModalPapers.findAll");

            List<ModalPapers> list = query.list();
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
    public List<ModalPapers> getByUserId(int param) {
    try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT m FROM ModalPapers m WHERE m.user.userId=:id");
            query.setParameter("id", param);
            List<ModalPapers> list = query.list();
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
    public List<ModalPapers> getByCourseId(int param) {
    try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT m FROM ModalPapers m WHERE m.course.courseId=:id");
            query.setParameter("id", param);
            List<ModalPapers> list = query.list();
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
    public ModalPapers CheckModal(String param) {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
             Query query = session.getNamedQuery("ModalPapers.findAll");
             List<ModalPapers> list = query.list();
            if (list != null) {
                for (ModalPapers m : list) {
                    if (m.getModalName().equalsIgnoreCase(param)) {
                        return m;
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
    public int coutModals() {
        try {
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
             Query query = session.getNamedQuery("ModalPapers.findAll");
             List<ModalPapers> list = query.list();
             int count=0;
            if (list != null) {
                for (ModalPapers m : list) {
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
