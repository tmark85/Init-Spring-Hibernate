/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

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
            
            Client1 c = new Client1("Rasori");
            Client1 c2 = new Client1("Rasori2");
          
            session.save(c);
            session.save(c2);
            
            System.out.println("Client "+c);
                       
            tx.commit();
           
        }
        catch(Exception ex) {
            tx.rollback();
            throw ex;
        }
        finally {
            session.close();
            HibernateUtil.stop();
        }

    }
}
