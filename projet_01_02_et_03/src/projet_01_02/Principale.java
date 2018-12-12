/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_01_02;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author trainer
 */
public class Principale {
    public static void main(String[] args) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.out.println("Etat session "+session.isOpen());
        Transaction tx = null;
        try {
            Client monClient = new Client();
            monClient.setNom("Test");
            tx = session.beginTransaction();
            session.save(monClient);
            tx.commit();
        }
        catch(Exception ex) {
            tx.rollback();
            throw ex;
        }
//        on peut s'en passer du close pour le currentsession : car on ça se fait lors 
//        du commit ou rollback et on n'a ajouté une config dans le fichier 'hibernate.cfg.xml
       /*finally {
            session.close();
        }*/
        System.out.println("Etat session "+session.isOpen());
        HibernateUtil.stop();

    }
}
