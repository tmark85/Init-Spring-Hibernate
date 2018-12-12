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
                      
            Client c = (Client) session.load(Client.class, 1);
                       
            
            System.out.println("Client "+c);
            System.out.println("Adresse : "+c.getAdresse());
            for(Object f : c.getFactures()) {
                  System.out.println("Facture : "+f);
              }
           
            
            tx.commit();
           
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
