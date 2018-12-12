/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import org.hibernate.*;

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
                       
            Livre l1 = new Livre("Les filles et leurs mères","Aldo Naouri");
            Livre2 l2 = new Livre2("Filles et leurs mERE","Aldo TEST");
            Revue r1 = new Revue("Les filles et leurs mères","Aldo Naouri");
            Revue2 r2 =  new Revue2("Filles et leurs mERE","Aldo TEST");
            Magazine m1 = new Magazine("Les filles et leurs mères","Aldo Naouri");
            Magazine2 m2 =  new Magazine2("Filles et leurs mERE","Aldo TEST");
            
            session.save(l1);           
            session.save(l2);
            session.save(r1);           
            session.save(r2);
            session.save(m1);           
            session.save(m2);
                        
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
