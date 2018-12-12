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
            
            
            Adresse3 adresse = new Adresse3("38 rue Général De Gaulle","28190","Saint-Georges-sur-Eure");          
            Client3 c = new Client3("Rasori",adresse);
            Facture3 facture = new Facture3(c,31425.92);
         
            session.save(adresse);
            session.save(c);
            session.save(facture);
            
            
            Client3 leClient = (Client3)session.load(Client3.class, c.getId());
            
            System.out.println("Client : "+leClient);
            System.out.println("Adresse : "+leClient.getAdresse());
           for(Object f : leClient.getFactures()) {
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
            HibernateUtil.stop();  
        }
    }
}
