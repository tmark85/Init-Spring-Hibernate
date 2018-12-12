/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.*;


import org.springframework.stereotype.Repository;

/**
 *
 * @author trainer
 */
@Repository
public class ClientDAOImpl  implements ClientDAO{

   
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }
    
    public void store(Client c) {
     
          sessionFactory.getCurrentSession().saveOrUpdate(c);
      
    }

    public void delete(Integer id) {
    
          Client c = sessionFactory.getCurrentSession().get(Client.class, id);
          sessionFactory.getCurrentSession().delete(c);
      
    }

    public Client findById(Integer id) {
       
          return sessionFactory.getCurrentSession().get(Client.class, id);    
     
    }

    public List<Client> findAll() {
       
        TypedQuery<Client> requete = sessionFactory.getCurrentSession().createQuery("from Client");
        return requete.getResultList();
     
    }
    
}
