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
            
            Adresse2 adresse = new Adresse2("38 rue Général de Gaulle","28190","Saint-Georges-sur-Eure");
            Client2 c = new Client2("Rasori",adresse);
            
            session.save(adresse);
            session.save(c);
            
            Client2 leClient = (Client2) session.load(Client2.class, 5);
            System.out.println("Client : "+leClient);
            System.out.println("Client : "+leClient.getAdresse());
            
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
