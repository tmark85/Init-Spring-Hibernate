/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author trainer
 */
public class Principale {
    public static void main(String[] args) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        Transaction tx = null;
        try {
            
            tx = session.beginTransaction();
            
            List<?> resultats = session.createQuery("from Client").list();
                        
            tx.commit();
            
            for (Object c : resultats) {
                System.out.println(c);
            }
            
            Client monClient = (Client) resultats.get(0);
            System.out.println(monClient.getId());
        }
        catch(Exception ex) {
            tx.rollback();
            throw ex;
        }
        finally {
            session.close();
        }
        HibernateUtil.stop();
    }
}
