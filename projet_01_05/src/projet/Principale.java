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
           
            Client unClient = new Client();
            unClient.setNom("rasori");
            Adresse adr1 = new Adresse();
            adr1.setVille("Saint-Georges");
            adr1.setCodepostal("27190");
            adr1.setLigne1("38, rue General De Gaulle");
            unClient.setAdresse(adr1);
           
            session.save(adr1);
            session.save(unClient);
          
            
            List<?> lesClients = session.createQuery("from Client").list();
            for (Object  o :lesClients){
               Client c  =(Client)o;
               System.out.println("Client "+c);
               System.out.println("Adresse : "+c.getAdresse());
            }
            
            tx.commit();
           
        }
        catch(Exception ex) {
            tx.rollback();
        }
        finally {
            session.close();
        }
        HibernateUtil.stop(); 
    }
}
