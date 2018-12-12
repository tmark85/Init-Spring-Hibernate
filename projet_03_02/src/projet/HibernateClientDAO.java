/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author trainer
 */
public class HibernateClientDAO  implements ClientDAO{

    private SessionFactory sessionFactory;
    
    public HibernateClientDAO() {
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public void stop() throws Exception {
        sessionFactory.close();
    }
    
    @Override
    public void store(Client c) {
      Session session = sessionFactory.openSession();
      Transaction tx = session.getTransaction();
           
      try {
          tx.begin();
          session.saveOrUpdate(c);
          tx.commit();
      }
      catch(RuntimeException e) {
          tx.rollback();
          throw e;
      }
      finally {
          session.close();
      }
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
      Transaction tx = session.getTransaction();
           
      try {
          tx.begin();
          Client c = session.get(Client.class, id);
          session.delete(c);
          tx.commit();
      }
      catch(RuntimeException e) {
          tx.rollback();
          throw e;
      }
      finally {
          session.close();
      }
    }

    @Override
    public Client findById(Integer id) {
      Session session = sessionFactory.openSession();  
      try {      
          return session.get(Client.class, id);    
      }    
      finally {
          session.close();
      }
    }

    @Override
    public List<Client> findAll() {
        Session session = sessionFactory.openSession();
     
      try {
    	TypedQuery<Client> requete = session.createQuery("from Client");
        return requete.getResultList();
      }
      
      finally {
          session.close();
      }
    }
    
}
